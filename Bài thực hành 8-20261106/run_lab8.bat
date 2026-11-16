@echo off
chcp 65001 >nul
cls
echo ===============================================================================
echo        TRƯỜNG ĐẠI HỌC VĂN LANG - KHOA CÔNG NGHỆ THÔNG TIN
echo            KIỂM THỬ TỰ ĐỘNG (AUTOMATION TESTING) - THỰC HÀNH 08
echo   Sinh viên: Nguyễn Minh Phú - MSSV: 2374802013447 - Lớp: 232_71ITSE41603_0102
echo ===============================================================================
echo.

if not defined JAVA_HOME (
    if exist "C:\Program Files\Java\jdk-23" (
        set "JAVA_HOME=C:\Program Files\Java\jdk-23"
    ) else if exist "C:\Program Files\Java\jdk-21" (
        set "JAVA_HOME=C:\Program Files\Java\jdk-21"
    ) else if exist "C:\Program Files\Java\jdk-17" (
        set "JAVA_HOME=C:\Program Files\Java\jdk-17"
    )
)

echo [1/3] Kiem tra moi truong Java...
echo JAVA_HOME = %JAVA_HOME%
echo.

set "MVN_CMD=D:\ktdt\maven_tool\apache-maven-3.9.6\bin\mvn.cmd"
if not exist "%MVN_CMD%" (
    set "MVN_CMD=mvn"
)

echo [2/3] Bien dich du an (mvn test-compile)...
call "%MVN_CMD%" test-compile
if %ERRORLEVEL% NEQ 0 (
    echo [LOI] Bien dich that bai! Vui long kiem tra JDK.
    pause
    exit /b %ERRORLEVEL%
)

echo.
echo [3/3] Thuc thi TestNG Suite (Bai 1, Bai 2, Bai 3, Bai 4)...
call "%MVN_CMD%" test
echo.
echo ===============================================================================
echo   HOÀN THÀNH KIỂM THỬ BÀI THỰC HÀNH 08!
echo   Báo cáo chi tiết: target\surefire-reports\index.html
echo ===============================================================================
pause
