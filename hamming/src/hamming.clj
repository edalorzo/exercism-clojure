(ns hamming)


(defn distance [a b]
  (when (= (count a) (count b))
    (if (not-empty a)
      (let [k (first a)
            v (first b)
            acc (distance (rest a) (rest b))]
        (if (not= k v) (+ acc 1) acc))
      0)))
    