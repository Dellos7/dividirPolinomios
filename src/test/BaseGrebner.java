package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import algoritmo.AlgoritmoBaseGrebner;
import datos.Polinomio;
import datos.Termino;

public class BaseGrebner {
	
	@Test
	public void BaseGrebner1() {
		int numVariables = 2;
		Termino t1 = new Termino( numVariables, 1.0, new int[]{ 3, 0 } );
		Termino t2 = new Termino( numVariables, -2.0, new int[]{ 1, 1 } );
		Polinomio p1 = new Polinomio();
		p1.addTermino( t1 );
		p1.addTermino( t2 );
		
		Termino q1 = new Termino( numVariables, 1.0, new int[]{ 2, 1 } );
		Termino q2 = new Termino( numVariables, -2.0, new int[]{ 0, 2 } );
		Termino q3 = new Termino( numVariables, 1.0, new int[]{ 1, 0 } );
		Polinomio p2 = new Polinomio();
		p2.addTermino( q1 );
		p2.addTermino( q2 );
		p2.addTermino( q3 );

		
		//Resultado
		Termino f11 = new Termino( numVariables, 1.0, new int[]{ 3, 0 } );
		Termino f12 = new Termino( numVariables, -2.0, new int[]{ 1, 1 } );
		Polinomio pol1 = new Polinomio();
		pol1.addTermino( f11 );
		pol1.addTermino( f12 );
		
		Termino f21 = new Termino( numVariables, 1.0, new int[]{ 2, 1 } );
		Termino f22 = new Termino( numVariables, -2.0, new int[]{ 0, 2 } );
		Termino f23 = new Termino( numVariables, 1.0, new int[]{ 1, 0 } );
		Polinomio pol2 = new Polinomio();
		pol2.addTermino( f21 );
		pol2.addTermino( f22 );
		pol2.addTermino( f23 );
		
		Termino f31 = new Termino( numVariables, -1.0, new int[]{ 2, 0 } );
		Polinomio pol3 = new Polinomio();
		pol3.addTermino( f31 );
		
		Termino f41 = new Termino( numVariables, -2.0, new int[]{ 1, 1 } );
		Polinomio pol4 = new Polinomio();
		pol4.addTermino( f41 );
		
		Termino f51 = new Termino( numVariables, -2.0, new int[]{ 0, 2 } );
		Termino f52 = new Termino( numVariables, 1.0, new int[]{ 1, 0 } );
		Polinomio pol5 = new Polinomio();
		pol5.addTermino( f51 );
		pol5.addTermino(f52);
		
		List<Polinomio> r = new ArrayList<>();
		r.add( pol1 );
		r.add( pol2 );
		r.add( pol3 );
		r.add( pol4 );
		r.add( pol5 );
		
		List<Polinomio> resultadoEsperado = r;
		
		List<Polinomio> ideal = new ArrayList<>();
		ideal.add(p1);
		ideal.add(p2);
		List<Polinomio> resultado = AlgoritmoBaseGrebner.calculaBaseGrebner( ideal );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
	@Test
	public void BaseMinimal1() {
		int numVariables = 2;
		
		Termino f11 = new Termino( numVariables, 1.0, new int[]{ 3, 0 } );
		Termino f12 = new Termino( numVariables, -2.0, new int[]{ 1, 1 } );
		Polinomio pol1 = new Polinomio();
		pol1.addTermino( f11 );
		pol1.addTermino( f12 );
		
		Termino f21 = new Termino( numVariables, 1.0, new int[]{ 2, 1 } );
		Termino f22 = new Termino( numVariables, -2.0, new int[]{ 0, 2 } );
		Termino f23 = new Termino( numVariables, 1.0, new int[]{ 1, 0 } );
		Polinomio pol2 = new Polinomio();
		pol2.addTermino( f21 );
		pol2.addTermino( f22 );
		pol2.addTermino( f23 );
		
		Termino f31 = new Termino( numVariables, -1.0, new int[]{ 2, 0 } );
		Polinomio pol3 = new Polinomio();
		pol3.addTermino( f31 );
		
		Termino f41 = new Termino( numVariables, -2.0, new int[]{ 1, 1 } );
		Polinomio pol4 = new Polinomio();
		pol4.addTermino( f41 );
		
		Termino f51 = new Termino( numVariables, -2.0, new int[]{ 0, 2 } );
		Termino f52 = new Termino( numVariables, 1.0, new int[]{ 1, 0 } );
		Polinomio pol5 = new Polinomio();
		pol5.addTermino( f51 );
		pol5.addTermino(f52);
		
		List<Polinomio> base = new ArrayList<>();
		base.add( pol1 );
		base.add( pol2 );
		base.add( pol3 );
		base.add( pol4 );
		base.add( pol5 );
		
		//Esperado
		Termino g11 = new Termino( numVariables, 1.0, new int[]{ 2, 0 } );
		Polinomio p3 = new Polinomio();
		p3.addTermino( g11 );
		
		Termino g21 = new Termino( numVariables, 1.0, new int[]{ 1, 1 } );
		Polinomio p4 = new Polinomio();
		p4.addTermino( g21 );
		
		Termino g31 = new Termino( numVariables, 1.0, new int[]{ 0, 2 } );
		Termino g32 = new Termino( numVariables, -0.5, new int[]{ 1, 0 } );
		Polinomio p5 = new Polinomio();
		p5.addTermino( g31 );
		p5.addTermino( g32 );
		
		List<Polinomio> baseEsperada = new ArrayList<>();
		baseEsperada.add( p3 );
		baseEsperada.add( p4 );
		baseEsperada.add( p5 );
		
		
		List<Polinomio> resultadoEsperado = baseEsperada;
		
		List<Polinomio> resultado = AlgoritmoBaseGrebner.obtenBaseDeGrebnerMinimal( base );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
	
	@Test
	public void BaseReducida1() {
		int numVariables = 2;
		
		Termino g11 = new Termino( numVariables, 1.0, new int[]{ 2, 0 } );
		Polinomio p3 = new Polinomio();
		p3.addTermino( g11 );
		
		Termino g21 = new Termino( numVariables, 1.0, new int[]{ 1, 1 } );
		Polinomio p4 = new Polinomio();
		p4.addTermino( g21 );
		
		Termino g31 = new Termino( numVariables, 1.0, new int[]{ 0, 2 } );
		Termino g32 = new Termino( numVariables, -0.5, new int[]{ 1, 0 } );
		Polinomio p5 = new Polinomio();
		p5.addTermino( g31 );
		p5.addTermino( g32 );
		
		List<Polinomio> baseMinimal = new ArrayList<>();
		baseMinimal.add( p3 );
		baseMinimal.add( p4 );
		baseMinimal.add( p5 );
		
		//Esperado
		Termino h11 = new Termino( numVariables, 1.0, new int[]{ 2, 0 } );
		Polinomio h3 = new Polinomio();
		h3.addTermino( h11 );
		
		Termino h21 = new Termino( numVariables, 1.0, new int[]{ 1, 1 } );
		Polinomio h4 = new Polinomio();
		h4.addTermino( h21 );
		
		Termino h31 = new Termino( numVariables, 1.0, new int[]{ 0, 2 } );
		Termino h32 = new Termino( numVariables, -0.5, new int[]{ 1, 0 } );
		Polinomio h5 = new Polinomio();
		h5.addTermino( h31 );
		h5.addTermino( h32 );
		
		List<Polinomio> baseEsperada = new ArrayList<>();
		baseEsperada.add( h3 );
		baseEsperada.add( h4 );
		baseEsperada.add( h5 );
		
		
		List<Polinomio> resultadoEsperado = baseEsperada;
		
		List<Polinomio> resultado = AlgoritmoBaseGrebner.obtenBaseDeGrebnerReducida( baseMinimal );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
}
