(ns word-count)
(use '[clojure.string :only (split lower-case)])

(defn word-count [phrase] 
   (let [statement (split (lower-case phrase) #"\W+")]
     (frequencies statement)))
