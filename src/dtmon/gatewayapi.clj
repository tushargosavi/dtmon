(ns dtmon.gatewayapi
  (:require [clj-http.client :as client]
            [dtmon.urls :as urls]
            [cheshire.core :refer :all]))

(defn get-applications []
  (let [resp (client/get (dtmon.urls/get-applications-url))
        body (parse-string (:body resp))
        apps (get body "apps")]
    apps))

(defn get-running-apps
  ([]
    (let [apps (get-applications)]
      (get-running-apps apps)))
  ([apps]
    (filter #(= (get %1 "state") "RUNNING") apps)))

(defn get-app-by-name [name]
  (let [apps (get-applications)
        matched (filter #(= (get %1 "name") name) apps)]
    matched))

(defn get-runnig-app [name]
  (filter #(= (get %1 name)) (get-running-apps)))

(defn get-physical-plan [appid]
  (let [resp (client/get (dtmon.urls/get-physical-plan-url appid))
       body (parse-string (:body resp))]
  body))
