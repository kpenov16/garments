(ns garments.atoms)

;; atoms are thread safe, hmm lets see what that means

(defn a-toms
  []
  (def amount (atom 100))
  (println @amount)
  (swap! amount inc)    ;; no other threads can write to amount on this swap, if this happen do they wait in a queue ?
  (println @amount)
  (reset! amount 110)
  (println @amount)
  (compare-and-set! amount 110 120)
  (println @amount)
  (compare-and-set! amount 110 150)
  (println @amount)
  )
(a-toms)