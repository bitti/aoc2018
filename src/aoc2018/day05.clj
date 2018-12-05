(ns aoc2018.day05)

(defn read-units []
  (->>
    (java.io.BufferedReader. *in*)
    slurp))

(defn react [units]
  (loop [units (vec units)
         length (count units)]
    (let [[units last-ch]
          (reduce
            (fn [[ch prev] unit]
              (if (and prev unit (= (bit-xor (int prev) (int unit)) 32))
                [ch nil]
                [(if prev (conj ch prev) ch) unit]))
            [() nil]
            units)
          units (if last-ch (conj units last-ch) units)
          new-length (count units)
          ]
      (if (= new-length length)
        units
        (recur units new-length)))))

(defn react-improved [units]
  (let [units (clojure.string/join (react units))]            ; Reduce first
    (loop [types (map char (range (int \a) (int \z)))
           shortest Integer/MAX_VALUE]
      (if (empty? types)
        shortest
        (let [type (str (first types))
              length (count
                       (react (clojure.string/replace units
                                (re-pattern (str "[" type (.toUpperCase type) "]")) "")))]
          (recur (rest types) (min shortest length)))))))
