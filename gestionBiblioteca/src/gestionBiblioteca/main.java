//		Tenéis que realizar un aplicación para llevar a cabo la gestión de la biblioteca. Dicha aplicación podrán usarla dos tipos de usuarios:
//
//			1.- Administradores: Pueden ser varios y sus tareas son:
//
//			Dar de alta usuarios para poder hacer los préstamos.
//			Penalizar a los usuarios si no se devuelven en fecha, de tal manera que durante unos días no podrá llevarse ningún artículo.
//			Dar de alta artículos
//			Dar de baja artículos.
//			Ver los préstamos de un cliente, diferenciando cuales están en activos y cuales no.

//			2.- Usuarios: Podrán hacer las siguientes tareas:
//
//			Hacer un préstamo o varios a la vez.
//			Hacer una devolución o varias a la vez.
//			Ver sus préstamos en activo para ver los días que le quedan para la devolución.
//			Los artículos que puede llevarse el cliente son: libros, revistas y películas (los atributos tenéis que pensarlos).

package gestionBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		ArrayList<Articulo> listaArticulos = new ArrayList<Articulo>();
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		Articulo art = new Articulo();
		Usuario usu = new Usuario();

//		Creacion de usuarios de administrador
		Administrador admin1 = new Administrador("admin", "admin", "46660198Y", "Admin");
		listaUsuarios.add((Administrador) admin1);
		Administrador admin2 = new Administrador("admineric", "eric", "50322180C", "Eric");
		listaUsuarios.add((Administrador) admin2);

		Usuario usuario1 = new Usuario("eric", "eric", "80560285W", "Eric Iordan", false);
		listaUsuarios.add(usuario1);
		Usuario usuario2 = new Usuario("david", "david", "00188202Q", "David Gil", false);
		listaUsuarios.add(usuario2);

		// Crear libros
		Libro libro1 = new Libro(14, "Español", "Cien años de soledad", true, 4652, "Gabriel García Márquez", 4);
		Libro libro2 = new Libro(21, "Inglés", "To Kill a Mockingbird", true, 36524, "Harper Lee", 12);
		Libro libro3 = new Libro(10, "Francés", "Le Petit Prince", true, 789651, "Antoine de Saint-Exupéry", 5);

		// Crear revistas
		Revista revista1 = new Revista(7, "Español", "National Geographic", true, 112255, "National Geographic Society",
				1);
		Revista revista2 = new Revista(7, "Inglés", "Scientific American", true, 885533, "Springer Nature", 2);
		Revista revista3 = new Revista(7, "Francés", "Paris Match", true, 99966, "Lagarde Family", 6);

		// Crear películas
		Pelicula pelicula1 = new Pelicula(3, "Inglés", "The Shawshank Redemption", true, "Frank Darabont", 5, 6);
		Pelicula pelicula2 = new Pelicula(3, "Español", "El Laberinto del Fauno", true, "Guillermo del Toro", 2, 3);
		Pelicula pelicula3 = new Pelicula(3, "Inglés", "Inception", true, "Christopher Nolan", 4, 55);

		// Añadir los artículos a la lista
		listaArticulos.add(libro1);
		listaArticulos.add(libro2);
		listaArticulos.add(libro3);
		listaArticulos.add(revista1);
		listaArticulos.add(revista2);
		listaArticulos.add(revista3);
		listaArticulos.add(pelicula1);
		listaArticulos.add(pelicula2);
		listaArticulos.add(pelicula3);

		String nombreUsuario, pass, opcionS;
		int opcion = 0;
		System.out.println("Bienvenido/a a la bibloteca Todo Libros");
		do {
			System.out.print("Introduce tu nombre de usuario: ");
			nombreUsuario = sc.nextLine().toLowerCase();
			System.out.print("Introduce tu contrseña: ");
			pass = sc.nextLine();
			usu = Administrador.comprobarCredenciales(listaUsuarios, sc, nombreUsuario, pass);
			if (usu instanceof Administrador) {
				do {
					opcion = Menus.mostrarMenuAdmin(sc);
					switch (opcion) {
					case 1:
						Administrador.altaUsuario(sc, listaUsuarios, usu);
						break;
					case 2:
						Administrador.bajaUsuario(sc, listaUsuarios);
						break;
					case 3:
						Administrador.penalizarUsuario(sc, listaPrestamos);
						break;
					case 4:
						do {
							opcion = Articulo.obtenerTipoArtiuclo(sc);
							if (opcion != 4) {
								Articulo.altaArticulo(opcion, listaArticulos, art, sc);
							}
						} while (opcion != 4);
						break;
					case 5:
						do {
							opcion = Articulo.obtenerTipoArtiuclo(sc);
							if (opcion != 4) {
								switch (opcion) {
								case 1:
									Articulo.darDeBajaArticulo(listaArticulos, Libro.class, sc);
									break;
								case 2:
									Articulo.darDeBajaArticulo(listaArticulos, Revista.class, sc);
									break;
								case 3:
									Articulo.darDeBajaArticulo(listaArticulos, Pelicula.class, sc);
									break;	
								}
								
							} 
						} while (opcion != 4);
						break;
					case 6:
						Prestamo.consultarPrestamosAdministrador(sc, listaPrestamos);
						break;
					case 7:
						System.out.println("Adios :(");
						sc.nextLine();
						break;
					case 8:
						do {

						} while (opcion != 4);
						Articulo.consultarArticulosALL(listaArticulos);
						break;
					}
				} while (opcion != 7);
			} else if (!(usu instanceof Administrador)) {
				try {
					if (usu.isPrimerLogin()) {
						Usuario.primerLogin(sc, usu);
						sc.nextLine();
					}
					do {
						opcion = Menus.mostrarMenuUsuario(sc);
						switch (opcion) {
						case 1:
							altaPrestamoMain(sc, listaArticulos, listaPrestamos, usu);
							break;
						case 2:
							Prestamo.devolverPrestamo(listaPrestamos, listaArticulos, usu, sc);
							break;
						case 3:
							Prestamo.consultarPrestamosUsuario(sc, listaPrestamos, usu);
							break;
						case 4:
							sc.nextLine();
							System.out.println("Adios :(");
							break;

						}

					} while (opcion != 4);

				} catch (NullPointerException e) {
				}
			}
		} while (true);
	}
	
	private static void altaPrestamoMain(Scanner sc, ArrayList<Articulo> listaArticulos, ArrayList<Prestamo>listaPrestamos, Usuario usu) {
		int opcion;
		
		opcion = Articulo.obtenerTipoArtiuclo(sc);
		switch (opcion) {
		case 1:
			Prestamo.realizarPrestamo(sc,usu, listaArticulos,  Libro.class, listaPrestamos);
			break;
		case 2:
			Prestamo.realizarPrestamo(sc,usu, listaArticulos,  Revista.class, listaPrestamos);
			break;
		case 3:
			Prestamo.realizarPrestamo(sc,usu, listaArticulos,  Pelicula.class, listaPrestamos);
			break;	
		case 4:
			System.out.println("Saliendo...");
			break;
		}
		
	}


}
