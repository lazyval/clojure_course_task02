(ns clojure-course-task02.core
  (:gen-class))

(defn- find-files [file-name path]
  (->> (java.io.File. path)
       file-seq
       (filter #(.isFile %))
       (map #(.getName %))
       (filter #(re-matches (re-pattern filename) %))
       ))

(defn- usage []
  (println "Usage: $ run.sh file_name path"))

(defn -main [file-name path]
  (if (or (nil? file-name)
          (nil? path))
    (usage)
    (do
      (println "Searching for " file-name " in " path "...")
      (dorun (map println (find-files file-name path))))))
