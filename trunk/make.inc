#
# filename : make.inc
# author   : huys
# updated  : 2009.10.06.
# version  : 0.0.1
#

####################################
# The building environment
####################################

ifeq ($(shell uname), Linux)
  PLATFORM = linux32
else
  PLATFORM = win32
endif

#
#
JAVAC = javac
JAVA  = java
JAR   = jar

RM = rm -vf

#
OPTIONS = -verbose -Xlint:deprecation -d .



#
#
ifeq ($(PLATFORM), win32)
    SHELL = cmd.exe
    WINE =
    FINDSRC = $(shell wbin\find . \( -name *.java -not -name Hello3d.java \) -type f -print)
    FINDCLASS = $(shell wbin\find . -name *.class -type f -print)
    MAKECLEAN = wbin\find . \( -name *.class -o -name *.jar \) -type f -print0 -delete
else
    SHELL = /bin/bash
    WINE = LC_CTYPE="zh_CN.UTF-8" /opt/build/wine/bin/wine
    FINDSRC = $(shell find . \( -name *.java -not -name Hello3d.java \) -type f -print)
    FINDCLASS = $(shell find . -name *.class -type f -print)
    MAKECLEAN = find . \( -name *.class -o -name *.jar \) -type f -print0 | xargs -0 /bin/rm -vf
endif
