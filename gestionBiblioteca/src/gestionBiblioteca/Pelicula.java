package gestionBiblioteca;

public class Pelicula  extends Articulo{
	
	String director, genero, clasificacionEdad;

	public Pelicula(int diasParaDevolver, String idioma, String nombre, boolean disponible, String director, int genero, int clasificacionEdad) {
		super(diasParaDevolver, idioma, nombre, disponible);
		this.director = director;
		this.genero = convertirNumeroAGeneroPelicula(genero);
		this.clasificacionEdad = convertirNumeroAClasificacionEdad(clasificacionEdad);
	}
	
	public Pelicula() {
	}
	
	
	
	
	protected static String convertirNumeroAClasificacionEdad(int numClasificacion) {
	    switch (numClasificacion) {
	        case 1:
	            return "G (Apta para todos los públicos)";
	        case 2:
	            return "PG (Sugiere la guía de los padres)";
	        case 3:
	            return "PG-13 (No recomendada para menores de 13 años)";
	        case 4:
	            return "R (Restringida, menores de 17 años requieren acompañamiento de un adulto)";
	        case 5:
	            return "NC-17 (Prohibida para menores de 17 años)";
	        default:
	            return "Otro";
	    }
	}

	protected static String convertirNumeroAGeneroPelicula(int numGenero) {
	    switch (numGenero) {
	        case 1:
	            return "Acción";
	        case 2:
	            return "Aventura";
	        case 3:
	            return "Comedia";
	        case 4:
	            return "Drama";
	        case 5:
	            return "Fantasía";
	        case 6:
	            return "Terror";
	        case 7:
	            return "Ciencia ficción";
	        case 8:
	            return "Romance";
	        case 9:
	            return "Documental";
	        case 10:
	            return "Animación";
	        case 11:
	            return "Musical";
	        case 12:
	            return "Misterio";
	        case 13:
	            return "Suspense";
	        case 14:
	            return "Crimen";
	        default:
	            return "Otro";
	    }
	}
	
	
    @Override
    public String toString() {
        return String.format("Nombre: %s%n" +
                             "Director: %s%n" +
                             "Género: %s%n" +
                             "Clasificación por Edad: %s%n" +
                             "Idioma: %s%n" +
                             "Días para devolver: %d%n" +
                             "Disponible: %s%n",
                             getNombre(), director, genero, clasificacionEdad, getIdioma(), getDiasParaDevolver(), isDisponible() ? "Sí" : "No");
    }



	
	
	
}
