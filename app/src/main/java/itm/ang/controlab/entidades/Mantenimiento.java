package itm.ang.controlab.entidades;

public class Mantenimiento {
    private String equipo;
    private String detalles;
    private String fecha;

    public Mantenimiento(String equipo, String detalles, String fecha) {
        this.equipo = equipo;
        this.detalles = detalles;
        this.fecha = fecha;
    }

    public Mantenimiento() {
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
