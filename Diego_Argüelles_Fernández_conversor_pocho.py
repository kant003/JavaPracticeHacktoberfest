print("conversor de divisas")

def conversor():
    print("Monedas aceptadas: Euro, Dolar y Libra")
    moneda1 = str(input("Moneda original: "))
    vmoneda1 = float(input("Cantidad: "))
    moneda2 = str(input("Moneda a la que cambiar: "))

    eu, eu2, eu3 = 1, 1.18, 0.9
    lb, lb2, lb3 = 0.84, 1, 0.76
    d, d2, d3 = 1.11, 1.31, 1

    if moneda1 == "Euro, euro, Eu, eu" and moneda2 == "Libra, libra, Lb, lb":
        fmoneda = vmoneda1 * lb
        print("Son", fmoneda)

    elif moneda1 == "Euro, euro, Eu, eu" and moneda2 == "Dolar, dolar, Dl, dl":
        fmoneda = vmoneda1 * d
        print("Son", fmoneda)

    elif moneda1 == "Libra,libra, Lb, lb" and moneda2 == "Euro, euro, Eu, eu":
        fmoneda = vmoneda1 * eu2
        print("Son", fmoneda)

    elif moneda1 == "Libra, libra, Lb, lb" and moneda2 == "Dolar, dolar, Dl, dl":
        fmoneda = vmoneda1 * d2
        print("Son", fmoneda)
        
    elif moneda1 == "Dolar, dolar, Dl, dl" and moneda2 == "Euro, euro, Eu, eu":
        fmoneda = vmoneda1 * eu3
        print("Son", fmoneda)

    elif moneda1 == "Dolar, dolar, Dl, dl" and moneda2 == "Libra, libra, Lb, lb":
        fmoneda = vmoneda1 * lb3
        print("Son", fmoneda)
conversor()

def reset():
        loop = str(input("Desea calcular algo mas? "))

        while loop == "si":
            conversor()
        else:
            print("Hasta otra")
reset()