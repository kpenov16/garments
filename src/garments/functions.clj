(ns garments.functions
  (:gen-class))

(defn -main
  "First function"
  []
  (println "My name is not Pernille")
  (println "Clojure is very cool")
  (+ 2 5))


#(println "hello" %)

(def increment (fn [x] (+ x 1)))

(defn increment-set
  [x]
  ;(map increment [1 2 3])
  (map increment x))