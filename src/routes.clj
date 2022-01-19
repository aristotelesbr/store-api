(ns routes
  (:require [coast]
            [components]))

(def routes
  (coast/routes

   (coast/site
    (coast/with-layout components/layout
      [:get "/" :site.home/index]))

   (coast/api
    (coast/with-prefix "/api"
      [:get "/" :api.home/index]
      [:get "/products" :api.products/index]
      [:post "/products" :api.products/create]
      [:get "/products/:product-id" :api.products/view]
      [:put "/products/:product-id" :api.products/change]))))
