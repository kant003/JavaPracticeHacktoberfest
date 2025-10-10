@echo off
:: Script encargado de ejecutar software especializado para comprobar el estado del dispositivo.
:: By D4vy_prz el 07/08/2024. // Módificado a 25/10/2024.
:: Este script ejecuta programas es un directorio local, por lo que se debería editar la ruta...
:: ¡¡¡Importante debes ser ADMINISTRADOR para el uso completo del script!!!
echo.
echo ======================================================================
echo                BIENVENIDO AL SCRIPT DIAGNOSTICO...
echo ======================================================================
echo.
echo ¿Desea ejecutar el diagnostico? (S/N)
set /p respuesta1=
if /i "%respuesta1%"=="S" (
    echo Ejecutando diagnostico...
    echo.

    :: Comprobación de Hardware
    echo Ejecutando comprobacion de disco...
    echo.
    start "" "%~d0\HRWARE_TOOLS\crystaldiskinfo\DiskInfo64.exe"
    echo Espere hasta que se ejecute el programa...
    echo.
    pause
    echo Ejecutando software para mostrar informacion del equipo...
    echo.
    start "" "%~d0\HRWARE_TOOLS\hwi_800\HWiNFO64.exe"
    echo Espere hasta que se ejecute el programa...
    pause
    cls

    :: Menú de opciones avanzadas
    :Especializado
    echo Seleccione el comando que desea ejecutar:
    echo.
    echo 1. Comprobar el estado de la bateria
    echo 2. Comprobacion de archivos del sistema (sfc /scannow)
    echo 3. Comprobacion de la memoria RAM (necesita reiniciar)
    echo 4. Generar informe de rendimiento del sistema (necesita reiniciar)
    echo 5. Salir
    echo.
    set /p opcion="Ingrese el numero de la opcion: "

    if "%opcion%"=="1" (
        echo Generando informe de bateria...
        powercfg /batteryreport
        echo.
        echo Informe de bateria generado en su carpeta de usuario.
    ) else if "%opcion%"=="2" (
        echo Ejecutando comprobacion de archivos del sistema...
        sfc /scannow
        echo.
    ) else if "%opcion%"=="3" (
        echo Advertencia: Este comando necesita reiniciar el equipo.
        set /p continuar="Desea continuar? (S/N): "
        if /i "%continuar%"=="S" (
            echo Ejecutando diagnostico de memoria RAM...
            mdsched
        ) else (
            echo Operacion cancelada por el usuario.
        )
    ) else if "%opcion%"=="4" (
        echo Advertencia: Este comando necesita reiniciar el equipo.
        set /p continuar="Desea continuar? (S/N): "
        if /i "%continuar%"=="S" (
            echo.
            echo Generando informe de rendimiento del sistema...
            perfmon /report
        ) else (
            echo Operacion cancelada por el usuario.
        )
    ) else if "%opcion%"=="5" (
        echo Saliendo del programa...
        goto fin
    ) else (
        echo Opcion no valida, por favor intente nuevamente.
        goto Especializado
    )
    
    echo.
    set /p respuesta2="¿Desea realizar otra comprobacion especifica? (S/N): "
    if /i "%respuesta2%"=="S" (
        cls
        goto Especializado
    )

    :: Comprobación de red
    :continuar
    cls
    echo COMPROBEMOS EL ESTADO DE LA RED:
    ping 8.8.8.8
    pause
    cls

    :: Limpieza de caché y archivos temporales
    echo Limpiando cache de navegadores y archivos temporales...
    del /s /q /f "%TEMP%\*"
    del /s /q /f "%windir%\Temp\*"
    
    if exist "%LOCALAPPDATA%\Google\Chrome\User Data\Default\Cache" (
        rd /s /q "%LOCALAPPDATA%\Google\Chrome\User Data\Default\Cache"
    )
    echo.
    echo Cache liberada...
    echo.

    goto fin
) else (
    echo.
    echo ======================================================================
    echo DIAGNOSTICO CANCELADO...
    echo ======================================================================
    echo.
)

:fin
echo ======================================================================
echo DIAGNOSTICO FINALIZADO... 
echo ======================================================================
echo Script desarollado por @D4vy_prz
pause
