@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.dp.structural.flyweight

java %JRE_FLAGS% org.huys.dp.structural.flyweight.FlyweightDemo

@pause
