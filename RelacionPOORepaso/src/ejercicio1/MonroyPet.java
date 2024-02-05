package ejercicio1;

import java.util.Objects;

public class MonroyPet {

	private static final int PRECIO_COMIDA = 30;
	private String nombre;
	private String tipo;
	private int comida;
	private int puntos;

	private static int totalTiempoJugado = 0;

	public MonroyPet(String nombre, String tipo) throws MonroyPetException {
		tipo = tipo.toUpperCase();

		if (!(tipo.equals("PERRO") || tipo.equals("GATO"))) {
			throw new MonroyPetException("El tipo debe ser Perro o gato");
		}
		this.nombre = nombre;
		this.comida = 0;
		this.puntos = 0;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public int getComida() {
		return comida;
	}

	public int getPuntos() {
		return puntos;
	}

	@Override
	public String toString() {
		return "MonroyPet [nombre=" + nombre + ", tipo=" + tipo + ", comida=" + comida + ", puntos=" + puntos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonroyPet other = (MonroyPet) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(tipo, other.tipo);
	}

	public void darComida() throws MonroyPetException {
		if (comida == 0) {
			throw new MonroyPetException("No te queda comida");
		}
		this.comida--;

	}

	public void comprarComida(int cantidadComprar) throws MonroyPetException {
		if (cantidadComprar < 1) {
			throw new MonroyPetException("Valor incorrecto");
		}

		if (cantidadComprar * PRECIO_COMIDA > puntos) {
			throw new MonroyPetException("No tienes suficientes puntos");
		}
		this.comida = this.comida + cantidadComprar;
		this.puntos = this.puntos - (cantidadComprar * PRECIO_COMIDA);
	}

	public void jugar(int tiempoJugar) throws MonroyPetException, MonroyPetExceptionEndProgram {
		if (tiempoJugar < 0 || tiempoJugar > 20) {
			throw new MonroyPetException("Se tiene que jugar al menos 1 minuto o maximo 20 minutos");
		}
		if (totalTiempoJugado+tiempoJugar > 100) {
			throw new MonroyPetExceptionEndProgram("Las mascotas tienen sueño... Se van a dormir ZZZZ");
		}
		this.puntos = this.puntos + (tiempoJugar * 3);

		totalTiempoJugado = totalTiempoJugado + tiempoJugar;
	}

}
