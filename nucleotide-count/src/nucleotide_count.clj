(ns nucleotide-count)

(def nucleotides (set [\C \A \G \T]))

(defn count [nuc dna]
  (if-not (nucleotides nuc)
    (throw (IllegalArgumentException. (str "Unknown nucleotide " nuc)))
    (or ((frequencies dna) nuc) 0)))
 
(defn nucleotide-counts [dna] 
  (loop [nuc nucleotides freqs {}]
      (if (not-empty nuc)
        (let [head (first nuc)
              tail (rest nuc)
              many (count head dna)]
          (recur tail (assoc freqs head many)))
        freqs)))
