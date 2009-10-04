#!/bin/bash

###
JDK_INC=/usr/lib/jvm/java-1.6.0-openjdk-1.6.0.0.x86_64/include
JDK_LIB=/usr/lib
JRE_LIB=/usr/lib/jvm/jre/lib/amd64/server
###

#g++ -fPIC -c glue.cpp -I/opt/progs/jdk/include -I/opt/progs/jdk/include/linux/
#g++ -shared -o libglue.so -L/opt/progs/jdk/lib glue.o

#gcc -c myjvm.c -I/opt/progs/jdk/include -I/opt/progs/jdk/include/linux
#gcc -o myjvm myjvm.o -L/opt/progs/jdk/jre/lib/amd64/server -ljvm

g++ -fPIC -c glue.cpp -I${JDK_INC} -I${JDK_INC}/linux
g++ -shared -o libglue.so glue.o

gcc -c myjvm.c -I${JDK_INC} -I${JDK_INC}/linux
gcc -o myjvm myjvm.o -L${JRE_LIB} -ljvm


