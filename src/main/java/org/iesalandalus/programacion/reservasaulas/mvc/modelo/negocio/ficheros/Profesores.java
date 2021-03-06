package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio.IProfesores;


public class Profesores implements IProfesores{
	/*
	 * Atributos
	 */ 
	private static final String NOMBRE_FICHERO_PROFESORES="datos/profesores.dat";
	private List<Profesor> coleccionProfesores;
	
	/*
	 * Constructores
	 */ 
	
	public Profesores() {
		coleccionProfesores = new ArrayList<>();
	}
	
	public Profesores(Profesores profesores) {
		if (profesores == null)
			throw new NullPointerException("ERROR: No se pueden copiar profesores nulos.");

		setProfesores(profesores);
	}
	
	@Override
	public void comenzar() {
		leer();
		
	}
	private void leer() {
		File ficheroProfesor = new File(NOMBRE_FICHERO_PROFESORES);
		try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ficheroProfesor))){
			Profesor profesor= null;
			do {
				profesor = (Profesor) entrada.readObject();
				insertar(profesor);
			}while(profesor!= null);
			
		}catch (ClassNotFoundException e) {
			System.out.println("ERROR: No puedo encontrar la clase que tengo que leer");
		}catch (FileNotFoundException e) {
			System.out.println("ERROR: No se puede abir el fichero de aulas");
		}catch (EOFException e) {
			System.out.println("Fichero leido correctamente");
		}catch (IOException e) {
			System.out.println("ERROR en la Entrada/Salida");
		}catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void terminar() {
		
		escribir();
	}
	
	private void escribir() {
		File ficheroProfesor = new File(NOMBRE_FICHERO_PROFESORES);
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ficheroProfesor))){
			for(Profesor profesor : coleccionProfesores) {
				salida.writeObject(profesor);
			}
		}catch (FileNotFoundException e) {
			System.out.println("ERROR: No se puede crear el fichero de aulas");
		}catch (IOException e) {
			System.out.println("ERROR en la Entrada/Salida");
			
		}
	}
	
	

	/*
	 * setProfesores()
	 */
	
	private void setProfesores(Profesores profesores) {
		this.coleccionProfesores = copiaProfundaProfesores(profesores.getProfesores());
	}
	/*
	 * CopiaProfundaProfesor()
	 */
	
	private List<Profesor> copiaProfundaProfesores(List<Profesor> profesores) {
		List<Profesor> profesorCopia = new ArrayList<>();
		for(Profesor profesor : profesores) {
			profesorCopia.add(new Profesor(profesor));
		}
		return profesorCopia;
	}
	
	/*
	 * getProfesores
	 */
	@Override
	public  List<Profesor> getProfesores() {
		List<Profesor> profesores = copiaProfundaProfesores(coleccionProfesores);
		profesores.sort(Comparator.comparing(Profesor::getNombre));
		return profesores;

	}
	
	
	/*
	 * getNumProfesores()
	 */
	@Override
	public int getNumProfesores() {
		return coleccionProfesores.size();	
	}
	

	/*
	 * Insertar()
	 */
	@Override
	public void insertar (Profesor profesor) throws OperationNotSupportedException {
		if(profesor==null)
			throw new NullPointerException("ERROR: No se puede insertar un profesor nulo.");
		
		if(!coleccionProfesores.contains(profesor)) {
			coleccionProfesores.add(new Profesor (profesor));
		}else {
			throw new OperationNotSupportedException("ERROR: Ya existe un profesor con ese nombre.");
		}
	}
	
	/*
	 * Buscar()
	 */
	@Override
	public Profesor buscar(Profesor profesor) {
		if(profesor==null)
			throw new NullPointerException("ERROR: No se puede buscar un profesor nulo.");
		
		int indice = coleccionProfesores.indexOf(profesor);
		if(indice == -1) {
			return null;
		}else {
			return new Profesor(coleccionProfesores.get(indice));
		}
	}
	
	/*
	 * Borrar()
	 */
	@Override
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if(profesor==null)
			throw new NullPointerException("ERROR: No se puede borrar un profesor nulo.");
		
		if(!coleccionProfesores.contains(profesor)) {
			throw new OperationNotSupportedException("ERROR: No existe ning??n aula con ese nombre.");
		}else {
			coleccionProfesores.remove(profesor);
		}	
	}

	/*
	 * Representar()
	 */
	
	@Override
	public List<String> representar() {
		List<String> representarProfesores = new ArrayList<>();
		Iterator<Profesor> it = coleccionProfesores.iterator();
		Profesor profesor;
		while(it.hasNext()) {
			profesor=it.next();
			representarProfesores.add(new String(profesor.toString()));	
		}
		return representarProfesores;
	}
}