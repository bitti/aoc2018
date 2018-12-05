(ns aoc2018.day05-test
  (:require [aoc2018.day05 :refer :all]
            [aoc2018.test-helper :refer :all]
            [clojure.test :refer [deftest is]]))

(deftest test-day5-part1
  (is (= 0 (count (react "aA"))))
  (is (= 0 (count (react "abBA"))))
  (is (= 4 (count (react "abAB"))))
  (is (= 6 (count (react "aabAAB"))))
  (is (= 10 (count (react "dabAcCaCBAcCcaDA"))))
  (is (= 8 (count (react "daAcCaCAcCcaDA"))))
  (is (= 4 (count (react "dabAaBAaDA"))))
  (is (= 6 (count (react "abAcCaCBAcCcaA"))))
  (binding [*in* (resource-as-stdin "day05-input")]
    (is (= 11242 (count (react (read-units)))))))

(deftest test-day5-part2
  (is (= 4 (react-improved "dabAcCaCBAcCcaDA")))
  (binding [*in* (resource-as-stdin "day05-input")]
    (is (= 5492 (react-improved (read-units))))))
