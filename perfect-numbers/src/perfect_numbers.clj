(ns perfect-numbers)

(defn- divisors [n]
  (if (<= n 0)
    (throw (IllegalArgumentException. "n must be > 0"))
    (for [divisor (range 2 n) :when (zero? (rem n divisor))]
      divisor)))
      
(defn classify [n]
  (let [sum (+ 1 (reduce + 0 (divisors n)))]
    (cond
      (< sum n) :deficient
      (> sum n) :abundant
      :otherwise :perfect)))
