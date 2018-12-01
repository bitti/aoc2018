(defproject aoc2017 "0.1.0-SNAPSHOT"
  :description "My attempts for Advent of Code 2018"
  :url "https://github.com/bitti/aoc2018"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]]
  :main ^:skip-aot aoc2018.core
  :target-path "target/%s"
  :profiles {:dev {:resource-paths ["test/resources"]}
             :uberjar {:aot :all}})
