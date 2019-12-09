(ns garments.mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
           [garments.mastermind.code-breaker :refer :all]))

(defn break-code [code guess]
  [(reduce + (map #(if (= (first %) (second %)) 1 0) (partition 2 (interleave code guess))))])

;[0 0 0 0] [0 1 1 0]
;(interleave [0 0 0 0] [0 1 1 0])
;[0 0 0 1 0 1 0 0]
;(partition 2 [0 0 0 1 0 1 0 0])
;[0 0] [0 1] [0 1] [0 0]
;(map #(if (= %1 %2) 1 0) [0 0] [0 1] [0 1] [0 0])
;[1 0 0 1]
;(reduce + [1 0 0 1])

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

