@echo off

REM
REM
REM
REM

REM
set JRE_FLAGS=-classpath ../hjava.jar -Djava.library.path=..

echo Test org.huys.gui.HelloSwing

java %JRE_FLAGS% org.huys.gui.HelloSwing

java %JRE_FLAGS% org.huys.gui.CelsiusConverterGUI

java %JRE_FLAGS% org.huys.gui.HtmlDemo

@pause
