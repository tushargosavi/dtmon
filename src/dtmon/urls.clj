(ns dtmon.urls)

(def gatewayaddr "http://172.17.0.6:9090")
(def api-version "/ws/v2/")

(defn get-applications-url
  []
  (str gatewayaddr api-version "applications"))

(defn get-physical-plan-url
  [appid]
  (str gatewayaddr api-version "applications/" appid "/physicalPlan"))
