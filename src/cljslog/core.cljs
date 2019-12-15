(ns cljslog.core
  (:require [goog.log :as glog])
  (:import goog.debug.Console))

(def logger
     (glog/getLogger "app"))

(def levels {:severe goog.debug.Logger.Level.SEVERE
             :warning goog.debug.Logger.Level.WARNING
             :info goog.debug.Logger.Level.INFO
             :config goog.debug.Logger.Level.CONFIG
             :fine goog.debug.Logger.Level.FINE
             :finer goog.debug.Logger.Level.FINER
             :finest goog.debug.Logger.Level.FINEST})

(defn log-to-console! []
  (.setCapturing (goog.debug.Console.) true))

(defn set-level! [level]
  (.setLevel logger (get levels level (:info levels))))

(defn fmt [msgs]
  (apply str (interpose " " (map pr-str msgs))))

(defn trace [message])
(defn debug [message])
(defn info [& s]
  (let [msg (fmt s)]
   (glog/info logger msg)))

(defn info [message])
(defn warn [message])
(defn error [message])
