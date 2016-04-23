package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import algoritmo.AlgoritmoDivisor;
import datos.Polinomio;
import datos.Termino;

public class MultiplicaTerminoPolinomioTest {
	
	@Test
	public void multiplicaTerminoPolinomioTest1() {
		int numVariables = 3;
		Termino termino = new Termino( numVariables, 3, new int[]{ 2, 3, 1 } );
		
		Termino t1 = new Termino( numVariables, 1, new int[]{ 1, 2, 0 } );
		Termino t2 = new Termino( numVariables, 2, new int[]{ 3, 0, 1 } );
		List<Termino> listaTerminos = new ArrayList<>();
		listaTerminos.add( t1 );
		listaTerminos.add( t2 );
		Polinomio polinomio = new Polinomio( listaTerminos );
		
		List<Termino> listaTerminosEsperados = new ArrayList<>();
		Termino t1Esperado = new Termino( numVariables, 3, new int[]{ 3, 5, 1 } );
		Termino t2Esperado = new Termino( numVariables, 6, new int[]{ 5, 3, 2 } );
		listaTerminosEsperados.add( t1Esperado );
		listaTerminosEsperados.add( t2Esperado );
		Polinomio resultadoEsperado = new Polinomio( listaTerminosEsperados );
		
		Polinomio resultado = AlgoritmoDivisor.multiplicacionTerminoPolinomio( termino , polinomio );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void multiplicaTerminoPolinomioTest2() {
		int numVariables = 3;
		Termino termino = new Termino( numVariables, 5, new int[]{ 0, 2, 1 } );
		
		Termino t1 = new Termino( numVariables, 6, new int[]{ 2, 3, 0 } );
		Termino t2 = new Termino( numVariables, 10, new int[]{ 0, 0, 0 } );
		List<Termino> listaTerminos = new ArrayList<>();
		listaTerminos.add( t1 );
		listaTerminos.add( t2 );
		Polinomio polinomio = new Polinomio( listaTerminos );
		
		List<Termino> listaTerminosEsperados = new ArrayList<>();
		Termino t1Esperado = new Termino( numVariables, 30, new int[]{ 2, 5, 1 } );
		Termino t2Esperado = new Termino( numVariables, 50, new int[]{ 0, 2, 1 } );
		listaTerminosEsperados.add( t1Esperado );
		listaTerminosEsperados.add( t2Esperado );
		Polinomio resultadoEsperado = new Polinomio( listaTerminosEsperados );
		
		Polinomio resultado = AlgoritmoDivisor.multiplicacionTerminoPolinomio( termino , polinomio );
		
		assertEquals( resultadoEsperado, resultado );
	}
	
	@Test
	public void multiplicaTerminoPolinomioTest3() {
		int numVariables = 3;
		Termino termino = new Termino( numVariables, 3, 4, new int[]{ 0, 0, 0 } );
		
		Termino t1 = new Termino( numVariables, 2, 3, new int[]{ 6, 0, 2 } );
		Termino t2 = new Termino( numVariables, 4, 6, new int[]{ 0, 3, 0 } );
		List<Termino> listaTerminos = new ArrayList<>();
		listaTerminos.add( t1 );
		listaTerminos.add( t2 );
		Polinomio polinomio = new Polinomio( listaTerminos );
		
		List<Termino> listaTerminosEsperados = new ArrayList<>();
		Termino t1Esperado = new Termino( numVariables, 1, 2, new int[]{ 6, 0, 2 } );
		Termino t2Esperado = new Termino( numVariables, 1, 2, new int[]{ 0, 3, 0 } );
		listaTerminosEsperados.add( t1Esperado );
		listaTerminosEsperados.add( t2Esperado );
		Polinomio resultadoEsperado = new Polinomio( listaTerminosEsperados );
		
		Polinomio resultado = AlgoritmoDivisor.multiplicacionTerminoPolinomio( termino , polinomio );
		
		assertEquals( resultadoEsperado, resultado );
	}

}
