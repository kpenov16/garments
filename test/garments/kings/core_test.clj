(ns garments.kings.core-test
  (:require [midje.sweet :refer :all]
            [garments.kings.core :as king]))

(facts
  (fact (king/get-name {"id"  1,
                        "nm"  "Peter the Elder",
                        "cty" "United Kingdom",
                        "hse" "House of Wessex",
                        "yrs" "899-925"})
        => "Peter the Elder")
  )

(facts
  (fact (king/get-first-name "Peter the Elder")
        => "Peter"))

(facts "givenKingdomsAsJsonStr_returnMostPopularKingName"
       (fact "givenTwoKingdomAsJsonStr_returnMostPopularKingIsThisKingsName"
             (king/most-popular-name "[\n {\n \"id\": 1,\n \"nm\": \"Peter the Elder\",\n \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"899-925\"\n  },
                                          {\n \"id\": 1,\n \"nm\": \"Edward the Elder\",\n \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"899-925\"\n  }]")
             => "Peter"
             )

       (fact "givenOneKingdomAsJsonStr_returnMostPopularKingIsThisKingsName"
             (king/most-popular-name "[\n {\n \"id\": 1,\n \"nm\": \"Edward the Elder\",\n \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"899-925\"\n  }]")
              => "Edward"
             (king/most-popular-name "[\n {\n \"id\": 1,\n \"nm\": \"Peter the Elder\",\n \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"899-925\"\n  }]")
             => "Peter")
       (fact "givenNoKingdomsAsJsonStr_returnEmptyList"
             (king/most-popular-name "[]")
             => ())
       (fact "givenNilAsJsonStr_returnNil"
             (king/most-popular-name nil)
             => nil)
       (fact "givenInvalidJsonAsStr_returnException"
             (king/most-popular-name "[")
             => (throws Exception))
#_       (fact "givenOneKingdomAsJsonStr_returnMostPopularKingIsThisKingsName"
      ( "[\n {\n \"id\": 1,\n \"nm\": \"Edward the Elder\",\n \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"899-925\"\n  },\n
             {\n \"id\": 2,\n \"nm\": \"Athelstan\",\n        \"cty\": \"United Kingdom\",\n  \"hse\": \"House of Wessex\",\n \"yrs\": \"925-940\"\n  }]")
      ;(apply hash-map (first (king/query-json))) => {"Edward" 1}
      )
       )
