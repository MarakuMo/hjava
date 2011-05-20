@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.net

start java %JRE_FLAGS% org.huys.net.RMIServer

java %JRE_FLAGS% org.huys.net.RMIClient

@pause
