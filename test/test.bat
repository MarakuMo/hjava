@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.simple.hello

java %JRE_FLAGS% org.huys.simple.Hello abc

@pause

echo Test org.huys.dp.creational.Prototype

java %JRE_FLAGS% org.huys.dp.creational.prototype.FactoryProto tom dick harry
java %JRE_FLAGS% org.huys.dp.creational.prototype.PrototypeDemo  Garbage This That Nothing TheOther


@pause

echo Test org.huys.dp.behavioral.templatemethod

java %JRE_FLAGS% org.huys.dp.behavioral.templatemethod.TemplateMethodDemo

@pause
