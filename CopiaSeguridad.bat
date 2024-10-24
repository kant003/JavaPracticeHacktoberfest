@echo off
:: Vamos a hacer un script que nos haga una copia de seguridad de los archivos/directorios que queramos.
:: By D4vy_prz.

:: Cositas varias que hacen que vaya de putis.
SetLocal EnableDelayedExpansion EnableExtensions
::Esto pregunta tanto el origen como el destino de los archivos/directorios.
Echo.
Echo.
Echo============================================================
Echo= BIENVENIDO AL GENERADOR DE COPIAS... 
Echo============================================================
Echo.
Echo.

set /p origen= Ruta que desea copiar:
set /p destino= Ruta de destino:
Echo.
Echo. Copiando archivos, espere...
Echo.
:: LLama a la función que copia.
robocopy "%origen%" "%destino%" /e /r:1 /w:1 /mir
Pause
cls
:: \\FIN//
Echo.
Echo. COPIA FINALIZADA.