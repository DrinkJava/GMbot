(ns gmbot.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))




(defn callback
  [req]
  (str req))

(defroutes app-routes
  (GET "/" [] "Hello poop")
  (POST "/callback" request callback)
  (POST "/" [] "You FUCK")
  (route/not-found "Not Found\n"))


(def app (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
