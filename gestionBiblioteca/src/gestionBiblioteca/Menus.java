package gestionBiblioteca;

import java.util.Scanner;

public class Menus {
	
	protected static int mostrarMenuArticulos(Scanner sc) {
		System.out.println("╔════════════════════════════════════════════╗");
		System.out.println("║             Articulos                      ║");
		System.out.println("╠════════════════════════════════════════════╣");
		System.out.println("║ 1. Libro                                   ║");
		System.out.println("║ 2. Revista                                 ║");
		System.out.println("║ 3. Película                                ║");
		System.out.println("║ 4. Salir                                   ║");
		System.out.println("╚════════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int  mostrarMenuAdmin(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║           Menu de Administrador        ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Dar de alta un usuario.             ║");
		System.out.println("║ 2. Dar de baja un usuario.             ║");
		System.out.println("║ 3. Penalizar usuarios.                 ║");
		System.out.println("║ 4. Dar de alta un articulo.            ║");
		System.out.println("║ 5. Dar de baja un articulo.            ║");
		System.out.println("║ 6. Consultar prestamos.                ║");
		System.out.println("║ 7. Cerrar sesion.                      ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarPrestamosMenu(Scanner sc) {
	    System.out.println("╔═══════════════════════════╗");
	    System.out.println("║           Prestamos       ║");
	    System.out.println("╠═══════════════════════════╣");
	    System.out.println("║ 1. Activos                ║");
	    System.out.println("║ 2. Todos                  ║");
	    System.out.println("║ 3. Salir                  ║");
	    System.out.println("╚═══════════════════════════╝");
	    
	    return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuGeneros(Scanner sc) {
	    System.out.println("╔════════════════════════════════════════════╗");
	    System.out.println("║             Menú de Géneros de Libros      ║");
	    System.out.println("╠════════════════════════════════════════════╣");
	    System.out.println("║ 1. Acción                                  ║");
	    System.out.println("║ 2. Misterio                                ║");
	    System.out.println("║ 3. Ciencia Ficción                         ║");
	    System.out.println("║ 4. Fantasía                                ║");
	    System.out.println("║ 5. Romance                                 ║");
	    System.out.println("║ 6. Terror                                  ║");
	    System.out.println("║ 7. Otro                                    ║");
	    System.out.println("╚════════════════════════════════════════════╝");
	    
	    return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuTematicasRevista(Scanner sc) {
	    System.out.println("╔════════════════════════════════════════════╗");
	    System.out.println("║           Menú de Temáticas de Revista       ║");
	    System.out.println("╠════════════════════════════════════════════╣");
	    System.out.println("║ 1. Actualidad                               ║");
	    System.out.println("║ 2. Ciencia                                  ║");
	    System.out.println("║ 3. Tecnología                               ║");
	    System.out.println("║ 4. Historia                                 ║");
	    System.out.println("║ 5. Moda                                     ║");
	    System.out.println("║ 6. Cultura                                  ║");
	    System.out.println("║ 7. Otro                                    ║");
	    System.out.println("╚════════════════════════════════════════════╝");
	    
	    return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuGenerosPelicula(Scanner sc) {
	    System.out.println("╔════════════════════════════════════════════╗");
	    System.out.println("║           Menú de Géneros de Películas      ║");
	    System.out.println("╠════════════════════════════════════════════╣");
	    System.out.println("║ 1. Acción                                   ║");
	    System.out.println("║ 2. Aventura                                 ║");
	    System.out.println("║ 3. Comedia                                  ║");
	    System.out.println("║ 4. Drama                                    ║");
	    System.out.println("║ 5. Fantasía                                 ║");
	    System.out.println("║ 6. Terror                                   ║");
	    System.out.println("║ 7. Ciencia ficción                          ║");
	    System.out.println("║ 8. Romance                                  ║");
	    System.out.println("║ 9. Documental                               ║");
	    System.out.println("║ 10. Animación                               ║");
	    System.out.println("║ 11. Muscial                                 ║");
	    System.out.println("║ 12. Misterio                                ║");
	    System.out.println("║ 13. Suspense                                ║");
	    System.out.println("║ 14. Crimen                                  ║");
	    System.out.println("╚════════════════════════════════════════════╝");
	    
	    return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}

	
	protected static int mostrarMenuClasificacionEdadPelicula(Scanner sc) {
	    System.out.println("╔════════════════════════════════════════════╗");
	    System.out.println("║      Menú de Clasificaciones de Películas   ║");
	    System.out.println("╠════════════════════════════════════════════╣");
	    System.out.println("║ 1. G (Apta para todos los públicos)        ║");
	    System.out.println("║ 2. PG (Sugiere la guía de los padres)      ║");
	    System.out.println("║ 3. PG-13 (No recomendada para menores de 13 años) ║");
	    System.out.println("║ 4. R (Restringida, menores de 17 años requieren acompañamiento de un adulto) ║");
	    System.out.println("║ 5. NC-17 (Prohibida para menores de 17 años)║");
	    System.out.println("╚════════════════════════════════════════════╝");
	    
	    return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}
	
	protected static int mostrarMenuUsuario(Scanner sc) {
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║           Menu de Usaurio              ║");
		System.out.println("╠════════════════════════════════════════╣");
		System.out.println("║ 1. Hacer prestamo/s.                   ║");
		System.out.println("║ 2. Devolver libro/s.                   ║");
		System.out.println("║ 3. Consultar prestamos.                ║");
		System.out.println("║ 4. Cerrar sesion.                      ║");
		System.out.println("╚════════════════════════════════════════╝");
		
		return controlDatos.pedirOpcion(sc, "Eligue una opcion: ");
	}

}
