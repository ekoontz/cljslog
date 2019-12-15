# cljslog

Simple clojurescript library cobbled together from others' work found by online searches.
Nothing I found worked as-is so I adapted what I found.

Mostly copied from
https://gist.github.com/eval/f1aaab653927d39ec549f14defb21785#file-logging-cljs
by Gert Goet (https://github.com/eval).

## Usage

### Leiningen

Put in your project.clj file:

```
:dependencies [[org.clojure/clojure "1.10.1"]
               [org.clojure/clojurescript "1.10.597"
               [cljslog "0.1.0"]]]
```

### Your source code

Add to the top of your Clojurescript source files:

```
(ns myproject.core
  (:require
   [cljslog.core :as log]))

```

Your functions that use logging would look something like this example:

```
(defn my-function []
      (log/debug "don't worry..")
      (log/info "things look ok.")
      (log/warn "hmmm something unexpected..")
      (log/error "something's definitely wrong now."))
```

Hopefully you will see some corresponding log messages in your browser's console window.

## License

Copyright © 2019 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
