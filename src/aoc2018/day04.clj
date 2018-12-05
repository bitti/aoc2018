(ns aoc2018.day04)

(defn read-sleeptimes []
  (->>
    (java.io.BufferedReader. *in*)
    line-seq
    sort
    (map #(re-matches #"\[.*(\d\d)\] \w+ #?(\w+|\d+).*" %))
    (map (fn [[_ minute word-or-id]]
           [(Integer/parseInt minute) word-or-id]))
    ))

(defn sleeptimes [observations]
  (loop [[guards observations] [{} observations]]
    (if (empty? observations)
      guards
      (let [guard-id (Integer/parseInt (second (first observations)))]
        (recur
          (loop [guards guards
                 [[min1 word] [min2 _] & remaining-obs :as obs] (rest observations)]
            (if (= word "asleep")
              (let [guard (or (guards guard-id) (int-array 60 0))]
                ;; NOTE: We assume here that an "asleep" is always followed by an "up"
                (doseq [minute (range min1 min2)]
                  (aset guard minute (inc (aget guard minute))))
                (recur (assoc guards guard-id guard) remaining-obs))
              [guards obs])))
        ))))

(defn strategy1 [guards]
  (let [max-id
        (->> guards
          (reduce (fn [sums [id guard]]
                    (assoc sums id (reduce + guard)))
            {})
          (reduce (fn [[max-id max-sum] [id sum]]
                    (if (> sum max-id)
                      [id sum]
                      [max-id max-sum]))
            [0 0])
          first)

        [max-min _]
        (reduce-kv (fn [[max-min max-sleeps] minute sleeps]
                     (if (> sleeps max-sleeps)
                       [minute sleeps]
                       [max-min max-sleeps]))
          [0 0]
          (into [] (guards max-id))
          )]
    (* max-id max-min)))

(defn strategy2 [guards]
  (let [[max-id max-min _]
        (reduce (fn [[max-id max-min max-sleeps] [id guard]]
                  (let [[minute sleeps]
                        (reduce-kv (fn [[max-min max-sleeps] minute sleeps]
                                  (if (> sleeps max-sleeps)
                                    [minute sleeps]
                                    [max-min max-sleeps]))
                          [0 0]
                          (into [] guard))]
                    (if (> sleeps max-sleeps)
                      [id minute sleeps]
                      [max-id max-min max-sleeps])))
          [0 0 0]
          guards)]
    (* max-id max-min)))
