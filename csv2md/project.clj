
(defproject csv2md "0.1.0-SNAPSHOT"
  :description "csv to markdown table. fork of John Gabriele's inlein script"
  :url "http://github.com/paultopia/csv2md"
  :dependencies [[org.clojure/clojure "1.8.0"] [org.clojure/data.csv "0.1.3"]]
  :main csv2md.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
