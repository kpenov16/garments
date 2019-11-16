(ns garments.core
  (:gen-class))

(comment

  (defn make-literal [a]
  (.replace a "\"" "\\\"")
  )

(defn extract-anything-between [prefix suffix from-string]
  (let [pattern (str (make-literal prefix) "([\\s\\S]*?)" (make-literal suffix))]
    (second (re-find (re-pattern pattern) from-string))
    )
  )


(defn extract-anything-between-combine [prefix suffix from-string]
  (let [pattern (str (make-literal prefix) "([\\s\\S]*?)" (make-literal suffix))]
    (join "" (map #(second %) (re-seq (re-pattern pattern) from-string)))
    )
  )

end of comment
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;;(def s (slurp "https://github.com/ButchersBoy/sportivemap/tree/master/scraperjs"))
  ;;(println (extract-anything-between-combine "/" ".json" s))
  (println "Hello, World " "Pernille"))
