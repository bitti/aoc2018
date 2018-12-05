(ns aoc2018.day04-test
  (:require [aoc2018.day04 :refer :all]
            [aoc2018.test-helper :refer :all]
            [clojure.test :refer [deftest is]]))

(deftest test-read-sleeptimes
  (with-in-str "[1518-03-12 23:56] Guard #881 begins shift"
    (is (= '([56 "881"]) (read-sleeptimes)))))

(deftest test-day4-part1
  (binding [*in* (resource-as-stdin "day04-input")]
    (is (= 99759 (strategy1 (sleeptimes (read-sleeptimes)))))))

(deftest test-day4-part2
  (binding [*in* (resource-as-stdin "day04-input")]
    (is (= 97884 (strategy2 (sleeptimes (read-sleeptimes)))))))
