(defproject hack-listhost "0.1.0-SNAPSHOT"
  :description "Collect people's info for the hack@uchicago listhost"
  :url "http://hack.uchicago.edu/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [prismatic/plumbing "0.1.0"]
                 [org.clojure/data.csv "0.1.2"]]
  :main hack-listhost.core
  :profiles {:uberjar {:aot :all}})
