package test;

import static org.junit.Assert.assertEquals;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;

import algoritmo.AlgoritmoBaseGrebner;
import datos.Polinomio;
import datos.Termino;

public class Spol {
	
	@Test
	public void SpolTest1() {
		int numVariables = 2;
		Termino t1 = new Termino( numVariables, 1, new int[]{ 3, 0 } );
		Termino t2 = new Termino( numVariables, -2, new int[]{ 1, 1 } );
		Polinomio p1 = new Polinomio();
		p1.addTermino( t1 );
		p1.addTermino( t2 );
		
		Termino q1 = new Termino( numVariables, 1, new int[]{ 2, 1 } );
		Termino q2 = new Termino( numVariables, -2, new int[]{ 0, 2 } );
		Termino q3 = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		Polinomio p2 = new Polinomio();
		p2.addTermino( q1 );
		p2.addTermino( q2 );
		p2.addTermino( q3 );

		
		Polinomio r = new Polinomio();
		int[] e = new int[]{2,0};
		r.addTermino( new Termino( 2, -1, e) );
		
		Polinomio resultadoEsperado = r;
		
		Polinomio resultado = AlgoritmoBaseGrebner.calculaSpolinomio( p1, p2 );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
	@Test
	public void SpolTest2() {
		int numVariables = 2;
		Termino t1 = new Termino( numVariables, 1, new int[]{ 3, 0 } );
		Termino t2 = new Termino( numVariables, -2, new int[]{ 1, 1 } );
		Polinomio p1 = new Polinomio();
		p1.addTermino( t1 );
		p1.addTermino( t2 );
		
		Termino q1 = new Termino( numVariables, -1, new int[]{ 2, 0 } );
		Polinomio p2 = new Polinomio();
		p2.addTermino( q1 );
		
		Polinomio r = new Polinomio();
		int[] e = new int[]{1,1};
		r.addTermino( new Termino( 2, -2, e) );
		
		Polinomio resultadoEsperado = r;
		
		Polinomio resultado = AlgoritmoBaseGrebner.calculaSpolinomio( p1, p2 );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
	@Test
	public void SpolTest3() {
		
		int numVariables = 2;
		
		
		Termino t1 = new Termino( numVariables, 1, new int[]{ 2, 1 } );
		Termino t2 = new Termino( numVariables, -2, new int[]{ 0, 2 } );
		Termino t3 = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		Polinomio p1 = new Polinomio();
		p1.addTermino( t1 );
		p1.addTermino( t2 );
		p1.addTermino( t3 );
		
		
		Termino q1 = new Termino( numVariables, -2, new int[]{ 1, 1 } );
		Polinomio p2 = new Polinomio();
		p2.addTermino( q1 );
		
		Polinomio r = new Polinomio();
		int[] e1 = new int[]{0,2};
		r.addTermino( new Termino( 2, -2, e1) );
		int[] e2 = new int[]{1,0};
		r.addTermino( new Termino( 2, 1, e2) );
		
		Polinomio resultadoEsperado = r;
		
		Polinomio resultado = AlgoritmoBaseGrebner.calculaSpolinomio( p1, p2 );
		
		assertEquals( resultadoEsperado, resultado );	
	}
}
