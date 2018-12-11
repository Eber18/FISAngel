package itm.ang.controlab.entidades;

public class Practica {

    private int ID;
    private String profesor;
    private String materia;
    private String practica;
    private int alumnos;
    private String fecha;

    public Practica(int ID, String profesor, String materia, String practica, int alumnos, String fecha) {
        this.ID = ID;
        this.profesor = profesor;
        this.materia = materia;
        this.practica = practica;
        this.alumnos = alumnos;
        this.fecha = fecha;
    }

    public Practica() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getPractica() {
        return practica;
    }

    public void setPractica(String practica) {
        this.practica = practica;
    }

    public int getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(int alumnos) {
        this.alumnos = alumnos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
