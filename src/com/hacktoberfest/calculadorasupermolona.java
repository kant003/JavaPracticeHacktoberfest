package com.hacktoberfest;

import javax.swing.JOptionPane;

public class calculadora {

	public static void main(String[] args) {
		
		int op=0;
		double n1,n2,s,m,d,r;
		
		do{
			 op=Integer.parseInt(JOptionPane.showInputDialog("nCalculadoran"+
			            "************n"+
			            "[1] SUMARn"+
			            "[2] RESTARn"+
			            "[3] MULTIPLICARn"+
			            "[4] DIVIDIRn"+
			            "[5] SALIRn"+
			            "Ingresa una opcion:"));

		switch(op){
		
		case 1:
			n1=Double.parseDouble(JOptionPane.showInputDialog ("Ingresa numero 1:"));
			n2=Double.parseDouble(JOptionPane.showInputDialog("Dime el numero 2:"));
			s=n1+n2;
			JOptionPane.showMessageDialog(null,"La suma es:"+s);
		break;
		
		case 2:
			n1=Double.parseDouble(JOptionPane.showInputDialog("Ingresa numero 1:"));
		n2=Double.parseDouble(JOptionPane.showInputDialog("Ingresa numero 2:"));
		
		r=n1-n2;
		JOptionPane.showMessageDialog(null,"La resta es:"+r);
		break;
		case 3:
			n1=Double.parseDouble(JOptionPane.showInputDialog ("Ingresa numero 1:"));
			n2=Double.parseDouble(JOptionPane.showInputDialog("Dime el numero 2:"));
			
			m=n1*n2;
			JOptionPane.showMessageDialog(null,"El producto es:"+m);
			break;
		case 4:
			n1=Double.parseDouble(JOptionPane.showInputDialog ("Ingresa numero 1:"));
			n2=Double.parseDouble(JOptionPane.showInputDialog("Dime el numero 2:"));
			
			d=n1/n2;
			JOptionPane.showMessageDialog(null,"El cociente es:"+d);
			break;
		}
		
		}while(op!=5);
		
		}
			
		

	}


