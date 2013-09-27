# hack-listhost

A shiny new tool for collecting email addresses from people for [hack@uchicago](http://hack.uchicago.edu/). (Okay, so I was really bored tonight and wanted to learn a teensy bit of probably-non-idiomatic Clojure.)

### Installation

Git clone this repository if you're c00l. Otherwise download the JAR.

### Usage

If you're lazy like me and have Leiningen, use like so:

    $ lein run <filename>

If you're lazy unlike me and downloaded the JAR version, use like so:

    $ java -jar hack-listhost-0.1.0-standalone.jar <filename>

### Examples

For example, I like to run it like this:

    $ lein trampoline run my_super_database.csv

### Bugs

- No real input validation except a huge, expensive, generalized validator for the simplest input category (true/false input is parsed as [EDN](https://github.com/edn-format/edn) and is then type-checked to ensure it's boolean—if we're going to ask for permission, we ought to be certain we've got it!)
- No features
- Not enough data collected

## License

Copyright © 2013 Michael Victor Zink

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
