package org.iesalandalus.programacion.reservasaulas;


import org.iesalandalus.programacion.reservasaulas.mvc.controlador.Controlador;
import org.iesalandalus.programacion.reservasaulas.mvc.controlador.IControlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.IModelo;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.Modelo;
import org.iesalandalus.programacion.reservasaulas.mvc.vista.IVista;


public class MainApp {

	public static void main(String[] args) {
		IModelo modelo = new Modelo(modelo);
		IVista vista;
		IControlador controlador = new Controlador (modelo,vista);
		controlador.comenzar();	
	}

}
