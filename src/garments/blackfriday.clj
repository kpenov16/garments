(ns garments.blackfriday)

(def items (ref {"pen" 1 "notebook" 5 "backpack" 10}))
(def bankAccount (ref 0))
(def customerAccount (ref 5000))

(defn buy
  [itemKey price]

  (println "bank account before transaction: " @bankAccount)
  (println "customer account before transaction: " @customerAccount)
  (println "items before transaction: " @items)
  (dosync
    (if (and (> (get @items itemKey 0) 0)
             (>= @customerAccount 0)
             (>= price 0)
             (>= @customerAccount price))
      (do
        (alter bankAccount + price)
        (alter customerAccount - price)
        (alter items update itemKey - 1)
        )
      (println "error: items:" @items "customerAccount" @customerAccount
               "bankAccount" @bankAccount "item" itemKey "price" price))
    )
  (println "bank account after transaction: " @bankAccount)
  (println "customer account after transaction: " @customerAccount)
  (println "items after transaction: " @items)
  )

(buy "pen" 100)
(buy "pen" 100)
