package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import algoritmo.AlgoritmoDivisor;
import datos.Polinomio;
import datos.Termino;

public class RestaPolinomiosTest {
	
	@Test
	public void restaPolinomiosTest1() {
		int numVariables = 2;
		
		List<Termino> listaTerminosp1 = new ArrayList<>();
		Termino t1p1 = new Termino( numVariables, 1, new int[]{ 2, 1 } );
		Termino t2p1 = new Termino( numVariables, 1, new int[]{ 1, 2 } );
		Termino t3p1 = new Termino( numVariables, 1, new int[]{ 0, 2 } );
		listaTerminosp1.add( t1p1 );
		listaTerminosp1.add( t2p1 );
		listaTerminosp1.add( t3p1 );
		Polinomio p1 = new Polinomio( listaTerminosp1 );
		
		List<Termino> listaTerminosp2 = new ArrayList<>();
		Termino t1p2 = new Termino( numVariables, 1, new int[]{ 2, 1 } );
		Termino t2p2 = new Termino( numVariables, -1, new int[]{ 1, 0 } );
		listaTerminosp2.add( t1p2 );
		listaTerminosp2.add( t2p2 );
		Polinomio p2 = new Polinomio( listaTerminosp2 );
		
		List<Termino> listaTerminosEsperados = new ArrayList<>();
		Termino t1esp = new Termino( numVariables, 1, new int[]{ 1, 2 } );
		Termino t2esp = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		Termino t3esp = new Termino( numVariables, 1, new int[]{ 0, 2 } );
		listaTerminosEsperados.add( t1esp );
		listaTerminosEsperados.add( t2esp );
		listaTerminosEsperados.add( t3esp );
		Polinomio resultadoEsperado = new Polinomio( listaTerminosEsperados );
		
		Polinomio polinomioResultado = AlgoritmoDivisor.restaPolinomios( p1, p2 );
		
		assertEquals( resultadoEsperado, polinomioResultado );
	}
	
	@Test
	public void restaPolinomiosTest2() {
		int numVariables = 2;
		
		List<Termino> listaTerminosp1 = new ArrayList<>();
		Termino t1p1 = new Termino( numVariables, 1, new int[]{ 1, 2 } );
		Termino t2p1 = new Termino( numVariables, 1, new int[]{ 1, 0 } );
		Termino t3p1 = new Termino( numVariables, 1, new int[]{ 0, 2 } );
		listaTerminosp1.add( t1p1 );
		listaTerminosp1.add( t2p1 );
		listaTerminosp1.add( t3p1 );
		Polinomio p1 = new Polinomio( listaTerminosp1 );
		
		List<Termino> listaTerminosp2 = new ArrayList<>();
		Termino t1p2 = new Termino( numVariables, 1, new int[]{ 1, 2 } );
		Termino t2p2 = new Termino( numVariables, -1, new int[]{ 1, 0 } );
		listaTerminosp2.add( t1p2 );
		listaTerminosp2.add( t2p2 );
		Polinomio p2 = new Polinomio( listaTerminosp2 );
		
		List<Termino> listaTerminosEsperados = new ArrayList<>();
		Termino t1esp = new Termino( numVariables, 2, new int[]{ 1, 0 } );
		Termino t2esp = new Termino( numVariables, 1, new int[]{ 0, 2 } );
		listaTerminosEsperados.add( t1esp );
		listaTerminosEsperados.add( t2esp );
		Polinomio resultadoEsperado = new Polinomio( listaTerminosEsperados );
		
		Polinomio polinomioResultado = AlgoritmoDivisor.restaPolinomios( p1, p2 );
		
		assertEquals( resultadoEsperado, polinomioResultado );
	}

}
