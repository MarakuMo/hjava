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
    FINDSRC = $(shell wbin\find org \( -name *.java -not -name Hello3d.java \) -type f -print)
    FINDCLASS = $(shell wbin\find org -name *.class -type f -print)
    MAKECLEAN = wbin\find org \( -name *.class -o -name *.jar \) -type f -print0 -delete
    MAKEDOC = javadoc -locale en_US -sourcepath org -d doc $(FINDSRC)
else
    SHELL = /bin/bash
    WINE = LC_CTYPE="zh_CN.UTF-8" /opt/build/wine/bin/wine
    FINDSRC = $(shell find org \( -name *.java -not -name Hello3d.java \) -type f -print)
    FINDCLASS = $(shell find org -name *.class -type f -print)
    MAKECLEAN = find org \( -name *.class -o -name *.jar \) -type f -print0 | xargs -0 /bin/rm -vf
endif
