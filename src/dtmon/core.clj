(ns dtmon.core
  (require [dtmon.gatewayapi :as gwapi]))

(defn print-applications
  []
  (map #(prn %) (gwapi/get-applications)))

(defn -main
  "This is main function"
  []
  (print-applications))

;(defn get-operator-stats
;  []
;  ((map #(select-keys % ["recoveryWindowId" "currentWindowId" "tuplesProcessedPSMA" "latencyMA" "cpuPercentageMA" "id" "lastHeartbeat"]) (get plan "operators"))))