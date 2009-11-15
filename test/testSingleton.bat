@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.dp.creational.singleton

java %JRE_FLAGS% org.huys.dp.creational.singleton.Singleton

@pause
