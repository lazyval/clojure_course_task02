(ns clojure-course-task02.core
  (:require [clojure.core.reducers :as r])
  (:gen-class))

(defn find-files [pattern path]
  (->> (java.io.File. path)
       file-seq
       (r/filter #(.isFile %))
       (r/map #(.getName %))
       (r/filter #(re-matches (re-pattern pattern) %))
       (into [])))

(defn- usage []
  (println "Usage: $ run.sh file_name path"))

(defn -main [file-name path]
  (if (or (nil? file-name)
          (nil? path))
    (usage)
    (do
      (println "Searching for " file-name " in " path "...")
      (dorun (map println (find-files file-name path))))))
