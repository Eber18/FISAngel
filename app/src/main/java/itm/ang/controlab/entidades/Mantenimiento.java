package itm.ang.controlab.entidades;

public class Mantenimiento {
    private int ID;
    private String equipo;
    private String detalles;
    private String fecha;

    public Mantenimiento(int ID, String equipo, String detalles, String fecha) {
        this.ID = ID;
        this.equipo = equipo;
        this.detalles = detalles;
        this.fecha = fecha;
    }

    public Mantenimiento() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
