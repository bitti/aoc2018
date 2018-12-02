(ns aoc2018.day02)

(defn read-box-ids []
  (->>
    *in*
    line-seq))

(defn letter-frequency [box-id]
  (reduce
    (fn [c l] (update c l #(inc (or % 0))))
    {}
    box-id))

(defn checksum [box-ids]
  (loop [twos 0
         threes 0
         box-ids box-ids]
    (if (empty? box-ids)
      (* twos threes)
      (let [frequencies (letter-frequency (first box-ids))]
        (recur
          (if (some #(= 2 %) (vals frequencies)) (inc twos) twos)
          (if (some #(= 3 %) (vals frequencies)) (inc threes) threes)
          (rest box-ids))))))

(defn find-hamming-1 [box-ids]
  (loop [candidates box-ids]
    (if-let [candidate (first candidates)]
      (or (loop [matches (rest candidates)]
            (if-let [match (first matches)]
              (or
                (reduce
                  (fn [[equal mismatch] [c1 c2]]
                    (if (not (= c1 c2))
                      (if mismatch
                        (reduced false)
                        [equal [c1 c2]])
                      [(conj equal c1) mismatch]))
                  [[] nil]
                  (map list candidate match))
                (recur (rest matches)))))
        (recur (rest candidates))))))
