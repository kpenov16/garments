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
  (is (= [1 2 3 4 5 6 7 8 9 0]
         (to-frame-scores [[1 0] [1 2] [1 3] [1 4] [1 5] [1 6] [1 7] [1 8] [0 0]]) ))
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
