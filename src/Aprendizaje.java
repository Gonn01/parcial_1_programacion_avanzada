import excepciones.HechizoYaAprendidoException;
import excepciones.NivelInsuficienteException;

import java.util.ArrayList;
import java.util.List;

public class Aprendizaje {
    private Estudiante estudiante;
    private Hechizo hechizo;

    private static List<Aprendizaje> historial = new ArrayList<>();

    public Aprendizaje(Estudiante estudiante, Hechizo hechizo) {
        this.estudiante = estudiante;
        this.hechizo = hechizo;
    }

    public void intentarAprender() throws NivelInsuficienteException, HechizoYaAprendidoException {
        estudiante.aprenderHechizo(hechizo);
        historial.add(this);
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Hechizo getHechizo() {
        return hechizo;
    }

    public static List<Aprendizaje> getHistorial() {
        return historial;
    }

    public static void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No se registraron aprendizajes aún.");
        } else {
            System.out.println("Historial de aprendizajes registrados:");
            for (Aprendizaje a : historial) {
                System.out.println("- " + a.estudiante.getNombre() + " aprendió " + a.hechizo.getNombre());
            }
        }
    }
}
