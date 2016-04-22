package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import algoritmo.AlgoritmoDivisor;
import datos.Polinomio;
import datos.ResultadoDivision;
import datos.Termino;

public class DividirPolinomios {

	@Test
	public void testDividirPolinomio1() {
		
		int numVariables = 2;
		
		//Polinomio dividendo
		Termino t11 = new Termino( numVariables, 1, new int[]{ 2, 1 } );
		Termino t12 = new Termino( numVariables, 1, new int[]{ 1, 2 } );
		Termino t13 = new Termino( numVariables, 1, new int[]{ 0, 2 } );
		System.out.println( t11 );
				
		Polinomio polinomioDividendo = new Polinomio();
		polinomioDividendo.addTermino( t11 );
		polinomioDividendo.addTermino( t12 );
		polinomioDividendo.addTermino( t13 );
		System.out.println( polinomioDividendo );
		
		//FIN Polinomio dividendo
		
		//Polinomio divisor 1
		Termino t21 = new Termino( numVariables, 1, new int[]{ 0, 2 } );
		Termino t22 = new Termino( numVariables, -1, new int[]{ 0, 0 } );
		
		Polinomio p1 = new Polinomio();
		p1.addTermino( t21 );
		p1.addTermino( t22 );
		
		//FIN Polinomio divisor 1
		
		//Polinomio divisor 2
		Termino t31 = new Termino( numVariables, 1, new int[]{ 1, 1 } );
		Termino t32 = new Termino( numVariables, -1, new int[]{ 0, 0 } );
		
		Polinomio p2 = new Polinomio();
		p2.addTermino( t31 );
		p2.addTermino( t32 );
		
		//FIN Polinomio divisor 2
		
		//Lista de polinomios divisores
		List<Polinomio> polinomiosDivisores = new ArrayList<>();
		polinomiosDivisores.add( p1 );
		polinomiosDivisores.add( p2 );
		
		//Resultado esperado
		
		Termino t1res1 = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		Termino t2res1 = new Termino( numVariables, 1, new int[]{ 0, 0 } );
		
		Polinomio res1 = new Polinomio();
		res1.addTermino( t1res1 );
		res1.addTermino( t2res1 );
		
		Termino t1res2 = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		
		Polinomio res2 = new Polinomio();
		res2.addTermino( t1res2 );
		
		Termino t1resto = new Termino( numVariables, 2, new int[]{ 1, 0 } );
		Termino t2resto = new Termino( numVariables, 1, new int[]{ 0, 0 } );
		
		//Lista de polinomios resultado esperados
		Polinomio[] polinomiosResultadoEsperados = new Polinomio[2];
		polinomiosResultadoEsperados[0] = res1 ;
		polinomiosResultadoEsperados[1] = res2 ;
		
		//Polinomio resto esperado
		Polinomio restoEsperado = new Polinomio();
		restoEsperado.addTermino( t1resto );
		restoEsperado.addTermino( t2resto );
		
		//FIN Resultado esperado
		
		//Hacemos la división
		ResultadoDivision resultado = AlgoritmoDivisor.dividirPolinomios( polinomioDividendo , polinomiosDivisores );
		System.out.println(resultado.getResto());
		System.out.println( Arrays.toString(resultado.getResultado() ));
		//Comprobamos que el resultado de la división sea el esperado
		assertArrayEquals( polinomiosResultadoEsperados, resultado.getResultado() );
		//Comprobamos que el resto de la división sea el esperado
		assertEquals( restoEsperado, resultado.getResto() );
	}
	
