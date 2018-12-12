package itm.ang.controlab.entidades;

public class Inventario {

    private int ID;
    private String serieCPU;
    private String serieTec;
    private String serieRaton;
    private String serieMonitor;
    private String cantidadRAM;
    private String cantidadDD;
    private String procesador;
    private String devc;
    private String netbeans;
    private String eclipse;
    private String notepad;
    private String gEdit;
    private String dia;
    private String postgreSQL;
    private String packet;
    private String virtual;
    private String unity;
    private String visualStudio;
    private String internet;
    private String salon;
    private String observaciones;

    public Inventario(int ID, String serieCPU, String serieTec, String serieRaton, String serieMonitor, String cantidadRAM,
                      String cantidadDD, String procesador, String devc, String netbeans, String eclipse, String notepad,
                      String gEdit, String dia, String postgreSQL, String packet, String virtual, String unity, String visualStudio,
                      String internet, String salon, String observaciones) {
        this.ID = ID;
        this.serieCPU = serieCPU;
        this.serieTec = serieTec;
        this.serieRaton = serieRaton;
        this.serieMonitor = serieMonitor;
        this.cantidadRAM = cantidadRAM;
        this.cantidadDD = cantidadDD;
        this.procesador = procesador;
        this.devc = devc;
        this.netbeans = netbeans;
        this.eclipse = eclipse;
        this.notepad = notepad;
        this.gEdit = gEdit;
        this.dia = dia;
        this.postgreSQL = postgreSQL;
        this.packet = packet;
        this.virtual = virtual;
        this.unity = unity;
        this.visualStudio = visualStudio;
        this.internet = internet;
        this.salon = salon;
        this.observaciones = observaciones;
    }

    public Inventario() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSerieCPU() {
        return serieCPU;
    }

    public void setSerieCPU(String serieCPU) {
        this.serieCPU = serieCPU;
    }

    public String getSerieTec() {
        return serieTec;
    }

    public void setSerieTec(String serieTec) {
        this.serieTec = serieTec;
    }

    public String getSerieRaton() {
        return serieRaton;
    }

    public void setSerieRaton(String serieRaton) {
        this.serieRaton = serieRaton;
    }

    public String getSerieMonitor() {
        return serieMonitor;
    }

    public void setSerieMonitor(String serieMonitor) {
        this.serieMonitor = serieMonitor;
    }

    public String getCantidadRAM() {
        return cantidadRAM;
    }

    public void setCantidadRAM(String cantidadRAM) {
        this.cantidadRAM = cantidadRAM;
    }

    public String getCantidadDD() {
        return cantidadDD;
    }

    public void setCantidadDD(String cantidadDD) {
        this.cantidadDD = cantidadDD;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getDevc() {
        return devc;
    }

    public void setDevc(String devc) {
        this.devc = devc;
    }

    public String getNetbeans() {
        return netbeans;
    }

    public void setNetbeans(String netbeans) {
        this.netbeans = netbeans;
    }

    public String getEclipse() {
        return eclipse;
    }

    public void setEclipse(String eclipse) {
        this.eclipse = eclipse;
    }

    public String getNotepad() {
        return notepad;
    }

    public void setNotepad(String notepad) {
        this.notepad = notepad;
    }

    public String getgEdit() {
        return gEdit;
    }

    public void setgEdit(String gEdit) {
        this.gEdit = gEdit;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getPostgreSQL() {
        return postgreSQL;
    }

    public void setPostgreSQL(String postgreSQL) {
        this.postgreSQL = postgreSQL;
    }

    public String getPacket() {
        return packet;
    }

    public void setPacket(String packet) {
        this.packet = packet;
    }

    public String getVirtual() {
        return virtual;
    }

    public void setVirtual(String virtual) {
        this.virtual = virtual;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public String getVisualStudio() {
        return visualStudio;
    }

    public void setVisualStudio(String visualStudio) {
        this.visualStudio = visualStudio;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
