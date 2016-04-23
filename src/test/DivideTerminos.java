package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import datos.Termino;

public class DivideTerminos {
	
	@Test
	public void divideTerminosTest1() {
		int numVariables = 3;
		Termino t1 = new Termino( numVariables, 2, new int[]{ 2, 3, 1 } );
		Termino t2 = new Termino( numVariables, 3, new int[]{ 1, 0, 0 } );
		
		Termino resultadoEsperado = new Termino( numVariables, 2, 3 , new int[]{ 1, 3, 1 } );
		
		Termino resultado = t1.divideTerminos( t2 );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
	@Test
	public void divideTerminosTest2() {
		int numVariables = 3;
		Termino t1 = new Termino( numVariables, 4, new int[]{ 1, 3, 1 } );
		Termino t2 = new Termino( numVariables, 3, new int[]{ 1, 0, 0 } );
		
		Termino resultadoEsperado = new Termino( numVariables, 4, 3 , new int[]{ 0, 3, 1 } );
		
		Termino resultado = t1.divideTerminos( t2 );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
	@Test
	public void divideTerminosTest3() {
		Termino t1 = new Termino( 3, 2, new int[]{ 0, 3, 1 } );
		Termino t2 = new Termino( 2, 3, new int[]{ 0, 1 } );
		
		Termino resultadoEsperado = new Termino( 3, 2, 3 , new int[]{ 0, 2, 1 } );
		
		Termino resultado = t1.divideTerminos( t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void divideTerminosTest4() {
		Termino t1 = new Termino( 5, 2, new int[]{ 1, 3, 1, 4, 5 } );
		Termino t2 = new Termino( 2, 3, new int[]{ 0, 3 } );
		
		Termino resultadoEsperado = new Termino( 5, 2, 3 , new int[]{ 1, 0, 1, 4, 5 } );
		
		Termino resultado = t1.divideTerminos( t2 );
		
		assertEquals( resultadoEsperado, resultado );
	}

}
