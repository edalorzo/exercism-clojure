(ns rna-transcription)

(defn transcribe [n]
  (condp = n
    \G \C
    \C \G
    \T \A
    \A \U
    (throw (AssertionError. (str "Invalid nucleotide found" n)))))

(defn to-rna [dna] 
  (apply str (map transcribe dna)))
