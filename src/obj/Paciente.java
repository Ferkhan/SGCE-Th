package obj;

import java.time.LocalDate;

public class Paciente {
    private String nombresCompletos;
    private String numeroCedulaIdentidad;
    private String direccionDomiciliaria;
    private String numeroDeTelefono;
    private String correoElectronico;
    private LocalDate fechaDeNacimiento;
    private LocalDate fechaCreacion;
    private Integer antPersonal;
    private Integer antFamiliar;
    private Integer medicamento;

    public Paciente(String nombresCompletos, String numeroCedulaIdentidad, String direccionDomiciliaria, String numeroDeTelefono, String correoElectronico, LocalDate fechaDeNacimiento, LocalDate fechaCreacion, Integer antPersonal, Integer antFamiliar, Integer medicamento) {
        this.nombresCompletos = nombresCompletos;
        this.numeroCedulaIdentidad = numeroCedulaIdentidad;
        this.direccionDomiciliaria = direccionDomiciliaria;
        this.numeroDeTelefono = numeroDeTelefono;
        this.correoElectronico = correoElectronico;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.antPersonal = antPersonal;
        this.antFamiliar = antFamiliar;
        this.medicamento = medicamento;
    }

    public String getNombresCompletos() {
        return nombresCompletos;
    }

    public void setNombresCompletos(String nombresCompletos) {
        this.nombresCompletos = nombresCompletos;
    }

    public String getNumeroCedulaIdentidad() {
        return numeroCedulaIdentidad;
    }

    public void setNumeroCedulaIdentidad(String numeroCedulaIdentidad) {
        this.numeroCedulaIdentidad = numeroCedulaIdentidad;
    }

    public String getDireccionDomiciliaria() {
        return direccionDomiciliaria;
    }

    public void setDireccionDomiciliaria(String direccionDomiciliaria) {
        this.direccionDomiciliaria = direccionDomiciliaria;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getAntPersonal() {
        return antPersonal;
    }

    public void setAntPersonal(Integer antPersonal) {
        this.antPersonal = antPersonal;
    }

    public Integer getAntFamiliar() {
        return antFamiliar;
    }

    public void setAntFamiliar(Integer antFamiliar) {
        this.antFamiliar = antFamiliar;
    }

    public Integer getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Integer medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public String toString() {
        return nombresCompletos + " - " + numeroCedulaIdentidad;
    }
}
