(ns garments.bowling.core-test
  (:require [clojure.test :refer :all]
            [garments.bowling.core :refer :all]))


(deftest score-test
  (testing "given10Missed_returnZero"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0]))))
  (testing "givenNoSparesAndStrikes_returnTotalScore"
    (is (= 20 (score [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1])))
    (is (= 50 (score [5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 5 0 ])))
    )
  )

(run-tests 'garments.bowling.core-test)
