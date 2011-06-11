#
# Makefile for java
#
TOPDIR = .

include  $(TOPDIR)/make.inc


JAVASRC = $(FINDSRC)
CLASSES = ${JAVASRC:.java=.class}

#
.PHONY : all
all : $(CLASSES)

%.class : %.java
	$(JAVAC) $<

ARCHIVE :
	$(JAR) cvf hjava.jar $(FINDCLASS) log4j.properties

dist :
	@echo "Make dist..."
	(cd .. &&  tar cjvf hjava.tgz src)

.PHONY : doc
doc :
	$(MAKEDOC)

.PHONY : clean
clean :
	$(MAKECLEAN)
	rm -vf hjava.jar

