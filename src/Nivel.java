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

    public static int nivelToInt(Nivel nivel) {
        switch (nivel) {
            case PRINCIPIANTE:
                return 1;
            case INTERMEDIO:
                return 2;
            case AVANZADO:
                return 3;
            case MAESTRO:
                return 4;
            case LEYENDA:
                return 5;
            default:
                return 0;
        }
    }
}
