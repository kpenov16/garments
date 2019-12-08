(ns garments.kings.core
  (:require [clj-http.client :as client]
            [cheshire.core :as shire]
            [clojure.string :as s]))
(defn get-first-name [full-name]
  (first (s/split full-name #" ")))

(defn get-name [raw-js]
  (get raw-js "nm"))

(defn map-sort-by-value [m]
  (into (sorted-map-by #(compare (m %2) (m %1))) m))

(defn query-json []
  (let [js (client/get
             "https://gist.githubusercontent.com/kpenov16/f15d8f31f751a5a0655b559c3997adf9/raw/59c08ef97b85287d0218e6d1c511ac2eb36bdfba/kings"
             {:accept :json})]
    (map-sort-by-value (frequencies
                         (map get-first-name (keys (group-by #(:nm %) (shire/parse-string (:body js) true))))
                         ))))

(defn most-popular-name [js-str]
  (cond
    (nil? js-str) nil
    (empty? (shire/parse-string js-str)) ()
    :else (get-first-name (apply get-name (shire/parse-string js-str))))
  )

;(query-json)
;(get-first-name "Edward the Matr")
