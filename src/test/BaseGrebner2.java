package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import algoritmo.AlgoritmoBaseGrebner;
import datos.Polinomio;
import datos.Termino;

public class BaseGrebner2 {
	
	@Test
	public void BaseGrebner1() {
		int numVariables = 4;
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

		
		//Resultado
		Termino f11 = new Termino( numVariables, 1.0, new int[]{ 1, 0, 0, 0 } );
		Termino f12 = new Termino( numVariables, -2.0, new int[]{ 0, 1, 0, 0 } );
		Termino f13 = new Termino( numVariables, -1.0, new int[]{ 0, 0, 1, 0 } );
		Termino f14 = new Termino( numVariables, -1.0, new int[]{ 0, 0, 0, 1 });
		Polinomio pol1 = new Polinomio();
		pol1.addTermino( f11 );
		pol1.addTermino( f12 );
		pol1.addTermino( f13 );
		pol1.addTermino( f14 );
		
		Termino f21 = new Termino( numVariables, 1.0, new int[]{ 0, 0, 1, 0 } );
		Termino f22 = new Termino( numVariables, 3.0, new int[]{ 0, 0, 0, 1 } );
		Polinomio pol2 = new Polinomio();
		pol2.addTermino( f21 );
		pol2.addTermino( f22 );
		
		
		List<Polinomio> r = new ArrayList<>();
		r.add( pol1 );
		r.add( pol2 );
		
		List<Polinomio> resultadoEsperado = r;
		
		List<Polinomio> ideal = new ArrayList<>();
		ideal.add(p1);
		ideal.add(p2);
		ideal.add(p3);
		List<Polinomio> grebner = AlgoritmoBaseGrebner.calculaBaseGrebner( ideal );
		List<Polinomio> resultado = AlgoritmoBaseGrebner.obtenBaseDeGrebnerMinimal( grebner );
		
		assertEquals( resultadoEsperado, resultado );	
	}
	
}
