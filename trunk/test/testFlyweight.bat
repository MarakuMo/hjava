@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.dp.structual.flyweight

java %JRE_FLAGS% org.huys.dp.structual.flyweight.FlyweightDemo

@pause
