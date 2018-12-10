(ns aoc2018.day09-test
  (:require [aoc2018.day09 :refer :all]
            [aoc2018.test-helper :refer :all]
            [clojure.test :refer [deftest is run-tests]]
            [clojure.test.junit :refer [with-junit-output]]))

(deftest day9-examples
  (is (= 32 (high-score 9 25)))
  (is (= 146373 (high-score 13 7999)))
  (is (= 2764 (high-score 17 1104)))
  (is (= 54718 (high-score 21 6111)))
  (is (= 37305 (high-score 30 5807))))
  
(deftest day9-part1
  (is (= 404611 (high-score 431 70950))))

(deftest day9-part2
  (is (= 3350093681 (high-score 431 7095000))))
