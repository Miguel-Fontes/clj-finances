(ns clj-finances.core
  (:require [clj-finances.entry.entry :refer :all]
            [clj-cli.dispatcher :refer :all])
  (:gen-class))

(defn add
  [& args]
  (let [new-entry (apply entry args)]
    (println new-entry)))

(def registry (register (operation "add" add)))

(defn -main
  "The applications entry point. The first argument is always a operation
   to be executed."
  [operation & args]
  (dispatch registry operation args))
