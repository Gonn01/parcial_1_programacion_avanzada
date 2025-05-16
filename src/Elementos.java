public enum Elementos {
    FUEGO("Fuego"),
    AGUA("Agua"),
    TIERRA("Tierra"),
    AIRE("Aire"),
    LUZ("Luz"),
    OSCURIDAD("Oscuridad"),
    ELECTRICIDAD("Electricidad"),
    ENERGIA_PURA("Energía Pura");

    private final String nombre;

    Elementos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
