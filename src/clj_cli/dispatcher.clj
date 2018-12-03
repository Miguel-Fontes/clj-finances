(ns clj-cli.dispatcher)

(defn operation
  "Create a new operation, defined by:

  * `name` a String representing the name of the operation
  * `operation` a function that executes the operation

  Returns a hash map (k, v) as (operation, function)"
  [name operation]
  {name operation})

(defn register
  "Register a new operation on the operations registry. If no registry is supplied, a new one will be created.

  * `registry` a `registry` of operations, containing all currently registered operations.
  * `operation` a `operation` to be inserted into the registry (see `clj-cli.operation)`.

  Returns a `registry` updated with the given operation.
  "
  ([operation] (register {} operation))
  ([registry & operations] (apply (partial merge registry) operations)))

(defn dispatch
  "Dispatches given operation to a previously registered operation

  * `registry` a `registry` containing the registered operations
  * `operation` the name of the operation to be dispatched
  * `args` the args that will be dispatched to the operation

   Returns the values returned by the `operation`, or `nil` if a 'operation` is not found."
  [registry operation & args]
  (let [operation-fn (get registry operation)]
    (if (nil? operation-fn)
      nil
      (apply operation-fn (flatten args)))))
