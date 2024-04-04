package gestionBiblioteca;

public class Revista extends Articulo {
	
	int ISSN;
	String editor, tematica;
	
	public Revista(int diasParaDevolver, String idioma, String nombre, boolean disponible, int iSSN, String editor, int tematica) {
		super(diasParaDevolver, idioma, nombre, disponible);
		ISSN = iSSN;
		this.editor = editor;
		this.tematica = obtenerNombreTematica(tematica);
	}
	
	public Revista() {
		
	}
	
    private String obtenerNombreTematica(int numTematica) {
        switch (numTematica) {
            case 1:
                return "Actualidad";
            case 2:
                return "Ciencia";
            case 3:
                return "Tecnología";
            case 4:
                return "Historia";
            case 5:
                return "Moda";
            case 6:
                return "Cultura";
            default:
                return "Otro";
        }
    }
    
    @Override
    public String toString() {
        return String.format("Nombre: %s%n" +
                             "ISSN: %d%n" +
                             "Editor: %s%n" +
                             "Tematica: %s%n" +
                             "Idioma: %s%n" +
                             "Días para devolver: %d%n" +
                             "Disponible: %s%n",
                             getNombre(), ISSN, editor, tematica, getIdioma(), getDiasParaDevolver(), isDisponible() ? "Sí" : "No");
    }
	
	

}
