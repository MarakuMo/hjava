@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar;../lib/junit.jar -Djava.library.path=..;../lib

echo Test org.huys.test

java %JRE_FLAGS% org.junit.runner.JUnitCore org.huys.test.SubscriptionTest

java %JRE_FLAGS% org.junit.runner.JUnitCore org.huys.test.SubscriptionTestCase

@pause
