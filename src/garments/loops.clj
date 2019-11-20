(ns garments.loops)


(defn looping
  []
  (println "\nLoop:")
  (loop [x 0]
    (when (< x 10)
      (println x)
      (recur (inc x))))
  )
(looping)

(defn dotimesx
  []
  (println "\ndotimes")
  (dotimes [x 10]
    (println x)
    )
  )
(dotimesx)

(defn whiledoit
  [count]
  (println "\nwhiledo")
  (def x (atom 0))
  (while (< @x count)
    (do
      (println @x)
      (swap! x inc))
    )
  )
(whiledoit 10)

(defn do-seq
  [seq]
  (println "\ndoseq")
  (doseq [x seq]
         (println (inc x))
         )
  )
(do-seq [1 2 3 4 5])







