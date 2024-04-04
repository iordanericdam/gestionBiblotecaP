package gestionBiblioteca;

import java.util.Scanner;

public class controlDatos {
	
	protected static int comprobarSiNumero(String numeroS) {
		int opcion = -1;
		try {
			opcion = Integer.parseInt(numeroS);
			if (opcion < 0) {
				System.out.println("Debes introducir un número mayor o igual que 0.");
				opcion = -1;
			}
		} catch (Exception e) {
			System.out.println("Debes introducir un numero.");

		}
		return opcion;
	}

	protected static boolean comprobarString(String variableS, int caracteres) {
		boolean correcto = false;
		if (variableS.length() < caracteres) {
			System.out.println("La longitud debe de ser minimo de " + caracteres + " caracteres");
		} else {
			correcto = true;
		}
		return correcto;

	}

	protected static boolean obtenerRespuestaSiNo(Scanner sc, String pregunta) {
		boolean respuesta;
		while (true) {
			System.out.print(pregunta + " (responda con si o no): ");
			char respuestaChar = sc.next().toLowerCase().charAt(0);
			if (respuestaChar == 's') {
				respuesta = true;
				break;
			} else if (respuestaChar == 'n') {
				respuesta = false;
				break;
			} else {
				System.out.println("Por favor, responda con si o no.");
			}
		}
		return respuesta;
	}
	
	protected static int pedirOpcion(Scanner sc, String pregunta) {
		String opcionS;
		int opcion;
		System.out.print(pregunta);
		opcionS = sc.next();
		opcion = controlDatos.comprobarSiNumero(opcionS);
		return opcion;
	}
	
	protected static boolean validarDNI(String dni) {
		if (dni == null || dni.length() != 9) {
			return false;
		}

		for (int i = 0; i < 8; i++) {
			if (!Character.isDigit(dni.charAt(i))) {
				return false;
			}
		}

		char letra = Character.toUpperCase(dni.charAt(8));
		if (!Character.isLetter(letra)) {
			return false;
		}

		int numDNI;
		try {
			numDNI = Integer.parseInt(dni.substring(0, 8));
		} catch (NumberFormatException e) {
			return false;
		}

		char letraCalculada = calcularLetra(numDNI);

		if (letra != letraCalculada) {
			return false;
		}

		return true;
	}

	private static char calcularLetra(int numero) {
		String letrasNIE = "TRWAGMYFPDXBNJZSQVHLCKE";
		int indiceLetra = numero % 23;
		return letrasNIE.charAt(indiceLetra);

	}

	protected static boolean validarNIE(String nie) {
		char primeraLetra = nie.charAt(0);
		if (primeraLetra == 'X') {
			nie = "0" + nie.substring(1);
		} else if (primeraLetra == 'Y') {
			nie = "1" + nie.substring(1);
		} else if (primeraLetra == 'Z') {
			nie = "2" + nie.substring(1);
		} else {
			return false;
		}

		if (nie.length() != 9 || !nie.substring(1).matches("\\d{7}[A-Z]")) {
			return false;
		}

		String digitos = nie.substring(0, 8);
		int numNIE = Integer.parseInt(digitos);
		char letraCalculada = calcularLetra(numNIE);
		char letraControl = nie.charAt(8);

		if (letraControl != letraCalculada) {
			return false;
		}

		return true;
	}

}
