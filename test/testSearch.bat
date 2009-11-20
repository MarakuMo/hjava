@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.algo.search

java %JRE_FLAGS% org.huys.algo.search.SequentialSearch

@pause
