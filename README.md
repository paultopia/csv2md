Note: this is just a fork of the csv2md inlein script.  Inlein hates me, I can never make it work, so I forked it as an executable jar. See original at https://github.com/uvtc/csv2md

# csv2md

Turns this:

~~~
aquamarine,8,circle
green,9,ellipsoid
blue,10,curvy
~~~

into:

~~~
------------  ----  -----------
aquamarine    8     circle
green         9     ellipsoid
blue          10    curvy
------------  ----  -----------
~~~

(You'll have to move that first table delimiter line down if
the first line of your csv is intended to be a heading.)

Sends to stdout by default, will need to be redirected into a file to keep it.

## What is it?

It's a small command-line executable. It happens to be written in
[Clojure](http://clojure.org/).


## Prerequisites

You'll need to have already installed:

  * [Java](http://openjdk.java.net/) (known to work with openjdk-{7,8}-jre)


## Compatibility

Verified to work on OSX.  Probably other stuff too.


## Install

Download csv2md from [releases](https://github.com/paultopia/csv2md/releases). Put it on your $PATH.  If it isn't executable already, change that with `chmod +x csv2md`


## Usage

    csv2md foo.csv > foo.md


## License

GPLv3. See [COPYING.txt](COPYING.txt) for details.

Copyright 2014, 2015, 2016 John Gabriele <jgabriele@fastmail.fm>
Fork by Paul Gowder, no rights claimed.  
