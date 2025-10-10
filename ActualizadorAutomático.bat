@echo off
:: Un script encargado de buscar y actualizar software y controladores del dispositivo...
:: Antención puedes necesitar PERMISOS DE ADMINISTRADOR!!!
:: By D4vyprz

echo.
echo.
echo============================================================
echo= BIENVENIDO AL ACTUALIZADOR DE SOFTWARE... 
echo============================================================
echo.
echo.
echo Actualizando software y controladores...
timeout /t 5

:: Actualizar los paquetes instalados
echo Actualizando paquetes instalados...
winget upgrade --all
:: Actualizar controladores
echo Actualizando controladores...
:: Esto requiere permisos de administrador
pnputil /enum-drivers > drivers.txt
echo Controladores listados en drivers.txt.

:: Muestra un mensaje de finalización
echo.
echo.
echo============================================================
echo=  SCRIPT FINALIZADO! ...SOFTWARE ACTUALIZADO... 
echo============================================================
echo Revise que todo se haya instalado con exito, de lo contrario pruebe otra vez...
echo.
echo Script desarollado por @D4vyprz
echo.
pause
