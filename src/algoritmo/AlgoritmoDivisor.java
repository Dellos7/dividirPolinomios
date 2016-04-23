package algoritmo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datos.Configuracion;
import datos.Polinomio;
import datos.ResultadoDivision;
import datos.Termino;
import fraction.BigFraction;

public class AlgoritmoDivisor {

	public static ResultadoDivision dividirPolinomios( Polinomio polinomioDividendo, List<Polinomio> polinomiosDivisores ) {
		Polinomio p = polinomioDividendo.copia();
		int s = polinomiosDivisores.size();
		Polinomio[] polinomiosCociente = new Polinomio[ polinomiosDivisores.size() ];
		Polinomio resto = new Polinomio();
		
		while( !p.polinomioCero() ) {
			int i = 0;
			boolean divisionOcurred = false;
			
			while( i < s && !divisionOcurred ) {
				if( esDivisible( p.LT(), polinomiosDivisores.get(i).LT() ) ){
					
					if( polinomiosCociente[i] == null) {
						polinomiosCociente[i] = new Polinomio();
					}
					Termino division = p.LT().divideTerminos( polinomiosDivisores.get(i).LT() );
					polinomiosCociente[i].addTermino( division );
					
					Polinomio divisionMultiplicaPolinomioDivisor = multiplicacionTerminoPolinomio( division, polinomiosDivisores.get(i));
					
					p = restaPolinomios( p ,  divisionMultiplicaPolinomioDivisor );
					
					if( p.polinomioCero() ){
						Termino r = new Termino( polinomiosDivisores.get(i).LT().getNumVariables(), 0, new int[]{ 0, 0, 0, 0 });
						resto.addTermino(r);
					}
					
					divisionOcurred = true;
					
				}
				else {
					i++;
				}
			}
			if( !divisionOcurred ) {
				resto.addTermino( p.LT() );
				/*Polinomio polinomioTerminoLiderP = new Polinomio();
				polinomioTerminoLiderP.addTermino( p.LT() );
				p = restaPolinomios( p , polinomioTerminoLiderP );*/
				p.getTerminos().remove( p.LT() ); 
			}
		}
		
		//Generamos un objeto de la clase ResultadoDivision que almacene una lista con los polinomios
		// cociente y el resto de la division para poder devolverlo.
		/*List<Polinomio> polinomiosCocientesList = new ArrayList<>();
		for( Polinomio pp: polinomiosCociente ) {
			polinomiosCocientesList.add( pp );
		}
		
		List<Termino> terminosResto = resto.getTerminos();
		resto = new Polinomio( sumarTerminosIguales( terminosResto ) );
		*/
		ResultadoDivision resultadoDivision = new ResultadoDivision( polinomiosCociente , resto );
		
		
		return resultadoDivision;
	}
	
	// Comprueba si el primer término es divisible por el segundo
	public static boolean esDivisible( Termino t1, Termino t2 ) {
		if( t1.getVectorExponentes().length < t2.getVectorExponentes().length ) { // El segundo tiene variables que no tiene el primero
			return false;
		}
		for( int i = 0; i < t2.getVectorExponentes().length; i++ ){ // El segundo tiene algún exponente con un número mayor que el primero
			if( t1.getVectorExponentes()[i] - t2.getVectorExponentes()[i] < 0){
				return false;
			}
		}
		return true;
	}
	
	
	
	public static Polinomio multiplicacionTerminoPolinomio( Termino t, Polinomio p ){
		List<Termino> listaTerminosDelPolinomioResultante = new ArrayList<>();
		for( int i = 0; i < p.getTerminos().size(); i++ ) {
			Termino terminoPolinomio = p.getTerminos().get(i);
			//BigDecimal nuevaConstante = t.getConstante().multiply( terminoPolinomio.getConstante(), new MathContext( Configuracion.NUM_DECIMALES , RoundingMode.DOWN ) );
			BigFraction nuevaConstante = BigFraction.product( t.getConstante() , terminoPolinomio.getConstante() );
			int[] sumaExponentes = new int[ terminoPolinomio.getNumVariables() ];
			for( int j = 0; j < terminoPolinomio.getNumVariables(); j++ ){
				sumaExponentes[j] = terminoPolinomio.getVectorExponentes()[j] + t.getVectorExponentes()[j]; 
			}
			Termino nuevoTermino = new Termino( t.getNumVariables(), nuevaConstante, sumaExponentes );
			listaTerminosDelPolinomioResultante.add( nuevoTermino );
		}
		Polinomio polinomioResultante = new Polinomio( listaTerminosDelPolinomioResultante );
		return polinomioResultante;
	}
	
