(ns flatten-array)


(defn- do-flatten 
  ([xs]
   (do-flatten xs []))
  
  ([xs ys]
    (if-not (empty? xs)
      (let [x (first xs)
          xs (rest xs)]
        (if-not (vector? x)
          (do-flatten xs (conj ys x))
          (do-flatten xs (into ys (do-flatten x [])))))
      ys)))

(defn flatten [source]
  (->> source
    (do-flatten)
    (filterv identity)))