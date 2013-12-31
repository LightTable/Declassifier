(ns lt.plugins.declassifier
  (:require-macros [lt.macros :refer [behavior]]))

(behavior ::on-change
          :triggers #{:change}
          :desc "Declassifier: Trigger on change"
          :debounce 100
          :reaction (fn [this]
                      (js/alert "Class detected!")))