(ns dtmon.core
  (:gen-class)
  (require [dtmon.gatewayapi :as gwapi]
           [dtmon.urls :as urls]))

(defn get-operator-stats
  [appid]
  (let [plan (gwapi/get-physical-plan appid)]
    (map #(select-keys % ["recoveryWindowId"
                          "currentWindowId"
                          "tuplesProcessedPSMA"
                          "latencyMA"
                          "cpuPercentageMA"
                          "id"
                          "lastHeartbeat"])
         (get plan "operators"))))

(defn gather-loop
  [appid]
  (while true
    (doall (map #(prn %) (get-operator-stats appid)))
    (Thread/sleep 5000)))

(defn -main
  "This is main function"
  [& args]
  (let [gateway (first args)
        appid (second args)]
    (urls/set-gateway gateway)
    (gather-loop appid)))
