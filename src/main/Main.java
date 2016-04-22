package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import algoritmo.AlgoritmoBaseGrebner;
import algoritmo.AlgoritmoDivisor;
import datos.Polinomio;
import datos.ResultadoDivision;
import datos.Termino;

public class Main {

	public static void main(String[] args) {
		/*
		int NUM_VARIABLES = 0; 
		Scanner entrada = new Scanner( System.in );
		System.out.print( "Introduce el número de variables: " );
		NUM_VARIABLES = entrada.nextInt();
		List<Polinomio> polinomiosDelIdeal = new ArrayList<>();
		
		boolean terminaPolinomios = false;
		int k = 0;
		while( !terminaPolinomios ) { // Bucle para introducir los polinomios divisores
			int i = 0;
			String exponentes = "";
			boolean termina = false;
			Polinomio polinomio = new Polinomio();
			while( !termina ) { // Bucle para introducir los términos de cada polinomio.
				System.out.print( "Introduce la constante del término " + (i+1) + " del polinomio número " + (k+1) + " (pulse q o Q para terminar): " );
				int constante = 0;
				try {
					constante = entrada.nextInt();	
				}
				catch( InputMismatchException e ) {
					entrada.next();
					break;
				}
				System.out.print( "Introduce el término número " + (i+1) + " del polinomio número " + (k+1) + ": (pulse q o Q para terminar): ");
				exponentes = entrada.next();
				if( exponentes.equals( "q" ) || exponentes.equals( "Q" ) ) {
					termina = true;
				}
				else {
					String[] terminosString = exponentes.split( "," );
					int j = 0;
					int[] terminosInt = new int[ NUM_VARIABLES ];
					for( String termino: terminosString ) {
						int terminoInt = Integer.parseInt( termino );
						terminosInt[j] = terminoInt;
						j++;
					}
					Termino termino = new Termino( NUM_VARIABLES, constante, terminosInt );
					polinomio.addTermino( termino );
				}
				i++;
			}
			
			System.out.print( "¿Quieres seguir añadiendo polinomios? (S/N) " );
			String respuesta = entrada.next();
			if( respuesta.equals( "N" ) ) {
				terminaPolinomios = true;
			}
			polinomiosDelIdeal.add( polinomio );
			k++;
		}
		
		System.out.println( "-- POLINOMIOS --" );
		for( Polinomio p: polinomiosDelIdeal ) {
			System.out.println( "--> "+ p );
		}
		
		System.out.println("---------------------------------------------------");
		
		List<Polinomio> baseGrebner = AlgoritmoBaseGrebner.calculaBaseGrebner(polinomiosDelIdeal);
		List<Polinomio> BaseGrebnerMinimal = AlgoritmoBaseGrebner.calculaBaseGrebner(baseGrebner);
		for( Polinomio p: BaseGrebnerMinimal ) {
			System.out.println( "--> " + p );
		}
		
	}
	*/
		
		
		
		
		/*
		int NUM_VARIABLES = 0; 
		Scanner entrada = new Scanner( System.in );
		Polinomio polinomioDividendo = new Polinomio();
		
		System.out.print( "Introduce el número de variables: " );
		NUM_VARIABLES = entrada.nextInt();
		
		int i = 0;
		String exponentes = "";
		boolean termina = false;
		while( !termina ) {
			System.out.print( "Introduce la constante número " + (i+1) + " del polinomio dividendo (pulse q o Q para terminar): " );
			int constante = 0;
			try {
				constante = entrada.nextInt();	
			}
			catch( InputMismatchException e ) {
				entrada.next();
				break;
			}
			System.out.print( "Introduce los exponentes del término número " + (i+1) + " del polinomio dividendo separados por comas (pulse q o Q para terminar): ");
			exponentes = entrada.next();
			if( exponentes.equals( "q" ) || exponentes.equals( "Q" ) ) { 
				termina = true;
			}
			else { 
				String[] terminosString = exponentes.split( "," );
				int j = 0;
				int[] terminosInt = new int[ NUM_VARIABLES ];
				for( String termino: terminosString ) {
					int terminoInt = Integer.parseInt( termino );
					terminosInt[j] = terminoInt;
					j++;
				}
				Termino termino = new Termino( NUM_VARIABLES, constante, terminosInt );
				polinomioDividendo.addTermino( termino );
			}
			i++;
		}
		
		System.out.println( "Polinomio dividendo: " + polinomioDividendo );
		
		// Creamos una lista con los polinomios divisores
		List<Polinomio> polinomiosDivisores = new ArrayList<>();
		boolean terminaPolinomios = false;
		int k = 0;
		while( !terminaPolinomios ) { // Bucle para introducir los polinomios divisores
			i = 0;
			exponentes = "";
			termina = false;
			Polinomio polinomio = new Polinomio();
			while( !termina ) { // Bucle para introducir los términos de cada polinomio.
				System.out.print( "Introduce la constante del término " + (i+1) + " del polinomio divisor número" + (k+1) + " (pulse q o Q para terminar): " );
				int constante = 0;
				try {
					constante = entrada.nextInt();	
				}
				catch( InputMismatchException e ) {
					entrada.next();
					break;
				}
				System.out.print( "Introduce el término número " + (i+1) + " del polinomio divisor número : " + (k+1) + " (pulse q o Q para terminar): ");
				exponentes = entrada.next();
				if( exponentes.equals( "q" ) || exponentes.equals( "Q" ) ) {
					termina = true;
				}
				else {
					String[] terminosString = exponentes.split( "," );
					int j = 0;
					int[] terminosInt = new int[ NUM_VARIABLES ];
					for( String termino: terminosString ) {
						int terminoInt = Integer.parseInt( termino );
						terminosInt[j] = terminoInt;
						j++;
					}
					Termino termino = new Termino( NUM_VARIABLES, constante, terminosInt );
					polinomio.addTermino( termino );
				}
				i++;
			}
			
			System.out.print( "¿Quieres seguir añadiendo polinomios divisores? (S/N) " );
			String respuesta = entrada.next();
			if( respuesta.equals( "N" ) ) {
				terminaPolinomios = true;
			}
			polinomiosDivisores.add( polinomio );
			k++;
		}
		
		System.out.println( "-- POLINOMIOS DIVISORES --" );
		for( Polinomio p: polinomiosDivisores ) {
			System.out.println( "--> "+ p );
		}
		
		ResultadoDivision resultado = AlgoritmoDivisor.dividirPolinomios( polinomioDividendo, polinomiosDivisores );
		
		System.out.println( "#### RESULTADO ####" );
		System.out.println( "-- POLINOMIOS COCIENTES --" );
		for( Polinomio p: resultado.getResultado() ) {
			System.out.println( "--> " + p );
		}
		System.out.println( "-- RESTO --" );
		System.out.println( resultado.getResto() );
	}
*/
		
		
		int numVariables = 4;
		
		//Polinomio dividendo
		Termino t11 = new Termino( numVariables, 1/3., new int[]{ 0, 0, 1, 0 } );
		Termino t12 = new Termino( numVariables, 1, new int[]{ 0, 0, 0, 1 } );
					
		Polinomio polinomioDividendo = new Polinomio();
		polinomioDividendo.addTermino( t11 );
		polinomioDividendo.addTermino( t12 );
		
		//FIN Polinomio dividendo
		
		Termino t1 = new Termino( numVariables, 3.0, new int[]{ 1, 0, 0, 0 } );
		Termino t2 = new Termino( numVariables, -6.0, new int[]{ 0, 1, 0, 0 } );
		Termino t3 = new Termino( numVariables, -2.0, new int[]{ 0, 0, 1, 0 } );

		Polinomio p1 = new Polinomio();
		p1.addTermino( t1 );
		p1.addTermino( t2 );
		p1.addTermino( t3 );
		
		Termino q1 = new Termino( numVariables, 2.0, new int[]{ 1, 0, 0, 0 } );
		Termino q2 = new Termino( numVariables, -4.0, new int[]{ 0, 1, 0, 0 } );
		Termino q3 = new Termino( numVariables, 4.0, new int[]{ 0, 0, 0, 1 } );
		Polinomio p2 = new Polinomio();
		p2.addTermino( q1 );
		p2.addTermino( q2 );
		p2.addTermino( q3 );
		
		Termino r1 = new Termino( numVariables, 1.0, new int[]{ 1, 0, 0, 0 } );
		Termino r2 = new Termino( numVariables, -2.0, new int[]{ 0, 1, 0, 0 } );
		Termino r3 = new Termino( numVariables, -1.0, new int[]{ 0, 0, 1, 0 } );
		Termino r4 = new Termino( numVariables, -1.0, new int[]{ 0, 0, 0, 1 } );
		Polinomio p3 = new Polinomio();
		p3.addTermino( r1 );
		p3.addTermino( r2 );
		p3.addTermino( r3 );
		p3.addTermino( r4 );
		
		Termino j1 = new Termino( numVariables, -2/3., new int[]{ 0, 0, 1, 0 } );
		Termino j2 = new Termino( numVariables, -2.0, new int[]{ 0, 0, 0, 1 } );
		Polinomio p4 = new Polinomio();
		p4.addTermino( j1 );
		p4.addTermino( j2 );
		
		
		Termino k1 = new Termino( numVariables, 1/3., new int[]{ 0, 0, 1, 0 } );
		Termino k2 = new Termino( numVariables, 1., new int[]{ 0, 0, 0, 1 } );
		Polinomio p5 = new Polinomio();
		p5.addTermino( k1 );
		p5.addTermino( k2 );
		
		List<Polinomio> polinomiosDivisores = new ArrayList<>();
		polinomiosDivisores.add(p1);
		polinomiosDivisores.add(p2);
		polinomiosDivisores.add(p3);
		polinomiosDivisores.add(p4);
		polinomiosDivisores.add(p5);
		
		
		
		ResultadoDivision resultado = AlgoritmoDivisor.dividirPolinomios( polinomioDividendo, polinomiosDivisores );
		
		System.out.println( "#### RESULTADO ####" );
		System.out.println( "-- POLINOMIOS COCIENTES --" );
		for( Polinomio p: resultado.getResultado() ) {
			System.out.println( "--> " + p );
		}
		System.out.println( "-- RESTO --" );
		System.out.println( resultado.getResto() );
		
		
		
	}	

}
