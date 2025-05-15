// Hechizo.java
public class Hechizo {
    private String nombre;
    private Nivel nivelRequerido; // básico, intermedio, avanzado
    private Elementos elemento;

    public Hechizo(String nombre, Nivel nivelRequerido, Elementos elemento) {
        this.nombre = nombre;
        this.nivelRequerido = nivelRequerido;
        this.elemento = elemento;
    }

    public String getNombre() {
        return nombre;
    }

    public Nivel getNivel() {
        return nivelRequerido;
    }

    public Elementos getElemento() {
        return elemento;
    }
}
