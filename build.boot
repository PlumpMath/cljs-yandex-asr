(set-env!
  :source-paths   #{"src"}
  :dependencies '[[adzerk/boot-cljs       "1.7.48-5" :scope "test"]
                  [adzerk/boot-cljs-repl  "0.2.0" :scope "test"]
                  [adzerk/boot-reload     "0.4.0" :scope "test"]
                  [adzerk/bootlaces       "0.1.12"]
                  [jarohen/chord          "0.6.0"]
                  [org.clojure/clojure    "1.7.0"]
                  [org.clojure/clojurescript "1.7.122"]
                  [org.clojure/core.async "0.1.346.0-17112a-alpha"]]
  )

(require
  '[adzerk.boot-cljs      :refer [cljs]]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
  '[adzerk.boot-reload    :refer [reload]]
  '[adzerk.bootlaces      :refer :all])

(def +version+ "0.1.4")
(bootlaces! +version+)

(task-options!
  push {:ensure-clean false}
  pom  {:project     'cljs-yandex-asr
        :version     +version+
        :description "ClojureScript core.async interface to Yandex ASR"
        :url "https://github.com/voldmar/cljs-yandex-asr"
        :license {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build []
  (set-env! :source-paths #{"src"})
  (comp (cljs :optimizations :advanced)))
