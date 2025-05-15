import java.util.ArrayList;
import java.util.List;

import excepciones.HechizoYaAprendidoException;
import excepciones.NivelInsuficienteException;

public class Estudiante {
    private String nombre;
    private int edad;
    private Nivel nivel;
    private List<Hechizo> hechizosAprendidos;

    public Estudiante(String nombre, int edad, Nivel nivel) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivel = nivel;
        this.hechizosAprendidos = new ArrayList<Hechizo>();
    }

    public void aprenderHechizo(Hechizo hechizo) throws NivelInsuficienteException, HechizoYaAprendidoException {
        if (hechizosAprendidos.contains(hechizo)) {
            throw new HechizoYaAprendidoException("El estudiante ya ha aprendido este hechizo.");
        }

        if (this.getNivel().nivelToInt() < hechizo.getNivel().nivelToInt()) {
            throw new NivelInsuficienteException(
                    "El estudiante no tiene el nivel necesario para aprender este hechizo.");
        }

        hechizosAprendidos.add(hechizo);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public List<Hechizo> getHechizosAprendidos() {
        return hechizosAprendidos;
    }
}
