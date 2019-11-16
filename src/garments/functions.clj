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

(defn DataTypes []
  (def a 1)
  (def b 1.25)
  (def c 1.25e-12)
  (def d 0xfbfc)
  (def e nil)
  (def f true)
  (def g "hello")
  (def h 'thanks) ;;keyword as a reference

  (println a)
  (println b)
  (println c)
  (println d)
  (println e)
  (println f)
  (println g)
  (println h)

  )

(DataTypes)