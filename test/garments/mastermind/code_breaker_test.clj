(ns garments.mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
           [garments.mastermind.code-breaker :refer :all]))

(defn position-matches [code guess]
  (count (filter identity (map #(= %1 %2) code guess))))

(defn score [code guess]
  [(position-matches code guess)
   0])

(fact "Code breaker engine"
      (fact "givenScoreGuessWithNoMatches_returnEmptyVector"
             (score [0 0 0 0] [1 1 1 1]) => [0 0])
      (fact "givenScoreOnePositionMatch_returnVectorWithMatchedPosition"
             (score [0 0 0 0] [0 1 1 1]) => [1 0])
      (fact "givenScoreTwoPositionMatch_returnVectorWithTwoMatchedPositions"
            (score [0 0 0 0] [0 0 1 1]) => [2 0]
            (score [0 0 0 0] [0 1 1 0]) => [2 0]
            (score [0 0 0 0] [1 0 1 1]) => [1 0]
            (score [1 2 3 0] [1 2 3 4]) => [3 0]
            (score [1 2 3 4] [1 2 3 4]) => [4 0]
            )
)

