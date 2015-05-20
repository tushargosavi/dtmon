(defproject dtmon "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [clj-http "1.1.2"]
                 [cheshire "5.4.0"]
                 [stylefruits/gniazdo "0.4.0"]
                 [org.clojure/tools.cli "0.3.1"]]

  :plugins [[lein-bin "0.3.4"]]

  :main dtmon.core)
