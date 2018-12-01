(ns aoc2018.day01-test
  (:require [aoc2018.test-helper :refer :all]
            [aoc2018.day01 :refer :all]
            [clojure.test :refer [deftest is]]))

(deftest test-day1-part1
  (binding [*in* (resource-as-stdin "day01-input")]
    (is (= (final-frequency (read-frequencies)) 427))))

(deftest test-day1-part2
  (binding [*in* (resource-as-stdin "day01-input")]
    (is (= (first-repeated-frequency (read-frequencies)) 341))))
