(ns anagram)
(use '[clojure.string :only (lower-case)])

(defn anagrams-for [word words] 
  (let [word (lower-case word)
        freq (frequencies word)]
    (->> words
         (filter #(not= word (lower-case %)))
         (filter #(= freq (frequencies (lower-case %)))))))

