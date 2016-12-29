(ns grade-school)

(defn grade [db level]
  (get db level []))

(defn add [db name level]
  (let [students (grade db level)]
    (if-not (contains? students name)
      (assoc db level (conj students name))
      db)))

(defn ^:private sort-students [db level students]
  (let [students (vec (into (sorted-set) students))]
    (assoc db level students)))
  
(defn sorted [db]  
  (reduce-kv sort-students (sorted-map) db))


