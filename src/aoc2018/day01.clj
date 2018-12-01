(ns aoc2018.day01)

(defn read-frequencies []
  (->>
    *in*
    line-seq
    (map #(Integer/parseInt %))))

(defn final-frequency [frequencies]
  (reduce + frequencies))

(defn first-repeated-frequency [frequencies]
  (reduce
    (fn [[s f] c]
      (let [f (+ f c)]
        (if (s f)
          (ensure-reduced f)
          [(conj s f) f])))
    [#{} 0]
    (cycle frequencies)))
