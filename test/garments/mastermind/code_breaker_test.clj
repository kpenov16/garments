(ns garments.mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
           [garments.mastermind.code-breaker :refer :all]))

(defn break-code [code guess]
  [(count
    (filter some?
            (map
              #(if (= %1 %2) :pos) code guess)))]
  )

(fact "Code breaker"
      (fact "givenScoreGuessWithNoMatches_returnEmptyVector"
             (break-code [0 0 0 0] [1 1 1 1]) => [0])
      (fact "givenScoreOnePositionMatch_returnVectorWithMatchedPosition"
             (break-code [0 0 0 0] [0 1 1 1]) => [1])
      (fact "givenScoreTwoPositionMatch_returnVectorWithTwoMatchedPositions"
            (break-code [0 0 0 0] [0 0 1 1]) => [2]
            (break-code [0 0 0 0] [0 1 1 0]) => [2]
            )
)

