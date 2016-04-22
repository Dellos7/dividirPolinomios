package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datos.Polinomio;
import datos.Termino;

public class OrdenarPolinomiosTest {

	@Test
	public void ordenarPolinomio1() {
		Termino t1 = new Termino(2, 4, new int[]{2,1} );
		Termino t2 = new Termino(2, 3, new int[]{1,2} );
		Termino t3 = new Termino(2, -1, new int[]{0,2} );
		
		Polinomio p1 = new Polinomio();
		p1.addTermino( t3 );
		p1.addTermino( t2 );
		p1.addTermino( t1 );
		
		assertEquals( p1.getTerminos().get(0), t1 );
		assertEquals( p1.getTerminos().get(1), t2 );
		assertEquals( p1.getTerminos().get(2), t3 );
	}
	
	@Test
	public void ordenarPolinomio2() {
		Termino t1 = new Termino(3, 4, new int[]{3,0,1} );
		Termino t2 = new Termino(3, 3, new int[]{2,2,3} );
		Termino t3 = new Termino(3, -1, new int[]{2,2,2} );
		Termino t4 = new Termino(3, -1, new int[]{2,1,4} );
		Termino t5 = new Termino(3, -1, new int[]{1,5,0} );
		Termino t6 = new Termino(3, -1, new int[]{0,6,0} );
		Termino t7 = new Termino(3, -1, new int[]{0,5,7} );
		
		Polinomio p1 = new Polinomio();
		p1.addTermino( t7 );
		p1.addTermino( t2 );
		p1.addTermino( t4 );
		p1.addTermino( t1 );
		p1.addTermino( t3 );
		p1.addTermino( t6 );
		p1.addTermino( t5 );
		
		assertEquals( p1.getTerminos().get(0), t1 );
		assertEquals( p1.getTerminos().get(1), t2 );
		assertEquals( p1.getTerminos().get(2), t3 );
		assertEquals( p1.getTerminos().get(3), t4 );
		assertEquals( p1.getTerminos().get(4), t5 );
		assertEquals( p1.getTerminos().get(5), t6 );
		assertEquals( p1.getTerminos().get(6), t7 );
	}
	
}
