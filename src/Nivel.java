public enum Nivel {
    PRINCIPIANTE("Principiante"),
    INTERMEDIO("Intermedio"),
    AVANZADO("Avanzado"),
    MAESTRO("Maestro"),
    LEYENDA("Leyenda");

    private String nombre;

    Nivel(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int nivelToInt() {
        return this.ordinal();
    }

}
