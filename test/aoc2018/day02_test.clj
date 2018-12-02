(ns aoc2018.day02-test
  (:require [aoc2018.test-helper :refer :all]
            [aoc2018.day02 :refer :all]
            [clojure.test :refer [deftest is]]))

(deftest test-day2-part1
  (binding [*in* (resource-as-stdin "day02-input")]
    (is (= (checksum (read-box-ids)) 6696))))

(deftest test-day2-part2
  (binding [*in* (resource-as-stdin "day02-input")]
    (is (= (clojure.string/join (first (find-hamming-1 (read-box-ids))))
          "bvnfawcnyoeyudzrpgslimtkj")))
  )
