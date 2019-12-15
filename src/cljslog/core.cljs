(ns cljslog.core
  (:refer-clojure :exclude [time])
  (:require [goog.log :as glog])
  (:import goog.debug.Console))

;; Thanks to Gert Goet (https://github.com/eval) for:
;;  https://gist.github.com/eval/f1aaab653927d39ec549f14defb21785#file-logging-cljs
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
(log-to-console!)

(defn set-level! [level]
  (.setLevel logger (get levels level (:info levels))))

(defn fmt [msgs]
  (apply str (interpose " " (map pr-str msgs))))

(defn info [& s]
  (let [msg (fmt s)]
    (glog/info logger msg)))

(defn debug [& s]
  (let [msg (fmt s)]
    (glog/fine logger msg)))

(defn error [& s]
  (let [msg (fmt s)]
    (glog/error logger msg)))

(defn warn [& s]
  (let [msg (fmt s)]
    (glog/warning logger msg)))


