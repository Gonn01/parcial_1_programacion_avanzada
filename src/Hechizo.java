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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hechizo) {
            return ((Hechizo) obj).nombre.equals(this.nombre);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
