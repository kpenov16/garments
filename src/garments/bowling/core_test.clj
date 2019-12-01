(ns garments.bowling.core-test
  (:require [clojure.test :refer :all]
            [garments.bowling.core :refer :all]))


(deftest score-test
  (testing "given10Missed_returnZero"
    (is (= 0 (score [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 ])))))

(run-tests 'garments.bowling.core-test)
