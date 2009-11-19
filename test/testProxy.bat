@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.dp.structural.proxy

start java %JRE_FLAGS% org.huys.dp.structural.proxy.ProxyDemo first

start java %JRE_FLAGS% org.huys.dp.structural.proxy.ProxyDemo second

REM @pause
