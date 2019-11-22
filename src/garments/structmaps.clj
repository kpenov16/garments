(ns garments.structmaps)

(defn pets
  []
  (defstruct pet :PetType :PetName)
  (def myPet (struct pet "dog" "Fido"))
  (println myPet)

  (def myOtherPet (struct-map pet :PetName "Fifi" :PetType "cat"))
  (println myOtherPet)
  (println (:PetName myPet))
  (println (:PetType myOtherPet))

  (def myNewPet (assoc myPet :PetName "Max"))
  (println myNewPet)

  (def myNewOtherPet (assoc myOtherPet :petAge 10))
  (println myNewOtherPet)
  )

(pets)