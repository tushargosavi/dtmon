(ns dtmon.urls)

(def gatewayaddr (ref nil))
(def api-version "/ws/v2/")

(defn set-gateway
  [gateway]
  (dosync
    (ref-set gatewayaddr gateway)))

(defn get-applications-url
  []
  (str "http://" @gatewayaddr ":9090" api-version "applications"))

(defn get-physical-plan-url
  [appid]
  (str (get-applications-url) "/" appid "/physicalPlan"))
