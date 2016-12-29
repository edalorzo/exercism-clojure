(ns rna-transcription)

(defn transcribe [n]
  (cond 
    (= \G n) \C
    (= \C n) \G
    (= \T n) \A
    (= \A n) \U
    :else (throw (AssertionError. (str "Invalid nucleotide found" n)))))

(defn to-rna [dna] 
  (apply str (map transcribe dna)))
