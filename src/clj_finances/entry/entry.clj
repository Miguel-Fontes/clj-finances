(ns clj-finances.entry.entry)

(defn entry
  "Creates a new entry, consuming the given arguments

  * `date` the refer date of the entry
  * `description` a explanation of the entry
  * `category` the category type of the entry
  * `amount` the value of the entry in cents an (integer)

  Returns a new Entry
  "
  [date description category amount]
  {:date date
   :description description
   :category category
   :amount amount})


