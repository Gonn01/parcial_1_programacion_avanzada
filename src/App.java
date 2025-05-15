import java.util.*;

import excepciones.HechizoYaAprendidoException;
import excepciones.NivelInsuficienteException;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre del director: ");
        String nombreDirector = scanner.nextLine();
        Director director = Director.getInstancia(nombreDirector);
        System.out.println("Director registrado: " + director.getNombre());

        List<Hechizo> hechizos = new ArrayList<>();
        hechizos.add(new Hechizo("Bola de fuego", Nivel.PRINCIPIANTE, Elementos.FUEGO));
        hechizos.add(new Hechizo("Tsunami", Nivel.INTERMEDIO, Elementos.AGUA));
        hechizos.add(new Hechizo("Terremoto", Nivel.AVANZADO, Elementos.TIERRA));
        hechizos.add(new Hechizo("Tormenta eléctrica", Nivel.MAESTRO, Elementos.AGUA));
        hechizos.add(new Hechizo("Explosión cósmica", Nivel.LEYENDA, Elementos.FUEGO));
        hechizos.add(new Hechizo("Llama azul", Nivel.AVANZADO, Elementos.FUEGO));
        hechizos.add(new Hechizo("Inundación", Nivel.MAESTRO, Elementos.AGUA));
        hechizos.add(new Hechizo("Avalancha", Nivel.LEYENDA, Elementos.TIERRA));

        System.out.print("Nombre del estudiante: ");
        String nombreEst = scanner.nextLine();

        int edad = 0;
        while (true) {
            System.out.print("Edad: ");
            try {
                edad = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido para la edad.");
            }
        }

        System.out.println("Niveles disponibles:");
        for (int i = 0; i < Nivel.values().length; i++) {
            Nivel nivel = Nivel.values()[i];
            System.out.println((i + 1) + ") " + nivel.getNombre());
        }

        Nivel nivelSeleccionado = null;
        while (true) {
            System.out.print("Seleccione el nivel (1-" + Nivel.values().length + "): ");
            try {
                int nivelInput = Integer.parseInt(scanner.nextLine());
                if (nivelInput < 1 || nivelInput > Nivel.values().length) {
                    System.out.println("Número fuera de rango. Intente de nuevo.");
                } else {
                    nivelSeleccionado = Nivel.values()[nivelInput - 1];
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }

        Estudiante estudiante = new Estudiante(nombreEst, edad, nivelSeleccionado);

        while (true) {
            System.out.println("\nHechizos disponibles:");
            for (int i = 0; i < hechizos.size(); i++) {
                Hechizo hechizo = hechizos.get(i);
                System.out.println((i + 1) + ") " + hechizo.getNombre() + ", "
                        + hechizo.getElemento() + "(" + (estudiante.getHechizosAprendidos().contains(hechizo)
                                ? "Aprendido"
                                : "No aprendido")
                        + ")");
            }
            System.out.println("0) Salir");

            int opcion;
            try {
                System.out.print("Ingrese el número del hechizo a aprender: ");
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            if (opcion == 0) {
                System.out.println("Cerrando el programa...");
                break;
            }

            if (opcion < 1 || opcion > hechizos.size()) {
                System.out.println("Opción inválida.");
                continue;
            }

            try {
                estudiante.aprenderHechizo(hechizos.get(opcion - 1));
                System.out.println("¡Hechizo aprendido con éxito!");
            } catch (NivelInsuficienteException | HechizoYaAprendidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
