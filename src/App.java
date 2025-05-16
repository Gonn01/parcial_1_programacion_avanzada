import java.util.*;

import excepciones.HechizoYaAprendidoException;
import excepciones.NivelInsuficienteException;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese nombre del director: ");
        String nombreDirector = scanner.nextLine();
        Director director = Director.getInstancia(nombreDirector);
        System.out.println("Director registrado: " + director.getNombre() + "\n");

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

        System.out.println("--- Registro de hechizos ---\n");
        while (true) {
            System.out.println("Lista de hechizos predeterminados:\n ");
            for (Hechizo hechizo : hechizos) {
                System.out.println(hechizo.getNombre() + " - " + hechizo.getElemento().getNombre());
            }
            System.out.print("\nNombre del hechizo (o escriba 'salir' para terminar): ");
            String nombreHechizo = scanner.nextLine();
            if (nombreHechizo.equalsIgnoreCase("salir"))
                break;

            System.out.println("\nNiveles disponibles: \n");
            for (int i = 0; i < Nivel.values().length; i++) {
                System.out.println((i + 1) + ") " + Nivel.values()[i].getNombre());
            }

            Nivel nivelHechizo = null;
            while (true) {
                System.out.print("\nSeleccione el nivel del hechizo (1-" + Nivel.values().length + "): ");
                try {
                    int nivelInput = Integer.parseInt(scanner.nextLine());
                    if (nivelInput >= 1 && nivelInput <= Nivel.values().length) {
                        nivelHechizo = Nivel.values()[nivelInput - 1];
                        break;
                    } else {
                        System.out.println("Nivel fuera de rango. \n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido. \n");
                }
            }

            System.out.println("\n Elementos disponibles: \n");
            for (int i = 0; i < Elementos.values().length; i++) {
                System.out.println((i + 1) + ") " + Elementos.values()[i].getNombre());
            }

            Elementos elementoHechizo = null;
            while (true) {
                System.out.print("\nSeleccione el elemento del hechizo (1-" + Elementos.values().length + "): ");
                try {
                    int elementoInput = Integer.parseInt(scanner.nextLine());
                    if (elementoInput >= 1 && elementoInput <= Elementos.values().length) {
                        elementoHechizo = Elementos.values()[elementoInput - 1];
                        break;
                    } else {
                        System.out.println("Elemento fuera de rango. \n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido. \n");
                }
            }

            hechizos.add(new Hechizo(nombreHechizo, nivelHechizo, elementoHechizo));
            System.out.println("Hechizo registrado con éxito. \n");
        }

        List<Estudiante> estudiantes = new ArrayList<>();
        System.out.println("\n --- Registro de estudiantes --- \n");
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
                    System.out.println("Ingrese un número válido para la edad. \n");
                }
            }

            System.out.println("\nNiveles disponibles: \n");
            for (int i = 0; i < Nivel.values().length; i++) {
                System.out.println((i + 1) + ") " + Nivel.values()[i].getNombre());
            }

            Nivel nivelSeleccionado = null;
            while (true) {
                System.out.print("\nSeleccione el nivel (1-" + Nivel.values().length + "): ");
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
            System.out.println("\nEstudiante registrado con éxito.\n");
        }

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados. Cerrando el programa. \n");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\n--- Selección de estudiante --- \n");
            for (int i = 0; i < estudiantes.size(); i++) {
                Estudiante e = estudiantes.get(i);
                System.out.println((i + 1) + ") " + e.getNombre() + " (Edad: " + e.getEdad() + ", Nivel: "
                        + e.getNivel().getNombre() + ")");
            }
            System.out.println("0) Salir");

            Estudiante estudiante = null;
            while (true) {
                System.out.print("\nIngrese el número del estudiante: ");
                try {
                    int seleccion = Integer.parseInt(scanner.nextLine());
                    if (seleccion == 0) {
                        System.out.println("\nCerrando el programa... \n");
                        Aprendizaje.mostrarHistorial();
                        scanner.close();
                        return;
                    } else if (seleccion >= 1 && seleccion <= estudiantes.size()) {
                        estudiante = estudiantes.get(seleccion - 1);
                        break;
                    } else {
                        System.out.println("Número fuera de rango. \n");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido. \n");
                }
            }

            while (true) {
                System.out.println("\n--- Hechizos disponibles para " + estudiante.getNombre() + " ---\n");
                for (int i = 0; i < hechizos.size(); i++) {
                    Hechizo hechizo = hechizos.get(i);
                    System.out.println((i + 1) + ") " + hechizo.getNombre() + ", "
                            + hechizo.getElemento().getNombre() + " (" +
                            (estudiante.getHechizosAprendidos().contains(hechizo) ? "Aprendido" : "No aprendido")
                            + ")");
                }
                System.out.println("0) Cambiar de estudiante");

                int opcion;
                try {
                    System.out.print("\nIngrese el número del hechizo a aprender: ");
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido. \n");
                    continue;
                }

                if (opcion == 0) {
                    break;
                }

                if (opcion < 1 || opcion > hechizos.size()) {
                    System.out.println("Opción inválida. \n");
                    continue;
                }

                Hechizo hechizoSeleccionado = hechizos.get(opcion - 1);
                Aprendizaje intento = new Aprendizaje(estudiante, hechizoSeleccionado);

                try {
                    intento.intentarAprender();
                    System.out.println("¡Hechizo aprendido con éxito! \n");
                } catch (NivelInsuficienteException | HechizoYaAprendidoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }
}
