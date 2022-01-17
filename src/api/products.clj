(ns api.products
  (:require [coast]))

(defn create
  [request]
  (let [{:strs [name brand price]} (:body request)]
    {:status "ok" :data (coast/insert {:product/name name
                                       :product/brand brand
                                       :product/price price})}))

(defn index
  [request]
  {:status "ok" :data (coast/q [:select :* :from :product])})
