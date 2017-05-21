(ns gmbot.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] "Hello poop")
  (POST "/callback" request (str request))
  (GET "/callback" request (str request))
  (route/not-found "Not Found"))

(def app (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
