@echo off

REM
REM
REM
REM

REM
set CLASSPATH=%CLASSPATH%;../lib/junit.jar;../lib/log4j.jar;../lib/spring.jar;../lib/commons-logging.jar;../hjava.jar
REM set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.spring

java %JRE_FLAGS% org.huys.spring.hello.Hello

@pause
