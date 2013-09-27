(ns hack-listhost.core
  (:gen-class)
  (:use [plumbing.core])
  (:require [plumbing.graph :as graph]
            [clojure.edn :as edn]
            [clojure.java.io :as jio]
            [clojure.data.csv :as csv]))

; A silly Plumbing graph that defines our control flow.
; A quirk in Plumbing requires the dummy 'start argument
(def fields-graph
  {:fullname (fnk [start]
                  (print "What's your UTF-8 encoded full name? ")
                  (flush)
                  (read-line))
   :listhost (fnk [fullname]
                  (let [ask (fn []
                              (print "Wanna be on our listhost? (true/false) ")
                              (flush)
                              (edn/read-string (read-line)))]
                    (loop [yn nil]
                      (if (= (type yn)
                             java.lang.Boolean)
                        yn
                        (recur (ask))))))
   :email (fnk [listhost]
               (let [ask (fn []
                           (print "What's your RFC 5321 & 5322 compliant email address? ")
                           (flush)
                           ; TODO: check RFC compliance
                           (read-line))]
                 (if listhost (ask) "")))})

(defnk write-record
  [[:data fullname listhost email] writer]
  (csv/write-csv writer [[fullname listhost email]]))

(defn -main
  [fname & args]
  ; We use Plumbing's eager compiler so that we have completed all interaction
  ; with the user before opening the filename for writing
  (let [ask (graph/eager-compile fields-graph)
        do-ask #(ask {:start true})]
    (loop [record (do-ask)]
      (with-open [f (jio/writer fname :append true)]
        (write-record {:data record :writer f}))
      (recur (do-ask)))))

