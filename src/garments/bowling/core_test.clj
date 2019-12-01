(ns garments.bowling.core-test
  (:require [clojure.test :refer :all]
            [garments.bowling.core :refer :all]))


(deftest score-test
  (testing "given10Missed_returnZero"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  (testing "givenAllScoredOne_return20"
    (is (= 0 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]))))
  )

(run-tests 'garments.bowling.core-test)
