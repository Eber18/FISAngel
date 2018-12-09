package itm.ang.controlab.entidades;

public class Materia {

    //private Integer ID;
    private String nombre;

    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {

    }

/*public Materia(Integer ID, String nombre) {
        this.ID = ID;
        this.nombre = nombre;
    }*/

   /* public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
