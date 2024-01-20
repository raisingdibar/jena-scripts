(ns core
  (:require [com.yetanalytics.flint :as f]
            ;; [com.yetanalytics.flint-jena :as fj]
            [babashka.http-client :as http]
            [clojure.pprint :as pprint]))

(def query
  '{:prefixes {:ex "<http://example.org/>"}
    :describe [:ex/TylerDiBartolo]})

(comment 
  
  (printf (:body (http/get "http://localhost:3030/jtd"))) 

  (http/get "http://localhost:3030/jtd/sparql"
            {:query-params {"query" (f/format-query query :pretty? true)}})

  (-> (http/get "http://localhost:3030/jtd/sparql" 
                {:query-params {"query" (f/format-query query :pretty? true)}})
      :body)
  )