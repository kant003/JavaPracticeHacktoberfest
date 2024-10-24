print("calculadora")

def calculadora():

    num1 = float(input("primer numero: "))
    num2 = float(input("segundo numero: "))
    condi = str(input("Que quiers hacer, sumar, restar, multiplicar o divir? "))

    if condi == "sumar":
        sum = num1 + num2
        print("el resultado de la suma es: ", sum)

    elif condi == "restar":
        res = num1 - num2
        print("el resultador de la resta es: ", res)

    elif condi == "multiplicar":
        mult = num1 * num2
        print("el resultado de la multiplicacion es: ", mult)

    elif condi == "dividir":
        div = num1 / num2
        print("el resultado de la division es: ", div)

    else:
        print("SYNTAX ERROR")
        print("reiniciando")
        calculadora()
calculadora()

def reset():
        loop = str(input("Desea calcular algo mas? "))

        while loop == "si":
            calculadora()
        else:
            print("Hasta otra")
reset()