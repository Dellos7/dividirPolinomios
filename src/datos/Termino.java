package datos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Termino {

	private BigDecimal constante;
	private int[] vectorExponentes;
	private int numVariables;
	
	public Termino() { 
		this.numVariables = 3;
		this.vectorExponentes = new int[ numVariables ];
		this.constante = new BigDecimal( 0.0 );
	}
	
	public Termino( int numVariables ) { 
		this.numVariables = numVariables;
		this.constante = new BigDecimal( 0.0 );
		this.vectorExponentes = new int[ numVariables ];
	}
	
	public Termino( int numVariables, double constante, int[] vectorExponentes ) {
		this.numVariables = numVariables;
		this.constante = new BigDecimal( constante );
		this.vectorExponentes = vectorExponentes;
	}
	
	public Termino( int numVariables, BigDecimal constante, int[] vectorExponentes ) {
		this.numVariables = numVariables;
		this.constante = constante;
		this.vectorExponentes = vectorExponentes;
	}
	
	public Termino( int numVariables, double c1Numerador, double c2Denominador , int[] vectorExponentes ) {
		this.numVariables = numVariables;
		this.constante = new BigDecimal( c1Numerador ).divide( new BigDecimal(c2Denominador) , 5, RoundingMode.DOWN );
		this.vectorExponentes = vectorExponentes;
	}

	public BigDecimal getConstante() {
		return this.constante;
	}

	public void setConstante(double constante) {
		this.constante = new BigDecimal( constante );
	}
	
	public void setConstante( BigDecimal constante ) {
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
	
	double roundThreeDecimals(double d) { 
		String sValue = (String) String.format("%.2f", d);
		String [] s = sValue.split( "," );
		sValue = s[0] + "." + s[1];
		Double newValue = Double.parseDouble(sValue);
		return newValue.doubleValue();
	} 
	
// División de dos términos. Sólo lo llamamos cuando sabemos que la división se puede hacer
	public Termino divideTerminos( Termino t2 ) {
		
		/*System.out.println("---");
		System.out.println(this.toString());
		System.out.println(t2.toString());
		System.out.println("--");*/
		
		/*System.out.println( "BLABLA:" + this.getConstante() );
		System.out.println( "PEPE: " + t2.getConstante() );
		double constante = (double) (this.getConstante() / t2.getConstante() );
		System.out.println( "RES: " + constante );
		constante = Math.floor( constante*100 )/100;
		System.out.println( "RES2: " + constante );*/
		System.out.println( "c1: " + this.getConstante() );
		System.out.println( "c2: " + t2.getConstante() );
		BigDecimal constante = this.getConstante().divide( t2.getConstante(), 5, RoundingMode.DOWN );
		System.out.println( constante );
		
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
		
		BigDecimal bd1 = new BigDecimal( this.constante.doubleValue() ).setScale( 5 , RoundingMode.DOWN );
		BigDecimal bd2 = new BigDecimal( otroTermino.getConstante().doubleValue() ).setScale( 5 , RoundingMode.DOWN );
		
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
