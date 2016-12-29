(ns leap)

(defn leap-year? [year]
  (or 
    (zero? (rem year 400))
    (and 
      (not= 0 (rem year 100))
      (zero? (rem year 4)))))