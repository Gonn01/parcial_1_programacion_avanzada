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

        hechizos.add(new Hechizo("Kamehameha", Nivel.PRINCIPIANTE, Elementos.LUZ));
        hechizos.add(new Hechizo("Makankosappo", Nivel.INTERMEDIO, Elementos.OSCURIDAD));
        hechizos.add(new Hechizo("Genkidama", Nivel.MAESTRO, Elementos.LUZ));
        hechizos.add(new Hechizo("Final Flash", Nivel.AVANZADO, Elementos.ELECTRICIDAD));
        hechizos.add(new Hechizo("Big Bang Attack", Nivel.INTERMEDIO, Elementos.FUEGO));
        hechizos.add(new Hechizo("Destructo Disc", Nivel.INTERMEDIO, Elementos.AIRE));
        hechizos.add(new Hechizo("Masenko", Nivel.PRINCIPIANTE, Elementos.FUEGO));
        hechizos.add(new Hechizo("Burning Attack", Nivel.INTERMEDIO, Elementos.FUEGO));
        hechizos.add(new Hechizo("Death Beam", Nivel.AVANZADO, Elementos.OSCURIDAD));
        hechizos.add(new Hechizo("Supernova", Nivel.LEYENDA, Elementos.ENERGIA_PURA));

        System.out.println("\n--- Registro de hechizos ---");
        while (true) {
            System.out.println("Lista de hechizos predeterminados:");
            for (Hechizo hechizo : hechizos) {
                System.out.println(hechizo.getNombre() + " - " + hechizo.getElemento().getNombre());
            }
            System.out.print("Nombre del hechizo (o escriba 'salir' para terminar): ");
            String nombreHechizo = scanner.nextLine();
            if (nombreHechizo.equalsIgnoreCase("salir"))
                break;

            System.out.println("Niveles disponibles:");
            for (int i = 0; i < Nivel.values().length; i++) {
                System.out.println((i + 1) + ") " + Nivel.values()[i].getNombre());
            }

            Nivel nivelHechizo = null;
            while (true) {
                System.out.print("Seleccione el nivel del hechizo (1-" + Nivel.values().length + "): ");
                try {
                    int nivelInput = Integer.parseInt(scanner.nextLine());
                    if (nivelInput >= 1 && nivelInput <= Nivel.values().length) {
                        nivelHechizo = Nivel.values()[nivelInput - 1];
                        break;
                    } else {
                        System.out.println("Nivel fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido.");
                }
            }

            System.out.println("Elementos disponibles:");
            for (int i = 0; i < Elementos.values().length; i++) {
                System.out.println((i + 1) + ") " + Elementos.values()[i].getNombre());
            }

            Elementos elementoHechizo = null;
            while (true) {
                System.out.print("Seleccione el elemento del hechizo (1-" + Elementos.values().length + "): ");
                try {
                    int elementoInput = Integer.parseInt(scanner.nextLine());
                    if (elementoInput >= 1 && elementoInput <= Elementos.values().length) {
                        elementoHechizo = Elementos.values()[elementoInput - 1];
                        break;
                    } else {
                        System.out.println("Elemento fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido.");
                }
            }

            hechizos.add(new Hechizo(nombreHechizo, nivelHechizo, elementoHechizo));
            System.out.println("Hechizo registrado con éxito.\n");
        }

        List<Estudiante> estudiantes = new ArrayList<>();
        System.out.println("\n--- Registro de estudiantes ---");
        while (true) {
            System.out.print("Nombre del estudiante (o escriba 'salir' para terminar): ");
            String nombreEst = scanner.nextLine();
            if (nombreEst.equalsIgnoreCase("salir"))
                break;

            int edad = 0;
            while (true) {
                System.out.print("Edad: ");
                try {
                    edad = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido para la edad.");
                }
            }

            System.out.println("Niveles disponibles:");
            for (int i = 0; i < Nivel.values().length; i++) {
                System.out.println((i + 1) + ") " + Nivel.values()[i].getNombre());
            }

            Nivel nivelSeleccionado = null;
            while (true) {
                System.out.print("Seleccione el nivel (1-" + Nivel.values().length + "): ");
                try {
                    int nivelInput = Integer.parseInt(scanner.nextLine());
                    if (nivelInput >= 1 && nivelInput <= Nivel.values().length) {
                        nivelSeleccionado = Nivel.values()[nivelInput - 1];
                        break;
                    } else {
                        System.out.println("Número fuera de rango.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido.");
                }
            }

            estudiantes.add(new Estudiante(nombreEst, edad, nivelSeleccionado));
            System.out.println("Estudiante registrado con éxito.\n");
        }

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados. Cerrando el programa.");
            scanner.close();
            return;
        }

        System.out.println("\n--- Selección de estudiante ---");
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            System.out.println((i + 1) + ") " + e.getNombre() + " (Edad: " + e.getEdad() + ", Nivel: "
                    + e.getNivel().getNombre() + ")");
        }

        Estudiante estudiante = null;
        while (true) {
            System.out.print("Ingrese el número del estudiante: ");
            try {
                int seleccion = Integer.parseInt(scanner.nextLine());
                if (seleccion >= 1 && seleccion <= estudiantes.size()) {
                    estudiante = estudiantes.get(seleccion - 1);
                    break;
                } else {
                    System.out.println("Número fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }

        while (true) {
            System.out.println("\n--- Hechizos disponibles ---");
            for (int i = 0; i < hechizos.size(); i++) {
                Hechizo hechizo = hechizos.get(i);
                System.out.println((i + 1) + ") " + hechizo.getNombre() + ", "
                        + hechizo.getElemento().getNombre() + " (" +
                        (estudiante.getHechizosAprendidos().contains(hechizo) ? "Aprendido" : "No aprendido") + ")");
            }
            System.out.println("0) Salir");

            int opcion;
            try {
                System.out.print("Ingrese el número del hechizo a aprender: ");
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
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

            Hechizo hechizoSeleccionado = hechizos.get(opcion - 1);
            Aprendizaje intento = new Aprendizaje(estudiante, hechizoSeleccionado);

            try {
                intento.intentarAprender();
                System.out.println("¡Hechizo aprendido con éxito!");
            } catch (NivelInsuficienteException | HechizoYaAprendidoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        Aprendizaje.mostrarHistorial();
        scanner.close();
    }
}
