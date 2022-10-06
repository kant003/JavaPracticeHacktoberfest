# Como realizar una Pull request

Cuando queremos contribuir a un proyecto de codio abierto realizamos un **pull request** y los pasos son los indicados a continucion:

1. **Realizar un fork** del repositorio haciendo clic en el boton fork que aparece en la parte superior de la pagina, lo que creara una instancia del repositorio en tu cuenta.

2. **Clonar el repositorio** pulsando el boton clone y copiando el link y a continuacion abriend la terminal para ejecutar el siguiente comando: _git clone_ seguido del link copiado. Ahora que la copia de la rama esta hecha ddebemos ir al repositorio clonado con el siguiente comando: _cd (nombre del repositorio)_.

3. **Crear una rama** para lo que usaremos el comando: _git checkout -b(nombre rama)_.

4. **Realizar cambios** que para verlos tendremos que ejecutar _git status_. Luego agregaremos esos cambios usando _git add_ seguido del comando _git commit_ para confirmar esos cambios.

5. **Enviar los cambios** a GitHub, para lo que identificaremos e nombre del repositorio con _git remote_ y una vez localizado usaremos _git push (nombre repositorio) (nombre de la rama)_.

6. **Crear un pull request** pulsando el boton "Pull request" situado en tu repositorio.

***Ya estaria hecho tu pull request.***




