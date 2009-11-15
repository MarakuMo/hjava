@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.dp.behavioral.strategy

java %JRE_FLAGS% org.huys.dp.behavioral.strategy.StrategyDemo

@pause
