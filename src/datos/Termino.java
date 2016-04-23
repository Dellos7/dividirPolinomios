package datos;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import fraction.BigFraction;

public class Termino {

	private BigFraction constante;
	private int[] vectorExponentes;
	private int numVariables;
	
	public Termino() { 
		this.numVariables = 3;
		this.vectorExponentes = new int[ numVariables ];
		this.constante = BigFraction.valueOf( 0 );
	}
	
	public Termino( int numVariables ) { 
		this.numVariables = numVariables;
		this.constante = BigFraction.valueOf( 0 );
		this.vectorExponentes = new int[ numVariables ];
	}
	
	public Termino( int numVariables, int constante, int[] vectorExponentes ) {
		this.numVariables = numVariables;
		this.constante = BigFraction.valueOf( constante );
		this.vectorExponentes = vectorExponentes;
	}
	
	public Termino( int numVariables, BigFraction constante, int[] vectorExponentes ) {
		this.numVariables = numVariables;
		this.constante = constante;
		this.vectorExponentes = vectorExponentes;
	}
	
	public Termino( int numVariables, int c1Numerador, int c2Denominador , int[] vectorExponentes ) {
		this.numVariables = numVariables;
		this.constante = BigFraction.valueOf( c1Numerador, c2Denominador );
		this.vectorExponentes = vectorExponentes;
	}

	public BigFraction getConstante() {
		return this.constante;
	}

	public void setConstante(int constante) {
		this.constante = BigFraction.valueOf( constante );
	}
	
	public void setConstante( BigFraction constante ) {
		this.constante = constante;
	}

	public int[] getVectorExponentes() {
		return vectorExponentes;
	}

	public void setVectorExponentes(int[] vectorExponentes) {
		this.vectorExponentes = vectorExponentes;
	}

	public int getNumVariables() {
		return numVariables;
	}

	public void setNumVariables(int numVariables) {
		this.numVariables = numVariables;
	}
	
// División de dos términos. Sólo lo llamamos cuando sabemos que la división se puede hacer
	public Termino divideTerminos( Termino t2 ) {
		BigFraction constante = this.getConstante().divide( t2.getConstante() );
		
		int[] resta = new int[ this.getNumVariables() ];
		int i = 0;
		while( i < t2.getVectorExponentes().length ) {
			resta[i] = this.getVectorExponentes()[i] - t2.getVectorExponentes()[i];
			i++;
		}
		while( i < this.getVectorExponentes().length ) {
			resta[i] = this.getVectorExponentes()[i];
			i++;
		}
		return new Termino( this.getNumVariables(), constante, resta );
	
	}
		
	public Termino copia() {
		int[] exponentesCopia = new int[ this.numVariables ];
		Termino terminoCopia = new Termino( this.numVariables );
		for( int i = 0; i < this.vectorExponentes.length; i++ ){
			exponentesCopia[i] = this.vectorExponentes[i];
		}
		terminoCopia.setConstante( this.constante );
		terminoCopia.setVectorExponentes( exponentesCopia );
		
		return terminoCopia;
	}
	
	@Override
	public boolean equals( Object otroObj ) { //Para ver si dos términos son el mismo
		Termino otroTermino = (Termino) otroObj;
		
		if( this.vectorExponentes.length != otroTermino.getVectorExponentes().length ) {
			return false;
		}
		
		//BigDecimal bd1 = new BigDecimal( this.constante.doubleValue() ).setScale( 5 , RoundingMode.DOWN );
		//BigDecimal bd2 = new BigDecimal( otroTermino.getConstante().doubleValue() ).setScale( 5 , RoundingMode.DOWN );
		//BigDecimal bd1 = new BigDecimal( this.constante.doubleValue() ).setScale( Configuracion.NUM_DECIMALES , RoundingMode.DOWN );
		//BigDecimal bd2 = new BigDecimal( otroTermino.getConstante().doubleValue() ).setScale( Configuracion.NUM_DECIMALES , RoundingMode.DOWN );
		BigFraction bd1 = BigFraction.valueOf( this.constante );
		BigFraction bd2 = BigFraction.valueOf( otroTermino.getConstante() );
		
		/*if( !this.constante.equals(otroTermino.getConstante()) ) {
			return false;
		}*/
		if( !bd1.equals( bd2 ) ) {
			return false;
		}
		
		for( int i = 0; i < this.vectorExponentes.length; i++ ) {
			if( this.vectorExponentes[i] != otroTermino.getVectorExponentes()[i] ) {
				return false;
			}
		}
		return true;
	}
	
	public boolean equalsSinConstantes( Object otroObj ) { // Para ver si dos términos son el mismo salvo constante.
		Termino otroTermino = (Termino) otroObj;
		
		if( this.vectorExponentes.length != otroTermino.getVectorExponentes().length ) {
			return false;
		}
		
		for( int i = 0; i < this.vectorExponentes.length; i++ ) {
			if( this.vectorExponentes[i] != otroTermino.getVectorExponentes()[i] ) {
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		String t = "";
		t += this.constante +"-->";
		//t += this.numVariables +"-->";
		for( int i = 0; i < this.getVectorExponentes().length; i++ ){
			t += this.vectorExponentes[i] +"--";
		}return t;
			
	}
	
}
