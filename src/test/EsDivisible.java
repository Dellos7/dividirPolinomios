package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algoritmo.AlgoritmoDivisor;
import datos.Termino;

public class EsDivisible {
	
	@Test
	public void esDivisibleTest1() {
		int numVariables = 3;
		Termino t1 = new Termino( numVariables, 2.0, new int[]{ 2, 3, 1 } );
		Termino t2 = new Termino( numVariables, 3.0, new int[]{ 1, 0, 0 } );
		
		boolean resultadoEsperado = true;
		
		boolean resultado = AlgoritmoDivisor.esDivisible( t1 , t2 );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
	@Test
	public void esDivisibleTest2() {
		int numVariables = 3;
		Termino t1 = new Termino( numVariables, 2.0, new int[]{ 1, 3, 1 } );
		Termino t2 = new Termino( numVariables, 3.0, new int[]{ 2, 0, 0 } );
		
		boolean resultadoEsperado = false;
		
		boolean resultado = AlgoritmoDivisor.esDivisible( t1 , t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void esDivisibleTest3() {
		int numVariables = 3;
		Termino t1 = new Termino( numVariables, 2.0, new int[]{ 0, 3, 1 } );
		Termino t2 = new Termino( numVariables, 3.0, new int[]{ 2, 0, 0 } );
		
		boolean resultadoEsperado = false;
		
		boolean resultado = AlgoritmoDivisor.esDivisible( t1 , t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void esDivisibleTest4() {
		int numVariables = 3;
		Termino t1 = new Termino( numVariables, 2.0, new int[]{ 1, 3, 1 } );
		Termino t2 = new Termino( numVariables, 3.0, new int[]{ 1, 0, 0 } );
		
		boolean resultadoEsperado = true;
		
		boolean resultado = AlgoritmoDivisor.esDivisible( t1 , t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void esDivisibleTest5() {
		Termino t1 = new Termino( 3, 2.0, new int[]{ 0, 3, 1 } );
		Termino t2 = new Termino( 2, 3.0, new int[]{ 2, 0 } );
		
		boolean resultadoEsperado = false;
		
		boolean resultado = AlgoritmoDivisor.esDivisible( t1 , t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void esDivisibleTest6() {
		Termino t1 = new Termino( 2, 2.0, new int[]{ 2, 3 } );
		Termino t2 = new Termino( 3, 3.0, new int[]{ 2, 1, 1 } );
		
		boolean resultadoEsperado = false;
		
		boolean resultado = AlgoritmoDivisor.esDivisible( t1 , t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void esDivisibleTest7() {
		Termino t1 = new Termino( 3, 2.0, new int[]{ 0, 3, 1 } );
		Termino t2 = new Termino( 2, 3.0, new int[]{ 0, 1 } );
		
		boolean resultadoEsperado = true;
		
		boolean resultado = AlgoritmoDivisor.esDivisible( t1 , t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	

}
