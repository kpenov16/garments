(ns garments.mastermind.code-breaker-test
  (:require [midje.sweet :refer :all]
           [garments.mastermind.code-breaker :refer :all]))

(defn break-code [guesses]
  [0 0 0 0]
  )

(fact "Code breaker"
      (facts "empty guess")
  (break-code []) => [0 0 0 0])
