(ns garments.destructuring)

(defn destructme
  []
  (def myvect [1 2 3 4])
  (let [[a b c] myvect]
    (println a b c))
  (let [[a b & rest] myvect]
    (println a b rest))

    (def mymap {'name "John" 'last "Smith"})
    (let [{a 'name b 'last c 'noname} mymap] (println a b c))
  )
(destructme)