package gestionBiblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articulo {
//	libros, revistas y películas (los atributos tenéis que pensarlos).
	int diasParaDevolver = 15;
	String idioma, nombre;
	boolean disponible;

	public Articulo() {
	}

	public Articulo(int diasParaDevolver, String idioma, String nombre, boolean disponible) {
		this.diasParaDevolver = diasParaDevolver;
		this.idioma = idioma;
		this.nombre = nombre;
		this.disponible = disponible;
	}

	public int getDiasParaDevolver() {
		return diasParaDevolver;
	}

	public void setDiasParaDevolver(int diasParaDevolver) {
		this.diasParaDevolver = diasParaDevolver;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	protected static void altaArticulo(int tipo, ArrayList<Articulo> listaArticulos, Articulo art, Scanner sc) {

		String nombre = null, idioma = null, diasParaDevolucionS, ISBNs, autor, editor, ISSNs,
				 director;
		boolean disponible = false;
		int diasParaDevolucion = 0, ISBN = 0, genero = 0, ISSN = 0, tematica = 0, clasificacionEdad;
		

		if (tipo != 4) {
			sc.nextLine();
			System.out.print("Introduce el nombre: ");
			nombre = sc.nextLine();
			disponible = controlDatos.obtenerRespuestaSiNo(sc, "¿El articulo esta disponible?");
			do {
				System.out.print("¿En cuantos dias se debe devolver? ");
				diasParaDevolucionS = sc.next();
				diasParaDevolucion = controlDatos.comprobarSiNumero(diasParaDevolucionS);
				sc.nextLine();
			} while (diasParaDevolucion == 0);

			System.out.print("Introduce el idioma: ");
			idioma = sc.nextLine();
		} else {
			System.out.println("Saliendo...");
		}

		switch (tipo) {
		case 1:
			do {
				System.out.print("Introduce el ISBN del libro: ");
				ISBNs = sc.next();
				ISBN = controlDatos.comprobarSiNumero(ISBNs);
				sc.nextLine();
			} while (ISBN == 0);
			System.out.print("Introduce el/los autor/es del libro: ");
			autor = sc.nextLine();
			do {
				genero = Menus.mostrarMenuGeneros(sc);
				sc.nextLine();
			} while (genero == 0);

			art = new Libro(diasParaDevolucion, idioma, nombre, disponible, ISBN, autor, genero);
			listaArticulos.add((Libro) art);
			break;
		case 2:
			do {
				System.out.print("Introduce el ISSN de la revista: ");
				ISSNs = sc.next();
				ISSN = controlDatos.comprobarSiNumero(ISSNs);
				sc.nextLine();
			} while (ISSN == 0);

			System.out.print("Introduce el/los editor/es de la revista: ");
			editor = sc.nextLine();
			do {
				tematica = Menus.mostrarMenuGeneros(sc);
				sc.nextLine();
			} while (tematica == 0);

			art = new Revista(diasParaDevolucion, idioma, nombre, disponible, ISSN, editor, tematica);
			listaArticulos.add((Revista) art);
			break;
		case 3:
			System.out.print("Introduce el nombre del Director/es: ");
			director = sc.nextLine();
			do {
				genero = Menus.mostrarMenuGenerosPelicula(sc);
				sc.nextLine();
			} while (genero == 0);
			do {
				clasificacionEdad = Menus.mostrarMenuClasificacionEdadPelicula(sc);
				sc.nextLine();
			} while (clasificacionEdad == 0);

			art = new Pelicula(diasParaDevolucion, idioma, nombre, disponible, director, genero, clasificacionEdad);
			listaArticulos.add((Pelicula) art);

			break;

		}

	}
	
	protected static void darDeBajaArticulo(ArrayList<Articulo> listaArticulos, Class<? extends Articulo> tipoArticulo, Scanner sc) {
        int indiceMayor = -1, indiceMenor = 0;
        for (int i = 0; i < listaArticulos.size(); i++) {
            Articulo art = listaArticulos.get(i);
            if (tipoArticulo.isInstance(art)) {
                System.out.println("----------" + tipoArticulo.getSimpleName() + " " + i + "----------");
                System.out.println(art.toString());
                indiceMayor = i;
                indiceMenor++;
            }
            if (i == (listaArticulos.size() - 1) && indiceMayor != -1) {
                System.out.print("Introduce el nombre del " + tipoArticulo.getSimpleName().toLowerCase() + " que desea eliminar PERMANENTEMENTE: ");
                String opcionS = sc.next();
                sc.nextLine();
                int opcion = controlDatos.comprobarSiNumero(opcionS);
                if (opcion != -1 && opcion <= indiceMayor && opcion >= (indiceMayor-indiceMenor)+1) {
                    art = listaArticulos.get(opcion);
                    if (!art.isDisponible()) {
                    	System.out.println("El articulo no se puede dar de baja por un prestamo activo, si se desea dar de baja contacto con el administrador");
                    	break;
                    }
                    sc.nextLine();
                    boolean respuestaBool = controlDatos.obtenerRespuestaSiNo(sc, "¿Está seguro que desea eliminar el " + tipoArticulo.getSimpleName().toLowerCase() + " " + art.getNombre() + "?");
                    if (respuestaBool) {
                        listaArticulos.remove(opcion);
                        System.out.println("El " + tipoArticulo.getSimpleName().toLowerCase() + " ha sido eliminado correctamente.");
                    } else {
                        System.out.println("Cancelando eliminación de " + tipoArticulo.getSimpleName().toLowerCase() + "...");
                    }
                } else {
                    System.out.println("El número introducido no es una opción válida.");
                }
            }
        }

        if (indiceMayor == -1) {
            System.out.println("Actualmente no hay " + tipoArticulo.getSimpleName().toLowerCase() + "s en el sistema.");
        }
    }
	



	protected static int obtenerTipoArtiuclo(Scanner sc) {
		String opcionS;
		int opcion;
		do {
			opcion = Menus.mostrarMenuArticulos(sc);
			if (opcion != 0 && opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
				System.out.println("Debes introducir un numero del 1 al 4");
			}
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);
		return opcion;

	}

	protected static void consultarArticulosALL(ArrayList<Articulo> listaArticulos) {
		for (Articulo art : listaArticulos) {
			if (art instanceof Libro) {
				System.out.println(art.toString());
			} else if (art instanceof Revista) {
				System.out.println(art.toString());
			} else if (art instanceof Pelicula) {
				System.out.println(art.toString());
			}
		}

	}
	
	
	protected static ArrayList<Integer> consultarArticulos(ArrayList<Articulo> listaArticulos, Class<? extends Articulo> tipoArticulo) {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i< listaArticulos.size();i++) {
			Articulo art = listaArticulos.get(i);
			if (tipoArticulo.isInstance(art)) {
				System.out.println("----------" + tipoArticulo.getSimpleName() + " " + i + "----------");
				System.out.println(art.toString());
				indices.add(i);
			}
		}
		
		return indices;

	}
	
	
}
