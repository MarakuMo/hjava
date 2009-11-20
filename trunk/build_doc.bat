@echo off

REM Show Chinese Characters
chcp 936 2>NUL 1>NUL

set PATH=D:\Progs\Java\jdk1.6.0_14\bin;%PATH%

set PWD=%CD%

set CLASSPATH=%CLASSPATH%;%PWD%/lib/junit.jar;%PWD%/lib/log4j.jar

make doc

@pause