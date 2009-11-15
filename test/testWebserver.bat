@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.web

java %JRE_FLAGS% org.huys.web.webserver_starter

@pause
