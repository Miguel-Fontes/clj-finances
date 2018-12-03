(ns clj-finances.entry.entry-test
  (:require [clojure.test :refer :all]
            [clj-finances.entry.entry :refer :all]))

(deftest entry-test
  (testing "entry creation"
    (is (= (entry "2018-05-07" "a payment" "health" 1000)
           {:date "2018-05-07" :description "a payment" :category "health" :amount 1000}))))
