(ns clj-cli.dispatcher-test
  (require [clj-cli.dispatcher :refer :all]
           [clojure.test :refer :all]))

(deftest operation-test
  (testing "should create a new operation"
    (is (= {"sum" +} (operation "sum" +)))))

(deftest register-test
  (testing "should register a new operation"
    (let [sum-op {"sum" +}
          div-op {"div" /}]
      (is (= sum-op (register (operation "sum" +))))
      (is (= div-op (register (operation "div" /))))
      (is (= (merge sum-op div-op) (register (operation "sum" +) (register (operation "div" /))))))))

(deftest dispatch-test
  (testing "should dispatch a operation"
    (is (= 2 (dispatch (register (operation "sum" +)) "sum" [1 1])))
    (is (= 12 (dispatch (register (operation "sum" +)) "sum" [1 1 10])))
    (is (= 5 (dispatch (register (operation "div" /)) "div" [10 2]))))
  (testing "should return nil if no operation is found"
    (is (nil? (dispatch {} "sum" [1 1])))
  ))

