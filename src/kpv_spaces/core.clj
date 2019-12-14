(ns kpv-spaces.core)
;questions to be answered for SequentialSpace
; Do you need to keep things in order?
; Do you want to remember the order you added things in?
; Or do you want an order maintained by resorting? (Like keeping them alphabetical)
; Where do you want new items to go?
; Does SequentialSpace should be an interface ?


(defprotocol Space
  (put [this t]))

(deftype SequentialSpace []
  Space
  (put [this t] (println "tuple:" t "added" )))

(put (SequentialSpace.) :fridge)

