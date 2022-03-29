@echo off  
set localdir=%~dp0
set hh=%time:~0,2%
if /i %hh% LSS 10 (set hh=0%time:~1,1%)
mvn versions:set-property -Dproperty=modules.system.version -DnewVersion=1.0.0.%Date:~0,4%%Date:~5,2%%Date:~8,2%.%hh%
mvn versions:update-child-modules
mvn versions:commit
pause