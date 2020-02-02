for /f %%i in ('chdir') do set CWD=%%i
start iexplore "%CWD%\index.xml"
