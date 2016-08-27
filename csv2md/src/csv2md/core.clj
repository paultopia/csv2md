;; Copyright 2014, 2015, 2016 John Gabriele <jgabriele@fastmail.fm>
;; (fork by Paul Gowder, paul.gowder@gmail.com, all copyright claims on fork
;; renounced to the extent compatible with GPL, else GPL)
;;
;; This program is free software: you can redistribute it and/or modify
;; it under the terms of the GNU General Public License as published by
;; the Free Software Foundation, either version 3 of the License, or
;; (at your option) any later version.
;;
;; This program is distributed in the hope that it will be useful,
;; but WITHOUT ANY WARRANTY; without even the implied warranty of
;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;; GNU General Public License for more details.
;;
;; You should have received a copy of the GNU General Public License
;; along with this program.  If not, see <http://www.gnu.org/licenses/>.

(ns csv2md.core
  (:gen-class)
  (:require 
   [clojure.data.csv :as csv]
   [clojure.string   :as str]))

(defn -main
  []
  (let [input-file (first *command-line-args*)
        rows (csv/read-csv (slurp input-file))
        inverted-rows (apply map vector rows)
        num-chars (for [r inverted-rows]
                    (map count r))
        max-col-sizes (map (fn [c] (apply max c)) num-chars)
        header (str/join "  " (for [n max-col-sizes]
                                (str/join (repeat (+ n 2) "-"))))]
    (println header)
    (doseq [row rows]
      (let [padded (for [[elem idx] (map vector row (range))]
                     (format (str "%-" (+ 2 (nth max-col-sizes idx)) "s")
                             elem))]
        (println (str/join "  " padded))))
    (println header)))