	public static Polinomio restaPolinomios( Polinomio p1, Polinomio p2 ) {
		List<Termino> listaTerminosDelPolinomioResultante = new ArrayList<>();
		//Utilizamos un mapa para saber que términos hemos añadido ya
		//Como recorremos el polinomio que se va a restar para cada término
		//del polinomio de arriba, no tenemos que añadir varias veces el mismo término
		Map<Integer, Boolean> mapaTerminosAnyadidos = new HashMap<>();
		for( int i = 0; i < p1.getTerminos().size(); i++ ) {
			Termino tp1 = p1.getTerminos().get(i);
			//Esta variable sirve para comprobar que un término del polinomio de arriba
			//no se haya añadido para no volverlo a añadir al polinomio resultante
			boolean terminoAnyadido = false;
			for( int j = 0; j < p2.getTerminos().size(); j++ ){
				Termino tp2 = p2.getTerminos().get(j);
				//Si los monomios son iguales se puede hacer la resta de constantes
				//y se añadirá al polinomio resultante la resta o no se añadirá si se anulan
				//if( tp1.equals( tp2 ) ) {
				if( tp1.equalsSinConstantes( tp2 ) ) {
					//BigDecimal constante = tp1.getConstante().subtract( tp2.getConstante() ).setScale(Configuracion.NUM_DECIMALES , RoundingMode.DOWN);
					//BigFraction constante = BigFraction.remainder( tp1.getConstante() , tp2.getConstante() );
					BigFraction constante = BigFraction.difference( tp1.getConstante() , tp2.getConstante() );
					//BigDecimal bd0 = new BigDecimal( "0.00000" );
					//BigDecimal bd0 = new BigDecimal( 0.0 ).setScale( Configuracion.NUM_DECIMALES , RoundingMode.DOWN );
					BigFraction bd0 = BigFraction.valueOf( 0 );
					if( !constante.equals( bd0 ) ) { //Se añade la resta si no se anulan; si se anulan no se añade
						Termino t = new Termino( tp2.getNumVariables(), constante, tp2.getVectorExponentes() );	
						listaTerminosDelPolinomioResultante.add( t );
					}
					terminoAnyadido = true;
					mapaTerminosAnyadidos.put( j ,  true ); //Término añadido al polinomio resultante
				}
				else if( mapaTerminosAnyadidos.get( j ) == null ) { //Si no son iguales no se restan, habrá que añadirlos luego de forma individual.
					mapaTerminosAnyadidos.put( j ,  false ); //Ponemos los de ==null para que si en algún momento el término se añade a la lista se quede a true y no se vuelva a poner de nuevo a false.
				}
			}
			if( !terminoAnyadido ) { //Añadimos el término del polinomio de arriba si no se ha restado con ninguno
				listaTerminosDelPolinomioResultante.add( tp1 );
			}
		}
		
		//Bucle para añadir los términos del polinomio que se resta (el de abajo)
		//si no se han restado con ningún término del polinomio de arriba
		for( int i =  0; i < p2.getTerminos().size(); i++ ) {
			if( !mapaTerminosAnyadidos.get( i ) ) {
				Termino t = p2.getTerminos().get( i );
				//BigDecimal constante = t.getConstante().negate();
				BigFraction constante = t.getConstante().negate();
				t.setConstante( constante );
				listaTerminosDelPolinomioResultante.add( t );
			}
		}
		
		Polinomio polinomioResultante = new Polinomio( listaTerminosDelPolinomioResultante );
		return polinomioResultante;
	}
	
	
	// Coge una lista de términos y suma las x con las x, las y con las y, las x^2 con las x^2...
	public static List<Termino> sumarTerminosIguales( List<Termino> terminos ) {
		List<Integer> indicesAnyadidos = new ArrayList<>();
		List<Termino> nuevosTerminosPolinomio = new ArrayList<>();
		for( int i = 0; i < terminos.size(); i++ ) {
			if( !indicesAnyadidos.contains( i ) ) {
				List<Termino> terminosIguales = new ArrayList<>();
				terminosIguales.add( terminos.get( i ) );
				indicesAnyadidos.add( i );
				for( int j = i+1; j < terminos.size(); j++ ) {
					if( terminos.get( i ).equalsSinConstantes( terminos.get( j ) ) ) { //Mismo monomio con distinta constante
						indicesAnyadidos.add( j );
						terminosIguales.add( terminos.get( j ) ); //Va añadiendo en una lista todos los términos formados por los mismos monomios
					}
				}				
				Termino suma = AlgoritmoDivisor.sumarTerminos( terminosIguales );
				nuevosTerminosPolinomio.add( suma );
			}
		}
		return nuevosTerminosPolinomio;
	}
	
	private static Termino sumarTerminos( List<Termino> terminosASumar ) { //La lista de términos a sumar contendrá los mismos monomios con diferente constante. Sólo se deben sumar las constantes.
		//double sumaConstantes = 0.0;
		//BigDecimal sumaConstantes = new BigDecimal( 0.0 ).setScale( Configuracion.NUM_DECIMALES , RoundingMode.DOWN );
		BigFraction sumaConstantes = BigFraction.valueOf( 0 );
		int numVariables = terminosASumar.get(0).getNumVariables();
		int[] vectorExponentes = terminosASumar.get(0).getVectorExponentes();
		for( Termino termino: terminosASumar ) {
			//sumaConstantes += termino.getConstante();
			//sumaConstantes = sumaConstantes.add( termino.getConstante() ).setScale( Configuracion.NUM_DECIMALES , RoundingMode.DOWN );
			sumaConstantes = BigFraction.sum( sumaConstantes , termino.getConstante() );
		}
		Termino terminoResultado = new Termino( numVariables, sumaConstantes, vectorExponentes );
		return terminoResultado;
	}
}
