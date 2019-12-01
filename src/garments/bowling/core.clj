(ns garments.bowling.core
  (:gen-class)
  )

(defn group-frames [rolls]
  (partition 2 rolls)
  )

(defn to-frame-scores [frames]
  )

(defn score
  [rolls]
  (reduce + (to-frame-scores (group-frames rolls)))
  )