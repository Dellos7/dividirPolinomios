package algoritmo;
import java.util.ArrayList;
import java.util.List;

import datos.Polinomio;
import datos.ResultadoDivision;
import datos.Termino;


public class AlgoritmoBaseGrebner {
	
	
	public static List<Polinomio> calculaBaseGrebner( List<Polinomio> polinomiosDelIdeal ) {
		
		
		boolean terminar = false;
		while( !terminar ){
			
			//List<Polinomio> polinomiosAñadir = new ArrayList<>();
			terminar = true;
			
			boolean terminarBucleExterno = false;
			for( int i = 0; i < polinomiosDelIdeal.size() && !terminarBucleExterno; i++ ){
				boolean terminarBucleInterno = false;
				for( int j = i+1; j < polinomiosDelIdeal.size() && !terminarBucleInterno; j++){	
					Polinomio Spol = calculaSpolinomio(polinomiosDelIdeal.get(i), polinomiosDelIdeal.get(j));
					if( !(AlgoritmoDivisor.dividirPolinomios( Spol, polinomiosDelIdeal ).getResto().polinomioCero() )){
						polinomiosDelIdeal.add( Spol );
						terminar = false;
						terminarBucleInterno = true;
						terminarBucleExterno = true;
					}
						/*if(!comprueba(polinomiosDelIdeal, Spol)){
							terminar = false;
							polinomiosAñadir.add( Spol );
						}
						else{
							terminar = true;
						}*/
						//System.out.println(Spol);
						//terminar = false;
					//}
				}
			}
			//polinomiosDelIdeal.addAll(polinomiosAñadir);
			
		}
		//System.out.println(polinomiosDelIdeal.toString());
		return polinomiosDelIdeal;
	}
	
	
	
	public static Polinomio calculaSpolinomio( Polinomio p1, Polinomio p2 ) {
		int[] alpha = p1.LT().getVectorExponentes();
		int[] beta = p2.LT().getVectorExponentes();
		
		int[] gamma = new int[  alpha.length ];
		for( int i = 0; i < gamma.length; i++ ){
			gamma[i] = Math.max(alpha[i], beta[i]);
		}
		Termino gama = new Termino( gamma.length, 1, gamma );
		
		// Calculamos el Spolinomio
		Termino parte1 = gama.divideTerminos( p1.LT() );
		Termino parte2 = gama.divideTerminos( p2.LT() );
		Polinomio polParte1 = AlgoritmoDivisor.multiplicacionTerminoPolinomio( parte1, p1 );
		Polinomio polParte2 = AlgoritmoDivisor.multiplicacionTerminoPolinomio( parte2, p2 );
		
		Polinomio Spol = AlgoritmoDivisor.restaPolinomios(polParte1, polParte2);
		return Spol;
	}
	
	
	
	
	
	public static List<Polinomio> obtenBaseDeGrebnerMinimal( List<Polinomio> polinomiosDeLaBase ){
		
		// Hacemos que LT(polinomio) = 1
		List<Polinomio> polinomiosConConstanteTerminoLider1 = Polinomio.dividirPolinomiosPorLaCOnstanteDelTerminoLider(polinomiosDeLaBase);
		
		List<Polinomio> baseMinimal = new ArrayList<>();
		// Eliminamos los polinomios cuyo término líder esté incluido en el ideal generado
		// por los término líderes del resto de polinomios
		for( int i = 0; i < polinomiosConConstanteTerminoLider1.size(); i++ ){
			Polinomio p1 = polinomiosConConstanteTerminoLider1.get(i);
			boolean incluir = true;
			for( int j = 0; j < polinomiosConConstanteTerminoLider1.size(); j++ ){
				Polinomio p2 = polinomiosConConstanteTerminoLider1.get(j);
				if( i != j && AlgoritmoDivisor.esDivisible(p1.LT(), p2.LT())){
					incluir = false;
					break;
				}
			}
			if( incluir ){
				baseMinimal.add(p1);
			}
		}
		return baseMinimal;
	}
	
	public static List<Polinomio> obtenBaseDeGrebnerReducida( List<Polinomio> baseMinimal ){
		List<Polinomio> baseReducida = new ArrayList<>();
		// Eliminamos los polinomios que tengan algún monomio que esté incluido en el ideal generado
		// por los término líderes del resto de polinomios
		
		//Bucle para recorrer cada polinomio de la base
		for( int i = 0; i < baseMinimal.size(); i++ ){
			Polinomio polinomio = baseMinimal.get(i);
			boolean incluir = true;
			
			//Bucle para recorrer los términos de cada polinomio
			for( int j = 0; j < polinomio.getTerminos().size(); j++ ){
				Termino termino = polinomio.getTerminos().get(j);
				
				//Bucle para recorrer los polinomios de la base y ver si el término es
				//múltiplo de alguno de los términos líderes de los otros polinomios
				for( int k = 0; k < baseMinimal.size(); k++ ){
					if (i != k && AlgoritmoDivisor.esDivisible(termino, baseMinimal.get(k).LT())){
						incluir = false;
						break;
					}
				}
			}
			if( incluir ){
				baseReducida.add( polinomio );
			}
		}
		
		return baseReducida;
	}
	
}
