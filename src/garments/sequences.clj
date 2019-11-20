(ns garments.sequences)

(defn seqf
  []
  (def colors (seq ["red" "green" "blue"]))
  (println colors)

  (println (cons "yellow" colors  ))
  (println (cons colors "yellow" ))

  (println (conj colors "yellow" ))                         ;;appends based on the data structure type, here at front
  (println (conj ["red" "green" "blue"] "yellow"))          ;;here, at end

  (println (concat colors (seq ["white" "black"]) ))          ;;here, as is

  (println (distinct (seq [1 2 3 45 6 2 3])))
  (println (reverse colors))
  (println (first colors))
  (println (rest colors))
  (println (last colors))

  (println (sort (seq [1 2 3 45 6 2 3])))
  )
(seqf)