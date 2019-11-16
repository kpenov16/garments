(ns garments.petstore)

(defn petToHumanAge
  "returns age og pet in human relative years"
  [x]
  (def petMap {'dog 7 'cat 5 'fish 10})
  (get petMap x)
  )

(defn age
  ""
  [petName petType petAge]
  (def ratio (petToHumanAge petType))
  (println petName " is " (* ratio petAge) " years ")
  )

(age "Trixy" 'fish 3)