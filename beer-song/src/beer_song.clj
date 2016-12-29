(ns beer-song)
(use '[clojure.string :only (join)])
(import java.text.MessageFormat)

(def LYRICS (str 
            "{0,choice,0#No more bottles|1#1 bottle|1<{0,number,integer} bottles} of beer on the wall, "
            "{0,choice,0#no more bottles|1#1 bottle|1<{0,number,integer} bottles} of beer.\n"
            "{0,choice,0#Go to the store and buy some more|1#Take it down and pass it around|1<Take one down and pass it around}, "
            "{1,choice,-1#99 bottles|0#no more bottles|1#1 bottle|1<{1,number,integer} bottles} of beer on the wall.\n"))

(def SONG 
  (let [form (MessageFormat. LYRICS)]
    (vec
      (for [i (range 0 100)]
        (.format form (to-array [i (dec i)]))))))

(defn verse [n] (SONG n))

(defn sing 
  ([x] (sing x 0))
  ([x y]
   (let [verses (reverse (range y (inc x)))
         fragments (for [n verses] (verse n))]
     (join "\n" fragments))))