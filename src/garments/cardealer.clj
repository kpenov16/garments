(ns garments.cardealer)

(defn canbuy
  [budget price]
  (and (> budget 0) (>= budget price))
  )

(defn getoffer
  [budget discount]
  (if (or (<= discount 0) (> discount 1))
    (do
      (println "You can't get a discount!")
      (doseq [[k price] {"BMW" 60000 "FERRARI" 100000 "FIAT" 20000}]
        (if (canbuy budget price)
          (println "You can buy " k " for: " price)
          )
        )
      )
    (do
      (println "You have a valid discount of: " discount)
      (doseq [[k price] {"BMW" 60000 "FERRARI" 100000 "FIAT" 20000}]
        (if (canbuy budget price)
          (println "You can buy " k " for: " (- price (* price discount))))
        )
      )
    ))
(getoffer 61000 0.3)


