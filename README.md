To build the plugin:

* Clone the repo into your plugins folder
  * On OS X: `~/Library/Application Support/LightTable/plugins/`
  * On Linux: `~/.config/LightTable/plugins/`
  * On Windows: `%APPDATALOCAL%/LightTable/plugins/`
* Open [declassifier.cljs](https://github.com/LightTable/LightTable-Declassifier/blob/master/src/lt/plugins/declassifier.cljs)
* Connect an nrepl client to the [project.clj](https://github.com/LightTable/LightTable-Declassifier/blob/master/project.clj)
* Save [declassifier.cljs](https://github.com/LightTable/LightTable-Declassifier/blob/master/src/lt/plugins/declassifier.cljs) or run the command `Editor: Build file or project`. You should see "Compiled plugin to ...declassifer_compiled.js" in the statusbar
* Run the command `Plugins: Refresh plugin list` to detect the plugin
* Save [declassifier.behaviors](https://github.com/LightTable/Declassifier/blob/master/declassifier.behaviors) or run the command `App: Reload behaviors` to load/reload the plugin behaviors

For interactive development, use the built-in clojurescript eval (ctrl-enter by default) and choose the `Light Table UI` connection.

Note: due to [Issue 1042](https://github.com/LightTable/LightTable/issues/1042) the `App: Reload behaviors` command will not reload the plugin source. To pick up changes either use interactive eval or restart Light Table.

Important files are [plugin.edn](https://github.com/LightTable/LightTable-Declassifier/blob/master/plugin.edn), which contains metadata about the plugin and also points to the behaviors file.  The behaviors listed in [declassifier.behaviors](https://github.com/LightTable/LightTable-Declassifier/blob/master/declassifier.behaviors) are loaded by the plugin manager. Most plugins will contain at least `{:+ {:app [(:lt.objs.plugins/load-js "declassifier_compiled.js" true)]}}` in order to load code into Light Table.
