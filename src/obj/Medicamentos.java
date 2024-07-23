package obj;

public class Medicamentos {
    private String nombre1;
    private String dosis1;
    private Float tiempo1;
    private String nombre2;
    private String dosis2;
    private Float tiempo2;
    private String nombre3;
    private String dosis3;
    private Float tiempo3;

    public Medicamentos(String nombre1, String dosis1, Float tiempo1, String nombre2, String dosis2, Float tiempo2, String nombre3, String dosis3, Float tiempo3) {
        this.nombre1 = nombre1;
        this.dosis1 = dosis1;
        this.tiempo1 = tiempo1;
        this.nombre2 = nombre2;
        this.dosis2 = dosis2;
        this.tiempo2 = tiempo2;
        this.nombre3 = nombre3;
        this.dosis3 = dosis3;
        this.tiempo3 = tiempo3;
    }

    public Medicamentos() {

    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getDosis1() {
        return dosis1;
    }

    public void setDosis1(String dosis1) {
        this.dosis1 = dosis1;
    }

    public Float getTiempo1() {
        return tiempo1;
    }

    public void setTiempo1(Float tiempo1) {
        this.tiempo1 = tiempo1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getDosis2() {
        return dosis2;
    }

    public void setDosis2(String dosis2) {
        this.dosis2 = dosis2;
    }

    public Float getTiempo2() {
        return tiempo2;
    }

    public void setTiempo2(Float tiempo2) {
        this.tiempo2 = tiempo2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getDosis3() {
        return dosis3;
    }

    public void setDosis3(String dosis3) {
        this.dosis3 = dosis3;
    }

    public Float getTiempo3() {
        return tiempo3;
    }

    public void setTiempo3(Float tiempo3) {
        this.tiempo3 = tiempo3;
    }
}