	@Test
	public void testDividirPolinomio2() {
		
		int numVariables = 2;
		
		//Polinomio dividendo
		Termino t11 = new Termino( numVariables, 1, new int[]{ 2, 1 } );
		Termino t12 = new Termino( numVariables, 1, new int[]{ 1, 2 } );
		Termino t13 = new Termino( numVariables, 1, new int[]{ 0, 2 } );
				
		Polinomio polinomioDividendo = new Polinomio();
		polinomioDividendo.addTermino( t11 );
		polinomioDividendo.addTermino( t12 );
		polinomioDividendo.addTermino( t13 );
		
		//FIN Polinomio dividendo
		
		//Polinomio divisor 1
		Termino t21 = new Termino( numVariables, 1, new int[]{ 1, 1 } );
		Termino t22 = new Termino( numVariables, -1, new int[]{ 0, 0 } );
		
		Polinomio p1 = new Polinomio();
		p1.addTermino( t21 );
		p1.addTermino( t22 );
		
		//FIN Polinomio divisor 1
		
		//Polinomio divisor 2
		Termino t31 = new Termino( numVariables, 1, new int[]{ 0, 2 } );
		Termino t32 =  new Termino( numVariables, -1, new int[]{ 0, 0 } );
		
		Polinomio p2 = new Polinomio();
		p2.addTermino( t31 );
		p2.addTermino( t32 );
		
		//FIN Polinomio divisor 2
		
		//Lista de polinomios divisores
		List<Polinomio> polinomiosDivisores = new ArrayList<>();
		polinomiosDivisores.add( p1 );
		polinomiosDivisores.add( p2 );
		
		//Resultado esperado
		
		Termino t1res1 = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		Termino t2res1 = new Termino( numVariables, 1, new int[]{ 0, 1 } );
		
		Polinomio res1 = new Polinomio();
		res1.addTermino( t1res1 );
		res1.addTermino( t2res1 );
		
		Termino t1res2 = new Termino( numVariables, 1, new int[]{ 0, 0 } );
		
		Polinomio res2 = new Polinomio();
		res2.addTermino( t1res2 );
		
		Termino t1resto = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		Termino t2resto = new Termino( numVariables, 1, new int[]{ 0, 1 } );
		Termino t3resto = new Termino( numVariables, 1, new int[]{ 0, 0 } );
		
		//Lista de polinomios resultado esperados
		Polinomio[] polinomiosResultadoEsperados = new Polinomio[2];
		polinomiosResultadoEsperados[0] = res1 ;
		polinomiosResultadoEsperados[1] = res2 ;
		
		//Polinomio resto esperado
		Polinomio restoEsperado = new Polinomio();
		restoEsperado.addTermino( t1resto );
		restoEsperado.addTermino( t2resto );
		restoEsperado.addTermino( t3resto );
		
		//FIN Resultado esperado
		
		//Hacemos la división
		ResultadoDivision resultado = AlgoritmoDivisor.dividirPolinomios( polinomioDividendo , polinomiosDivisores );
		
		//Comprobamos que el resultado de la división sea el esperado
		//assertEquals( polinomiosResultadoEsperados, resultado.getResultado() );
		assertArrayEquals( polinomiosResultadoEsperados , resultado.getResultado());
		//Comprobamos que el resto de la división sea el esperado
		assertEquals( restoEsperado, resultado.getResto() );
	}
	
	
	
	@Test
	public void testDividirPolinomio() {
		
		
		int numVariables = 4;
		
		//Polinomio dividendo
		Termino t11 = new Termino( numVariables, 1.0, 3.0, new int[]{ 0, 0, 1, 0 } );
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
		
		Termino j1 = new Termino( numVariables, -2.0, 3.0, new int[]{ 0, 0, 1, 0 } );
		Termino j2 = new Termino( numVariables, -2.0, new int[]{ 0, 0, 0, 1 } );
		Polinomio p4 = new Polinomio();
		p4.addTermino( j1 );
		p4.addTermino( j2 );
		
		
		Termino k1 = new Termino( numVariables, 1.0, 3.0, new int[]{ 0, 0, 1, 0 } );
		Termino k2 = new Termino( numVariables, 1.0, new int[]{ 0, 0, 0, 1 } );
		Polinomio p5 = new Polinomio();
		p5.addTermino( k1 );
		p5.addTermino( k2 );
		
		List<Polinomio> polinomiosDivisores = new ArrayList<>();
		polinomiosDivisores.add(p1);
		polinomiosDivisores.add(p2);
		polinomiosDivisores.add(p3);
		polinomiosDivisores.add(p4);
		polinomiosDivisores.add(p5);
		
			
		//Resultado esperado
		
		Termino t1res1 = new Termino( numVariables, -0.5, new int[]{ 0,0,0, 0 } );
		Polinomio res1 = new Polinomio();
		res1.addTermino( t1res1 );
		
		
		Termino t1res2 = new Termino( numVariables, 0, new int[]{ 0,0,0, 0 } );
		
		Polinomio res2 = new Polinomio();
		res2.addTermino( t1res2 );
		
		//Lista de polinomios resultado esperados
		Polinomio [] polinomiosResultadoEsperados = new Polinomio[polinomiosDivisores.size()];
		polinomiosResultadoEsperados[3] = res1;
		
		//FIN Resultado esperado
		//ResultadoDivision resultadoEsperado = new ResultadoDivision(polinomiosResultadoEsperados, res2);
		//Hacemos la división
		ResultadoDivision resultado = AlgoritmoDivisor.dividirPolinomios( polinomioDividendo , polinomiosDivisores );
		System.out.println( "spol:" + polinomioDividendo );
		System.out.println( "divisores:" +  polinomiosDivisores );
		System.out.println( "resto: " + resultado.getResto() );
		System.out.println( "resultado: " + Arrays.toString( resultado.getResultado() ) );
		
		//Comprobamos que el resultado de la división sea el esperado
		assertArrayEquals( polinomiosResultadoEsperados, resultado.getResultado() );
		//Comprobamos que el resto de la división sea el esperado
		assertEquals( res2, resultado.getResto() );
	}
	
}
