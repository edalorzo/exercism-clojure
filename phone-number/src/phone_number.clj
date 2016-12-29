(ns phone-number)

(defn ^:private bad-phone? [size digits]
  (or
    (< size 10)
    (> size 11)
    (and
      (= size 11)
      (not= (first digits) \1))))


(defn number [phone]
  (let [digits (filter #(Character/isDigit %) phone)
        size (count digits)
        invalid-number "0000000000"]
    (if-not (bad-phone? size digits)
      (if (= size 10) 
        (apply str digits)
        (apply str (rest digits)))
      invalid-number)))


(defn area-code [phone]
  (apply str (take 3 (number phone))))


(defn pretty-print [phone]
  (let [phone (number phone)
        digits7 (drop 3 phone)
        code (apply str (take 3 phone))
        middle (apply str (take 3 digits7))
        last4 (apply str (drop 3 digits7))]
    (str "(" code ") " middle "-" last4)))


