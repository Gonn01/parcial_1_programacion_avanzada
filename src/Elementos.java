public enum Elementos {
    FUEGO("Fuego"),
    AGUA("Agua"),
    TIERRA("Tierra");

    private String nombre;

    Elementos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
