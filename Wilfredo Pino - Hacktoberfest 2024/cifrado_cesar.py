def cifrado_cesar(texto, desplazamiento):
    resultado = ""
    for letra in texto:
        if letra.isalpha():
            # Definir si la letra es mayúscula o minúscula
            inicio = ord('A') if letra.isupper() else ord('a')
            # Aplicar el desplazamiento dentro de las 26 letras del alfabeto
            posicion = (ord(letra) - inicio + int(desplazamiento)) % 26
            nueva_letra = chr(inicio + posicion)
            resultado += nueva_letra
        else:
            # Mantener los caracteres no alfabéticos sin cambios
            resultado += letra
    return resultado

if __name__ == "__main__":
    # Iniciar un ciclo para que el programa siga corriendo hasta que el usuario elija salir
    while True:
        # Mostrar el menú de opciones
        print("\nElige una opción:")
        print("1. Cifrar texto")
        print("2. Descifrar texto")
        print("3. Salir")
        
        opcion = input("Ingresa 1, 2 o 3: ")

        # Salir del programa si elige 3
        if opcion == '3':
            print("Saliendo del programa...")
            break

        # Pedir al usuario que ingrese el texto y el desplazamiento si eligió cifrar o descifrar
        if opcion in ['1', '2']:
            texto = input("Ingresa el texto: ")
            desplazamiento = input("Ingresa el desplazamiento (clave numérica): ")

            # Verificar que el desplazamiento sea un número
            if not desplazamiento.isdigit():
                print("El desplazamiento debe ser un número.")
            else:
                desplazamiento = int(desplazamiento)  # Convertir el desplazamiento a entero

                if opcion == '1':
                    # Opción para cifrar
                    cifrado = cifrado_cesar(texto, desplazamiento)
                    print("Texto cifrado:", cifrado)
                elif opcion == '2':
                    # Opción para descifrar (se invierte el desplazamiento)
                    descifrado = cifrado_cesar(texto, -desplazamiento)
                    print("Texto descifrado:", descifrado)
        else:
            print("Opción no válida. Por favor, elige 1, 2 o 3.")

            
