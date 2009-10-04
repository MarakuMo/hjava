#
# Makefile for java
#

#
JAVAC = javac
JAVA  = java
JAR   = jar

RM = rm -vf

OPTIONS = -verbose -d .

JAVASRC = $(shell find . -name *.java -type f -print)
CLASSES = ${JAVASRC:.java=.class}

#
.PHONY : all
all : $(CLASSES)

%.class : %.java
	$(JAVAC) $<

ARCHIVE :
	$(JAR) cvf hjava.jar org/

dist :
	@echo "Make dist..."
	(cd .. &&  tar cjvf hjava.tgz hjava)

.PHONY : clean
clean :
	find . -name *.class -type f -print0 | xargs -0 /bin/rm -vf

