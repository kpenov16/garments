(ns garments.exceptions)

(defn exhandling
  [x]
  (try
    (inc x)
    (catch ClassCastException e (println "Caught exception:" (.getMessage e)) )
    (catch Exception e (println "Caught generic ex"))
    (finally (println "clean up"))
    )
  )
(exhandling "d")