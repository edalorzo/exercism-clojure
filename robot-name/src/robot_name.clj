(ns robot-name)

;; this data structure plays the role of the cache
;; and most likely would need to be replaced with a 
;; persistent data structure if the number of robots
;; is too big to keep in memory.
(def robots (atom {}))

;; a vector containing a single stream of valid symbols:
;; [0 1 2 3 4 5 6 7 8 9 A B C D E F G ... Z]
(def ^:private symbols
  (let [letters (vec (map char (range 65 91)))
        numbers (vec (map char (range 48 58)))]
    (into numbers letters)))

(defn ^:private create-random-name []
  ;;generate 5 random incides: three for numbers, two for letters
  (let [numbers (vec (map rand-int [10 10 10]))
        letters (vec (map #(+ 10 (rand-int %)) [26 26]))
        indices (into letters numbers)]
    ;; and map the indices to their symbols
    (apply str (map symbols indices))))


(defn robot []
  (let [bot-name (create-random-name)]
    (if-not (contains? @robots bot-name)
      (let [bot (atom {:name bot-name})
            record (swap! robots assoc bot-name bot)]
        (get record bot-name))
      ;;warning: if we exhaust all possible robot names
      ;;we will recur for ever here.
      (recur))))

(defn robot-name [bot]
  (:name @bot))

(defn reset-name [bot]
  (let [their-name (robot-name bot)
        my-name (create-random-name)]
    (if (not= their-name my-name)
      (do 
        (swap! bot assoc :name my-name)
        bot)
      (recur reset-name))))