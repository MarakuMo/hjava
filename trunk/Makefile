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
	$(JAR) cvf hjava.jar $(FINDCLASS)

dist :
	@echo "Make dist..."
	(cd .. &&  tar cjvf hjava.tgz hjava)

.PHONY : doc
doc :
	$(MAKEDOC)

.PHONY : clean
clean :
	$(MAKECLEAN)

