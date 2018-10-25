package com.cebem.src;

import java.util.ArrayList;

public class NumeroPerfectoUtil {

	

	public boolean isPerfect(int numero) {
        if(numero == 0) return false;
         
        int suma = 0;
        for(int i=1; i<numero; i++) {
            if(numero % i == 0) {
                suma += i;
            }
        }
        /*if(suma == numero) {
            return true;
        }else {
            return false;
        }*/
        return suma == numero;
    }
 
    public ArrayList<Integer> getDivisores(int numero) {
        ArrayList<Integer> lista = 
                new ArrayList<Integer>();
 
 
        for(int i=1;i<=numero; i++) {
            if(numero % i == 0) {
                lista.add(i);
            }
        }
         
        return lista;
    }
 
    public ArrayList<Integer> getFirstPerfects(int max) {
        ArrayList<Integer> lista = 
                new ArrayList<Integer>();
 
        for(int i=0;i<=max;i++) {
            if( isPerfect(i) ) {
                lista.add(i);
            }
        }
         
        return lista;
    }
}
