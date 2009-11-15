@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar;../lib/junit.jar;../lib/log4j.jar -Djava.library.path=..;../lib

echo Test org.huys.log

java %JRE_FLAGS% org.huys.log.Log4jExample

@pause
