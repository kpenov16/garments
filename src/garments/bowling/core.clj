(ns garments.bowling.core
  (:gen-class)
  )

(defn group-frames [rolls]
  (into [] (partition 2 rolls))
  )

(defn spare? [frame]
  (and (= 10 (reduce + frame))
       (= 2 (count frame)))
  )
(defn spare-extra-score [remaining-frames]
  (first (first remaining-frames)))

(defn next-frame-score [[frame & other]]
  (let [simple-score (reduce + frame)]
    (if (spare? frame)
      (+ simple-score (spare-extra-score other))
      simple-score)))


(defn to-frame-scores [frames]
  (loop [remaining frames
         scores []]
    (if (empty? remaining)
      scores
      (recur (rest remaining)
             (conj scores (next-frame-score remaining))))))

(defn score
  [rolls]
  (reduce + (to-frame-scores (group-frames rolls)))
  )