(ns dtmon.pubsub
  (require [gniazdo.core :as ws]))

(def socket (atom nil))

(defn connect [url]
  (dosync (ref-set socket (ws/connect url
              :on-receive handle-data))))

(defn handle-data [data]
  (prn 'received data))

(defn subscribe [topic]
  (ws/send-msg @socket (str "{\"type\":\"subscribe\",\"topic\":\"" topic "\"}")))

(defn unsubscribe [topic]
  (ws/send-msg @socket (str "{\"type\":\"unsubscribe\",\"topic\":\"" topic "\"}")))

(defn app-topic [appid] (str "applications." appid ))
(defn physicalplan-topic [appid] (str "applications." appid ".physcialPlan"))
(defn event-topic [appid] (str "applications." appid ".events"))
(defn logical-topic (str "applications." appid ".logicalPlan"))
(defn container-topic (str "applications." appid ".containers"))

(defn subsribe-app [appid]
  (subscribe (app-topic appid)))

(defn unsubscribe-app [appid]
  (unsubscribe (app-topic appid)))

(defn subscribe-physcal-plan [appid]
  (subscribe (physicalplan-topic appid)))

(defn unsubscript-physcial-plan [appid]
  (unsubscribe (physicalplan-topic appid)))

(defn subscribe-events [app]
  (subscribe (event-topic app)))

(defn unsubscribe-events [app]
  (unsubscribe (event-topic appid)))

(defn subscribe-logical-plan [app]
  (subscribe (logical-toic app)))

(defn unsubscribe-logical-plan [app]
  (unsubscribe (logical-topic app)))