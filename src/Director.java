// Director.java
public class Director {
    private static Director instancia;
    private String nombre;

    private Director(String nombre) {
        this.nombre = nombre;
    }

    public static Director getInstancia(String nombre) {
        if (instancia == null) {
            instancia = new Director(nombre);
        }
        return instancia;
    }

    public String getNombre() {
        return nombre;
    }
}
