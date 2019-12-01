(ns garments.bowling.core
  (:gen-class)
  )

(defn score
  [rolls]
  (reduce + rolls)
  )