(ns garments.kings.core-test
  (:require [midje.sweet :refer :all]
            [garments.kings.core :as king]))



(facts "givenKingdomsAsJsonStr_returnMostPopularKingName"
       (fact "givenOneKingdomAsJsonStr_returnMostPopularKingIsThisKingsName"
             (king/most-popular-name "[\n {\n \"id\": 1,\n \"nm\": \"Edward the Elder\",\n \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"899-925\"\n  }]")
              => "Edward")
       (fact "givenNoKingdomsAsJsonStr_returnNil"
             (king/most-popular-name "[]")
             => ())
       (fact "givenNilAsJsonStr_returnNil"
             (king/most-popular-name nil)
             => nil)
#_       (fact "givenOneKingdomAsJsonStr_returnMostPopularKingIsThisKingsName"
      ( "[\n {\n \"id\": 1,\n \"nm\": \"Edward the Elder\",\n \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"899-925\"\n  },\n
             {\n \"id\": 2,\n \"nm\": \"Athelstan\",\n        \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"925-940\"\n  }]")
      ;(apply hash-map (first (king/query-json))) => {"Edward" 1}
      )
       )
