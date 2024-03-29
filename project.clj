(defproject garments "0.1.0-SNAPSHOT"
  :description "garments app to play with clojure"
  :url "http://mysmap.dk/"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"] 
                 [clj-http "2.0.0"]
                 [midje "1.9.9"]
                 [clj-http "3.10.0"]
                 [cheshire "5.9.0"]]
  :main ^:skip-aot garments.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
