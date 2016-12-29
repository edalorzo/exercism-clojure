(ns bob)

(defn response-for [message]   
    (cond 
      (.matches (apply str (filter #(Character/isLetter %) message)) "[A-Z]+") "Whoa, chill out!"
      (.endsWith message "?") "Sure."
      (.matches message "\\s*") "Fine. Be that way!"
      :otherwise "Whatever."))
