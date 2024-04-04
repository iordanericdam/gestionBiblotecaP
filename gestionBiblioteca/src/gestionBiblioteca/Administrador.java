package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {
	
	public Administrador(String nombreUsuario, String pass, String dni, String nombreCompleto) {
		super(nombreUsuario, pass, dni, nombreCompleto);
	}
	
	
	
	protected static Usuario comprobarCredenciales(ArrayList<Usuario> listaUsuarios, Scanner sc,
			String nombreUsuario, String pass) {
		boolean encontrado = false;
		int i = 0;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			//Utilizo !(usu instanceof Administrador) para separar los usaurios de los administradores ya que todos son usuarios pero no todos son admnistradores.
//			Busco USUARIOS
			if (!(usu instanceof Administrador)) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
					if (usu.getPass().equals(pass)) {
						System.out.println("Bienvenid@ " + usu.getNombreCompleto());
						return usu;
					} else {
						System.out.println("Contraseña incorrecta");
					}
				} 
//			Busco ADMINISTRADORES
				
			} else if(usu instanceof Administrador ) {
				if (usu.getNombreUsuario().equals(nombreUsuario)) {
					encontrado = true;
					if (usu.getPass().equals(pass)) {
						System.out.println("Bienvenid@ " + usu.getNombreCompleto());
						return usu;
					} else {
						System.out.println("Contraseña incorrecta!!");
					}
				} 
				
			}
			i++;
		}
		
		if (!encontrado) {
			System.out.println("Usuario no encontrado");
		}
		return null;
	}
	
	protected static void altaUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios, Usuario usu) {
		String nombreCompleto, dni, passProvisional, nombreUsuario;
		boolean entradaCorrecta = false, respuestaBool = false;

		do {
			sc.nextLine();
			System.out.print("Introduce el nombre completo: ");
			nombreCompleto = sc.nextLine();
		} while (!controlDatos.comprobarString(nombreCompleto, 5));
		do {
			System.out.print("Introduce el DNI o NIE: ");
			dni = sc.next().toUpperCase();

			if (!controlDatos.validarDNI(dni) && !controlDatos.validarNIE(dni)) {
				System.out.println("El DNI o NIE introducidos son incorrectos.");
				respuestaBool = controlDatos.obtenerRespuestaSiNo(sc, "¿Deseas volver a escribirlo?");
			} else {
				respuestaBool = false;
				entradaCorrecta = true;
			}

			if (comprobarUsaurio(dni, listaUsuarios)) {
				respuestaBool = controlDatos.obtenerRespuestaSiNo(sc, "¿Deseas escribir otro DNI?");
				entradaCorrecta = false;
			}

			sc.nextLine();
		} while (respuestaBool);

		if (entradaCorrecta) {
			do {
				System.out.print("Introduce el nombre de usuario que desearia tener: ");
				nombreUsuario = sc.next().toLowerCase();

				if (Usuario.comprobarNombreUsuario(nombreUsuario, listaUsuarios)) {
					System.out.println("El nombre de usuario ya esta en el sistema");
				}
				sc.nextLine();

			} while (Usuario.comprobarNombreUsuario(nombreUsuario, listaUsuarios));

			passProvisional = dni;
			System.out.println("Para iniciar sesion, debereas poner el nombre de usuario y tu dni como contraseña");
			System.out.println("A continuacion tendra que cambiar la contraseña");

			usu = new Usuario(nombreUsuario, passProvisional, dni, nombreCompleto);
			listaUsuarios.add(usu);

		}

	}
	

	protected static void bajaUsuario(Scanner sc, ArrayList<Usuario> listaUsuarios) {
		String dni;
		System.out.print("Introduce el DNI del usuario que desea eliminar: ");
		dni = sc.next();
		int i = 0;
		boolean encontrado = false, respuestaBool = false;
		while (i < listaUsuarios.size() && !encontrado) {
			Usuario usu = listaUsuarios.get(i);
			if (!(usu instanceof Administrador)) {
				if (usu.getDni().equals(dni)) {
					respuestaBool = controlDatos.obtenerRespuestaSiNo(sc,
							"¿Seguro que dese eliminar a " + usu.getNombreCompleto() + "?");
					sc.nextLine();
					encontrado = true;
					if (respuestaBool) {
						listaUsuarios.remove(i);
					} else {
						System.out.println("Vuelve caundo estes seguro");
					}
				}

			}
			i++;
		} 
		if (!encontrado) {
			System.out.println("Usaurio no encontrado");
		    sc.nextLine(); 
		}
	}
	
	protected static void penalizarUsuario(Scanner sc, ArrayList<Prestamo> listaPrestamos) {
		int diaActual;
		String diaActualS;
		System.out.print("Introduce el dia actual: ");
		diaActualS = sc.next();
		diaActual = controlDatos.comprobarSiNumero(diaActualS);
		
		for (Prestamo pres : listaPrestamos) {
			if (diaActual > pres.diaPrestamo + pres.diasParDevolver) {
				System.out.println("El usuario con DNI "+ pres.getDniUsuario() + " sera penalizado por el articulo " + pres.getPKarticulo() + "ya que lo tendria que haber devuelto hace "+ (diaActual - ( pres.diaPrestamo + pres.diasParDevolver)) + " dia/s");
				sc.nextLine();
			}
				
		}
		
		
	}
	
	

}
