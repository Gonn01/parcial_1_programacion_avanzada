public class Aprendizaje {
    private Estudiante estudiante;
    private Hechizo hechizo;

    public Aprendizaje(Estudiante estudiante, Hechizo hechizo) {
        this.estudiante = estudiante;
        this.hechizo = hechizo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Hechizo getHechizo() {
        return hechizo;
    }
}
