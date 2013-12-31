(ns lt.plugins.declassifier
  (:require [lt.objs.editor :as editor]
            [lt.objs.editor.pool :as pool])
  (:require-macros [lt.macros :refer [behavior]]))

(def classy->plain
  {"behaviour" "behavior"})

(defn declassify-string [string]
  (reduce
   (fn [string [classy plain]]
     (.replace string classy plain))
   string
   classy->plain))

(defn declassify-near-cursor []
  (let [cm (editor/->cm-ed (pool/last-active))
        cursor (.getCursor cm)
        from #js {:line (.-line cursor) :ch 0}
        classy-range (.getRange cm from cursor)
        plain-range (declassify-string classy-range)]
    (when (not= plain-range classy-range)
      (.replaceRange cm plain-range from cursor))))

(behavior ::on-change
          :triggers #{:change}
          :desc "Declassifier: Trigger on change"
          :debounce 500
          :reaction (fn [this]
                      (declassify-near-cursor)))