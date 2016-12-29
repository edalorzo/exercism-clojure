(ns etl
  (:require [clojure.string :refer [lower-case]]))

;; (use '[clojure.string :only (split)])

(defn- set-scores [table value letters]
  (reduce #(assoc %1 (lower-case %2) value) table letters))


(defn transform [scores]
  (reduce-kv set-scores (sorted-map) scores))
