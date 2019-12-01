(ns garments.bowling.core-test
  (:require [clojure.test :refer :all]
            [garments.bowling.core :refer :all]))

(deftest group-frames-test
  (testing "givenRolls_returnRollsGroupedIntoFrames")
  (is (= [[1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1]]
         (group-frames [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]) ))
  )

(deftest to-frame-scores-test
  (testing "givenFrames_returnScores")
  (is (= [[2] [2] [2] [2] [2] [2] [2] [2] [2] [2]]
         (to-frame-scores [[1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1]]) ))
  )

#_(deftest score-test
  (testing "given10Missed_returnZero"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  (testing "givenNoSparesAndStrikes_returnTotalScore"
    (is (= 20 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))
    (is (= 50 (score [5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 ]))))
  (testing "givenASpares_returnSumOfAll+FirstRollAfterSpareOnceAgain" ;;10+1*2+17
    (is (= 29 (score [9 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]))))
  )

(run-tests 'garments.bowling.core-test)
