@echo off
chcp 65001 >nul
cls
python "%~dp0run_tests_api.py"
pause
