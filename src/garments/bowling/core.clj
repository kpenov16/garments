(ns garments.bowling.core
  (:gen-class)
  )

(defn group-frames [rolls]
  (loop [remaining rolls
         frames []]
    (if (empty? remaining)
      frames
      (if (= 10 (first remaining))
          (recur (drop 1 remaining)
                 (conj frames (take 1 remaining)))
          (recur (drop 2 remaining)
                 (conj frames (take 2 remaining)))
          )
      ))
  )

(defn spare? [frame]
  (and (= 10 (reduce + frame))
       (= 2 (count frame)))
  )
(defn spare-extra-score [remaining-frames]
  (first (first remaining-frames)))

(defn strike-extra-score [remaining-frames]
  (reduce + (take 2 (flatten remaining-frames))))

(defn next-frame-score [[frame & other]]
  (let [simple-score (reduce + frame)]
     (if (= 10 (first frame))
       (+ simple-score (strike-extra-score other))
       (if (spare? frame)
      (+ simple-score (spare-extra-score other))
      simple-score)) ))


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