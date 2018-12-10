(ns aoc2018.day09)

(defn high-score [players max-score]
  (let [next (int-array (inc max-score))
        prev (int-array (inc max-score))
        points (long-array players 0)]
    (loop [current-maple 1
           pos 0]
      (if (> current-maple max-score)
        (reduce max points)
        (if (= (mod current-maple 23) 0)
          (let [pos (nth (iterate #(aget prev %) pos) 7)
                next-pos (aget next pos)
                prev-pos (aget prev pos)
                current-player (mod current-maple players)]
            (aset next prev-pos next-pos)
            (aset prev next-pos prev-pos)
            (aset points current-player (+ pos current-maple (aget points current-player)))
            (recur (inc current-maple) next-pos))
          (let [next-pos (aget next (aget next pos))
                prev-pos (aget prev next-pos)]
            (aset prev next-pos current-maple)
            (aset next prev-pos current-maple)
            (aset next current-maple next-pos)
            (aset prev current-maple prev-pos)
            (recur (inc current-maple) current-maple))))
      )))
