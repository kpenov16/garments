(ns garments.cardealer)

(defn canbuy
  [budget price]
  (and (> budget 0) (>= budget price))
  )

(defn getoffer
  [budget discount]
  (def cars {"BMW" 60000 "FERRARI" 100000 "FIAT" 20000})
  (if (or (<= discount 0) (> discount 1))
    (do
      (println "You can't get a discount!")
      (println "budget: " budget)
      (doseq [[k price] cars]
        (if (canbuy budget price) (println "You can buy " k " for: " price))))
    (do
      (println "You have a valid discount of: " discount)
      (println "budget: " budget)
      (doseq [[k price] cars]
        (if (canbuy budget price) (println "You can buy " k " for: " (- price (* price discount))))))
    ))
(getoffer 61000 0.3)

;;alternative solution, more or less the same as mine
(defn isCodeValid
  [code]
  (defstruct coupon :Name :Discount)
  (def validCoupon (struct coupon "20Percent" 0.8))
  (if (= (:Name validCoupon) code)
    true
    false)
  )
;; validCoupon use is funny
(defn getCarPrices
  [budget code]
  (def cars {"bmw" 60000 "ferrari" 100000 "fiat" 20000})
  (if (isCodeValid code)
    (do
      (println "The code is valid")
      (def discount (:Discount validCoupon))
      (doseq [car cars]
        (def carName (first car))
        (def carPrice (second car))
        (def priceDiscount (* carPrice discount))
        (if (<= priceDiscount budget)
          (println "The" carName "costs" priceDiscount))
        )
      )
    (do
      (println "The code is invalid")
      (doseq [car cars]
        (def carName (first car))
        (def carPrice (last car))
        (if (<= carPrice budget)
          (println "The" carName "costs" carPrice))
        )
      )
    )
  )
(getCarPrices 50000 "20Percent")
