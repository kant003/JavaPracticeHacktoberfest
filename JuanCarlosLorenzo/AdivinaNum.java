package java1DAM;

import java.util.Scanner;

public class AdivinaNum {

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);

int random=(int)(1+Math.random()*101), n=0, contador=0, vidas=10;
String vidaCadenita = " \u2764 \u2764 \u2764 \u2764 \u2764 \u2764 \u2764 \u2764 \u2764 \u2764";

String[] vidasArray= {"","No te rindas leyenda \n",
"CRÍTICO \n", 
"Lo tuyo es d coña bro \n",
"No esta mal \n",
"Este t ha dolido \n"
, "5 hmmmmm \n"
,"4..... mala suerte \n"
,"No hay dos sin tres \n"
,"cayo la segunda \n"
,"una menos bro... \n"};

do {
System.out.println("Adivina el numerin (del 1 al 100) jeje");
n=sc.nextInt();

if(n>100) {
System.out.println("Que haces retrasao, ahora por listo, -1 vida");
System.out.println("--------------------------------------------");
contador++;
}
if(n<random) {
System.out.println("mi numero es mayor brodi");
System.out.println("-------------------------");
contador++;
}
if(n>random && !(n>=100)) {
System.out.println("mi numero es menor");
System.out.println("-------------------------");
contador++;
}
if(n!=random) {
vidas--;
vidaCadenita = vidaCadenita.replaceFirst(" \u2764", "");

System.out.println("vidas: " +vidaCadenita+ "\n");
System.out.println(vidasArray[vidas+1]);
}
}while(n!=random && vidas>=0);
if(vidas<0) {
System.out.println("Perdiste, pero recuerda; No es mas rico quien mas tiene, si no el que menos necesita");
}
if(n==random) {
System.out.println("Grande chaval a la primera (TONTOOOOO)");

System.out.println("Has adivinao en " +contador+ " intentos Grandeeeeeeeeee \n");
}
//if para decir q pasa si lo consigues a la primera
if(vidas>=1) {
System.out.println("LO TUYA ES D COÑA");
}
if(vidas>=4) {
System.out.println("No ha estado mal");
}
if(vidas>=7) {
System.out.println("Molas");
}
if(vidas==9) {
System.out.println("Molas mucho");
}
if(vidas==10) {
System.out.println("Corre a tirar la loteria");
}

sc.close();
}

}

