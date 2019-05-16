@echo off
set BASEDIR=%=C:%
REM set LIBDIR=%BASEDIR%\target\dependency
set CPDIR=%BASEDIR%\target\classes
REM
REM set classpath to use all JARS in the directory using --> %LIBDIR%\*  (not "*.jar"!)
REM
REM set  CLASSPATH=%LIBDIR%\*;%CPDIR%;.
set  CLASSPATH=%LIBDIR%\*;%CPDIR%;.

if not exist %CPDIR%\gaknet\App.class echo gaknet.App class files does not exists
REM if not exist target\dependency echo target\dependency does not exist    

if not exist %CPDIR%\gaknet\App.class goto end
REM if not exist target\dependency goto end

@echo on
cd target\classes && java -cp %CLASSPATH% gaknet.App && cd ..\..

:end
