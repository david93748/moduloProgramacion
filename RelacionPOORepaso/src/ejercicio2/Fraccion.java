package ejercicio2;


import mates.MisFuncionesMatematicas;
import mates.MisFuncionesMatematicasException;

public class Fraccion {

	private int numerador;
	private int denominador;

	public Fraccion(int numerador, int denominador) throws FraccionException {

		setNumerador(numerador);
		setDenominador(denominador);

	}

	public int getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) throws FraccionException {
		if (denominador == 0) {
			throw new FraccionException("El 0 no puede ser divisor");
		}

		this.denominador = denominador;
	}

	@Override
	public String toString() {
		return numerador + "/" + denominador;
	}

	public boolean equals(Fraccion otra) {
		double resultado1, resultado2;
		boolean esIgual = false;

		resultado1 = this.numerador * otra.denominador;
		resultado2 = otra.numerador * this.denominador;

		if (resultado1 == resultado2) {
			esIgual = true;
		}

		return esIgual;
	}

	public Fraccion sumar(Fraccion otra) throws FraccionException {
		Fraccion resultado = null;
		int numeradorNuevo, denominadorNuevo;

		if (otra.numerador < 0 || otra.denominador < 0) {
			throw new FraccionException("No se admiten valores negativos");
		}

		numeradorNuevo = this.numerador + otra.numerador;
		denominadorNuevo = this.denominador + otra.denominador;

		resultado = new Fraccion(numeradorNuevo, denominadorNuevo);

		return resultado;
	}

	public void simplificar() throws MisFuncionesMatematicasException {
		int mcd = 0;

		try {
			mcd = MisFuncionesMatematicas.mcd(this.numerador, this.denominador);
		} catch (MisFuncionesMatematicasException e) {
			System.out.println("Ha ocurrido un error");
		}

		this.numerador = this.numerador / mcd;
		this.denominador = this.denominador / mcd;

	}

}
