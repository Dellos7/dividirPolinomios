package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DivideTerminos.class, DividirPolinomios.class, EsDivisible.class, MultiplicaTerminoPolinomioTest.class,
		OrdenarPolinomiosTest.class, RestaPolinomiosTest.class })
public class AllTests {

}
