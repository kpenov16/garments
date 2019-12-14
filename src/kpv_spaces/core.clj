(ns kpv-spaces.core)
;questions to be answered for SequentialSpace
; Do you need to keep things in order?
; Do you want to remember the order you added things in?
; Or do you want an order maintained by resorting? (Like keeping them alphabetical)
; Where do you want new items to go?
; Does SequentialSpace should be an interface ?

;requirements:
;0) can have duplicates, sequential order
;
;1) putting tuples to spaces like: (put spaceX tupleX)
;                               or (put (spaceX.) tupleX)
;2) create empty sequential space
;   something like: (def spaceX)
;
;3) search for tuple in sequential pSpace
;   like: (queryp (spaceX.) (TupleInterface "tuple_key"))
; returns a clone of the tuple else nil
;
; 4) removing tuples from sequential pSpace
;    like: (getp (spaceX.) tupleX)
;     and: (getp (spaceX.) "clean kitchen")
; deletes the tuple from space and returns a clone
; else nil


(defprotocol Space
  (put [this t]))

(deftype SequentialSpace []
  Space
  (put [this t] (println "tuple:" t "added" )))

(put (SequentialSpace.) :fridge)

