package datos;

import java.util.List;

public class ResultadoDivision { //Permite devolver los polinomios cociente y el resto
	
	private Polinomio[] resultado;
	private Polinomio resto;
	
	public ResultadoDivision( Polinomio[] resultado, Polinomio resto ) {
		this.resultado = resultado;
		this.resto = resto;
	}

	public Polinomio[] getResultado() {
		return resultado;
	}

	public void setResultado(Polinomio[] resultado) {
		this.resultado = resultado;
	}

	public Polinomio getResto() {
		return resto;
	}

	public void setResto(Polinomio resto) {
		this.resto = resto;
	}
	
}
