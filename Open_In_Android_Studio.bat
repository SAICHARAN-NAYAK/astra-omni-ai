@echo off
title Open Astra Omni in Android Studio
cls
echo =========================================================================
echo    ASTRA OMNI // ANDROID STUDIO APP LAUNCHER
echo =========================================================================
echo.
echo [*] Looking for Android Studio installation...

set "STUDIO_EXE="
if exist "%LOCALAPPDATA%\Programs\Android Studio\bin\studio64.exe" (
    set "STUDIO_EXE=%LOCALAPPDATA%\Programs\Android Studio\bin\studio64.exe"
) else if exist "%PROGRAMFILES%\Android\Android Studio\bin\studio64.exe" (
    set "STUDIO_EXE=%PROGRAMFILES%\Android\Android Studio\bin\studio64.exe"
) else if exist "%PROGRAMFILES(X86)%\Android\Android Studio\bin\studio64.exe" (
    set "STUDIO_EXE=%PROGRAMFILES(X86)%\Android\Android Studio\bin\studio64.exe"
)

if defined STUDIO_EXE (
    echo [*] Found Android Studio: "%STUDIO_EXE%"
    echo [*] Opening project: "%~dp0android_studio_app"
    start "" "%STUDIO_EXE%" "%~dp0android_studio_app"
) else (
    echo [!] Android Studio not found in standard paths.
    echo [*] Opening project folder in File Explorer...
    start explorer.exe "%~dp0android_studio_app"
)

pause
