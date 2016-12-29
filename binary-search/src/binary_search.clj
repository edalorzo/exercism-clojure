(ns binary-search)

(defn middle [data]
  (let [length (- (count data) 1)]
    (when-not (< length 0)
      (int (/ length 2)))))
      

(defn search-for [n hs]
  (loop [needle n haystack (vec hs)]
    (let [page (middle haystack)]
      (if page
        (let [found (haystack page)]
          (cond
            (< found needle) (recur needle (subvec haystack (inc page)))
            (> found needle) (recur needle (subvec haystack 0 page))
            :otherwise page))
        (throw (RuntimeException. "not found"))))))
