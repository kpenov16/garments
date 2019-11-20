(ns garments.conditionals)

(defn condif
  []
  (println "\ncondif:")
  (if (= 5 6)
    (println "equal")
    (println "not equal"))
  )
(condif)

(defn condifdo
  []
  (if (= 5 6)
    (do (println "equal first statement")
        (println "equal second statement"))
    (do (println "not equal first statement")
        (println "not equal second statement"))
    )
  )
(condifdo)

(defn condnestif
  []
  (println "\nnested if")
  (if (and (= 5 5) (or (= 2 2) (not true)))
    (println "true")
    (println "false"))
  )
(condnestif)

(defn condcase
  [pet]
  (println "\ncondcase")
  (case pet
    "cat" (println "I have a cat")
    "dog" (println "I have a dog")
    "fish" (println "I have a fish")
    )
  )

(condcase "fish")

(defn condcond
  [amount]
  (println "\ncondcond")
  (cond
    (<= amount 2)  (println amount "is a little bit")
    (<= amount 10) (println amount "is kind of ok")
    (<= amount 100) (println amount "is a lot")
    :else (println amount "this is really a lot")
    )
  )

(condcond 500)























