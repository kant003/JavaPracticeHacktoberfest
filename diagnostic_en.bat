@echo off
:: Script to execute specialized software to check device status.
:: By D4vy_prz on 07/08/2024. // Modified on 10/25/2024.
:: This script runs programs from a local directory, so the path may need editing...
:: Important: You must be an ADMINISTRATOR for full use of this script!!!
echo.
echo ======================================================================
echo                WELCOME TO THE DIAGNOSTIC SCRIPT...
echo ======================================================================
echo.
echo Do you want to run the diagnostic? (Y/N)
set /p response1=
if /i "%response1%"=="Y" (
    echo Running diagnostic...
    echo.

    :: Hardware Check
    echo Running disk check...
    echo.
    start "" "%~d0\HRWARE_TOOLS\crystaldiskinfo\DiskInfo64.exe"
    echo Please wait while the program runs...
    echo.
    pause
    echo Running software to display device information...
    echo.
    start "" "%~d0\HRWARE_TOOLS\hwi_800\HWiNFO64.exe"
    echo Please wait while the program runs...
    pause
    cls

    :: Advanced options menu
    :Advanced
    echo Select the command you want to execute:
    echo.
    echo 1. Check battery status
    echo 2. System file check (sfc /scannow)
    echo 3. RAM check (requires restart)
    echo 4. Generate system performance report (requires restart)
    echo 5. Exit
    echo.
    set /p option="Enter the option number: "

    if "%option%"=="1" (
        echo Generating battery report...
        powercfg /batteryreport
        echo.
        echo Battery report generated in your user folder.
    ) else if "%option%"=="2" (
        echo Running system file check...
        sfc /scannow
        echo.
    ) else if "%option%"=="3" (
        echo Warning: This command requires a restart.
        set /p continue="Do you want to continue? (Y/N): "
        if /i "%continue%"=="Y" (
            echo Running RAM diagnostic...
            mdsched
        ) else (
            echo Operation canceled by the user.
        )
    ) else if "%option%"=="4" (
        echo Warning: This command requires a restart.
        set /p continue="Do you want to continue? (Y/N): "
        if /i "%continue%"=="Y" (
            echo.
            echo Generating system performance report...
            perfmon /report
        ) else (
            echo Operation canceled by the user.
        )
    ) else if "%option%"=="5" (
        echo Exiting the program...
        goto end
    ) else (
        echo Invalid option, please try again.
        goto Advanced
    )
    
    echo.
    set /p response2="Do you want to run another specific check? (Y/N): "
    if /i "%response2%"=="Y" (
        cls
        goto Advanced
    )

    :: Network Check
    :continue
    cls
    echo CHECKING NETWORK STATUS:
    ping 8.8.8.8
    pause
    cls

    :: Cache and temporary files cleanup
    echo Clearing browser cache and temporary files...
    del /s /q /f "%TEMP%\*"
    del /s /q /f "%windir%\Temp\*"
    
    if exist "%LOCALAPPDATA%\Google\Chrome\User Data\Default\Cache" (
        rd /s /q "%LOCALAPPDATA%\Google\Chrome\User Data\Default\Cache"
    )
    echo.
    echo Cache cleared...
    echo.

    goto end
) else (
    echo.
    echo ======================================================================
    echo DIAGNOSTIC CANCELED...
    echo ======================================================================
    echo.
)

:end
echo ======================================================================
echo DIAGNOSTIC COMPLETED... 
echo ======================================================================
echo Script developed by @D4vy_prz
pause
