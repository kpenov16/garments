(ns garments.bowling.core-test
  (:require [clojure.test :refer :all]
            [garments.bowling.core :refer :all]))

(deftest next-frame-size-test
  (testing "givenStrikeInNextFrame_returnSizeOfNextFrameToBeOne"
    (is (= 1
           (next-frame-size [10 3 1 1 1]))))
  (testing "givenStrikeInNextFrame_returnSizeOfNextFrameToBeOne"
    (is (= 2
           (next-frame-size [1 1 1 1 1]))))
  (testing "givenSpare_returnSizeOfNextFrameToBeTwo"
    (is (= 2
           (next-frame-size [1 9 1 1 1]))))
  (testing "givenLastSpare_returnSizeOfNextFrameToBeTree"
    (is (= 3
           (next-frame-size [5 5 1]))))
  (testing "givenLastStrike_returnSizeOfNextFrameToBeTree"
    (is (= 3
           (next-frame-size [10 1 1]))))
  )

(deftest group-frames-test
  (testing "givenRolls_returnRollsGroupedIntoFrames"
    (is (= [[1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1]]
           (group-frames [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]) )))
  (testing "givenRollsWithStrike_returnRollsGroupedIntoFrames"
    (is (= [[10] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1]]
           (group-frames [10 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]) )))
  (testing "givenSpareFrameWithBonusRoll_returnRollsGroupedIntoFrames"
    (is (= [[1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [1 1] [5 5 3]]
           (group-frames [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 5 5 3]) )))

  )

(deftest next-frame-score-test
  (testing "givenNoSpareOrStrikeFrames_returnNextFrameScore"
    (is (= 3 (next-frame-score [[1 2]]))))
  (testing "givenSpare_returnNextFrameScoreForASpare"
    (is (= 14 (next-frame-score [[1 9] [4 2]]))))
  (testing "givenStrike_returnNextFrameScoreForAStrike"
    (is (= 16 (next-frame-score [[10] [4 2]]))))
  )


(deftest strike-extra-score-test
  (testing "givenNextFramesAfterAStrike_returnTheExtraStrikeScore")
  (is (= 7 (strike-extra-score [[3 4]])) )
  (is (= 2 (strike-extra-score [[1 1] [1 9]])))
  )

(deftest spare-extra-score-test
  (testing "givenNextFrames_returnTheExtraSpareScore")
  (is (= 3 (spare-extra-score [[3 4]])) )
  (is (= 0 (spare-extra-score [[0 9] [1 9]])))
  )

(deftest spare?-test
  (testing "givenSpare_returnTrue")
  (is (= true (spare? [8 2])))
  (is (= false (spare? [10])))
  (is (= true (not (spare? [1 5]))) )
  )

(deftest to-frame-scores-test
  (testing "givenFrames_returnScores"
    (is (= [1 2 3 4 5 6 7 8 9 0]
           (to-frame-scores [[1 0] [1 1] [1 2] [1 3] [1 4] [1 5] [1 6] [1 7] [1 8] [0 0]]) )))

  (testing "givenSpareFrame_returnSpareScore"
    (is (= [11 2 3 4 5 6 7 8 9 0]
           (to-frame-scores [[1 9] [1 1] [1 2] [1 3] [1 4] [1 5] [1 6] [1 7] [1 8] [0 0]]) )))

  (testing "givenStrikeFrame_returnStrikeScore"
      (is (= [12 2 3 4 5 6 7 8 9 0]
             (to-frame-scores [[10] [1 1] [1 2] [1 3] [1 4] [1 5] [1 6] [1 7] [1 8] [0 0]]) )))
  )

;;#_
(deftest score-test
  (testing "given10Missed_returnZero"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  (testing "givenNoSparesAndStrikes_returnTotalScore"
    (is (= 20 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))
    (is (= 50 (score [5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 ]))))
  (testing "givenASpares_returnSumOfAll+FirstRollAfterSpareOnceAgain" ;;10+1+18
    (is (= 29 (score [9 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]))))
  (testing "givenAStrike_returnSumOfAll+FirstTwoRollsAfterStrikeOnceAgain" ;;10+1+1+18
    (is (= 30 (score [10 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]))))
  (testing "givenAllSpares_returnSumOfAllFrames+TheRollOfNextFrame"
    (is (= 150 (score [5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5]))))
  (testing "givenAllStrike_return300"
    (is (= 300 (score [10 10 10 10 10 10 10 10 10 10 10 10]))))
  )

(run-tests 'garments.bowling.core-test)
