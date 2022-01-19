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

(defn view
  [request]
  (let [id (-> request :params :product-id)
        product (coast/fetch :product id)]
    (if (nil? product)
      (coast/not-found {:message "not found"})
      {:status "ok" :data product})))

(defn change
  [request]
  (let [product (coast/fetch :product (-> request :params :product-id))
        [result errors] (->
                         (select-keys product [:product/id])
                         (merge (:body request))
                         (coast/update)
                         (coast/rescue))]
    {:status "ok" :data result}))
