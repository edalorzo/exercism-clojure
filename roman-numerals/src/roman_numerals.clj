(ns roman-numerals)

(defn- explode-to-digits [number]
  (map #(- (int %) 48) (str number)))

(def ^:private roman-units [
  ["I","II","III","IV","V","VI","VII","VIII","IX"],
  ["X","XX","XXX","XL","L","LX","LXX","LXXX","XC"],
  ["C","CC","CCC","CD","D","DC","DCC","DCCC","CM"]])

(defn numerals [number]
  {:pre [(> number 0)]}
  (let [indexer (partial map-indexed vector)
        indexed (comp indexer reverse explode-to-digits)
        digits (indexed number)]
    (loop [[[i n] & more :as numbers] digits romans ""]
      (if-not (empty? numbers)
        (if (> n 0)
          (if (< i 3)
            (recur more (str (get-in roman-units [i (dec n)]) romans))
            (let [size (* n (int (Math/pow 10 (- i 3))))
                  ms (apply str (repeat size \M))]
                (recur more (str ms romans))))
          (recur more romans))
        romans))))
