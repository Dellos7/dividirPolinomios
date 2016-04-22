package datos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import algoritmo.AlgoritmoDivisor;

public class Polinomio {
	
	private List<Termino> terminos;
	
	public Polinomio() {
		this.terminos = new ArrayList<Termino>();
	}
	
	public Polinomio( List<Termino> terminos ) {
		this.terminos = terminos;
		sumarTerminosIguales(); 
		ordenarTerminos();
	}

	private void ordenarTerminos() { // Utilizamos el órden lexicográfico
		Collections.sort( this.terminos, new Comparator<Termino>() {
			@Override
			public int compare( Termino t1, Termino t2 ) {
				for( int i = 0; i < t1.getVectorExponentes().length; i++ ) {
					if( t1.getVectorExponentes()[i] > t2.getVectorExponentes()[i] ) {
						return -1;
					}
					else if( t1.getVectorExponentes()[i] < t2.getVectorExponentes()[i] ) {
						return 1;
					}
				}
				return 0;
			}
		});
	}
	
	private void ordenarTerminosG() { // Utilizamos el órden graduadolexicográfico
		Collections.sort( this.terminos, new Comparator<Termino>() {
			@Override
			public int compare( Termino t1, Termino t2 ) {
				
				int sumaExponentesTermino1 = 0;
				int sumaExponentesTermino2 = 0;
				
				for( int j = 0; j < t1.getVectorExponentes().length; j++ ){
					sumaExponentesTermino1 += t1.getVectorExponentes()[j]; 
					sumaExponentesTermino2 += t2.getVectorExponentes()[j]; 
				}
				
				if( sumaExponentesTermino1 > sumaExponentesTermino2 ) {
					return -1;
				}
				else if( sumaExponentesTermino2 > sumaExponentesTermino1 ){
					return 1;
				}
				else{
					for( int k = 0; k < t1.getVectorExponentes().length; k++ ) {
						if( t1.getVectorExponentes()[k] > t2.getVectorExponentes()[k] ) {
							return -1;
						}
						else if( t1.getVectorExponentes()[k] < t2.getVectorExponentes()[k] ) {
							return 1;
						}
					}
				}
					
				return 0;
					
			}
		});
	}
	
	public void addTermino( Termino t ) { //Permite ir añadiendo los términos al polinomio mientras se van introduciendo por teclado y ordenándolos cada vez
		this.terminos.add( t );
		sumarTerminosIguales();
		ordenarTerminos();
	}

	private void sumarTerminosIguales() { //Para poder simplificar los polinomios
		this.terminos = AlgoritmoDivisor.sumarTerminosIguales( this.terminos );
	}

	public List<Termino> getTerminos() {
		return terminos;
	}

	public void setTerminos( List<Termino> terminos ) {
		this.terminos = terminos;
	}
	
	public boolean polinomioCero() {
		for( int i = 0; i < this.terminos.size(); i++ ) {
			Termino termino = terminos.get(i);
			if( !termino.getConstante().equals( new BigDecimal( 0.0 ) ) ) {
				return false;
			}
		}
		return true;
	}
	
	public Polinomio copia() { // Crear una copia de un polinomio
		List<Termino> nuevaListaTerminos = new ArrayList<>();
		for( Termino termino: this.terminos ) {
			nuevaListaTerminos.add( termino.copia() );
		}
		return new Polinomio( nuevaListaTerminos );
	}
	
	public Termino LT() { //Como siempre mantenemos los polinomios ordenados de mayor a menor el término líder será el primer término de la lista
		return terminos.get(0);
	}
	
	@Override //Para imprimir el polinomio
	public String toString() {
		String res = "";
		for( int i = 0; i < this.terminos.size(); i++ ) {
			Termino termino = this.terminos.get( i );
			if( termino.getConstante().compareTo( new BigDecimal( 0.0 ) ) > 0 ) {
				res += " + ";
			}
			else {
				res += " - ";
			}
			//res += Math.abs( termino.getConstante() );
			res += termino.getConstante().abs();
			for( int j = 0; j < termino.getVectorExponentes().length; j++ ) {
				if( termino.getVectorExponentes()[j] != 0 ) { //Para que no se impriman las variables sin exponentes.
					if ( j == 0 ) { //El primero
						res += "x" + ( j+1 ) + "^" + termino.getVectorExponentes()[j]; 
					}
					else{ //El resto
						res += " * x" + ( j+1 ) + "^" + termino.getVectorExponentes()[j];
					}
				}
			}
		}
		return res;
	}
	
	@Override
	public boolean equals( Object otroObj ) { //Saber si dos polinomios son el mismo
		Polinomio otroPolinomio = (Polinomio) otroObj;
		
		if( this.terminos.size() != otroPolinomio.getTerminos().size() ) {
			return false;
		}
		
		for( int i = 0; i < this.terminos.size(); i++) {
			if( !this.terminos.get( i ).equals( otroPolinomio.getTerminos().get( i ) ) ) {
				return false;
			}
		}
		return true;
	}
	
	public static List<Polinomio> dividirPolinomiosPorLaCOnstanteDelTerminoLider( List<Polinomio> listaPolinomios ){
		List<Polinomio> nuevaLista = new ArrayList<>();
		for( int i = 0; i < listaPolinomios.size(); i++ ){
			Polinomio p = listaPolinomios.get(i);
			BigDecimal constante = p.LT().getConstante();
			
			Polinomio polDividido = new Polinomio();
			for( int j = 0; j < p.getTerminos().size(); j++ ){
				Termino t = p.getTerminos().get(j);
				Termino nuevoTermino = new Termino( t.getNumVariables(), t.getConstante().divide( constante ), t.getVectorExponentes());
				polDividido.addTermino(nuevoTermino);
			}
			
			nuevaLista.add(polDividido);
		}
		return nuevaLista;
		
	}

}
