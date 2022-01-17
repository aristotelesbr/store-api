(ns migrations.20220117083918-create-table-product
  (:require [coast.db.migrations :refer :all]))

(defn change []
  (create-table :product
    (text :name)
    (text :brand)
    (decimal :price)
    (timestamps)))