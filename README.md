To build the plugin:

* Clone the repo into your plugins folder
* Open [declassifier.cljs](https://github.com/LightTable/LightTable-Declassifier/blob/master/src/lt/plugins/declassifier.cljs)
* Connect an nrepl client to the [project.clj](https://github.com/LightTable/LightTable-Declassifier/blob/master/project.clj)
* Run the command `Editor: Build file or project` (you should see "Compiled plugin to ...declassifer_compiled.js" in the statusbar)

To load/reload the plugin:

* Run the command `Plugins: Refresh plugin list`
* Run the command `App: Reload behaviors`

The plugin will also be loaded on restarting Light Table.

Important files are [plugin.edn](https://github.com/LightTable/LightTable-Declassifier/blob/master/plugin.edn), which contains metadata about the plugin and also points to the behaviors file.  The behaviors listed in [declassifier.behaviors](https://github.com/LightTable/LightTable-Declassifier/blob/master/declassifier.behaviors) are loaded by the plugin manager. Most plugins will contain at least `{:+ {:app [(:lt.objs.plugins/load-js "declassifier_compiled.js" true)]}}` in order to load code into Light Table.