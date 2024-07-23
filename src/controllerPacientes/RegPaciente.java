package controllerPacientes;

import alertas.MensajeAlerta;
import app.ConexionBD;
import app.TempDataStore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import obj.Paciente;

public class RegPaciente {

    @FXML
    private Button btnAddPaciente;
    @FXML
    private MenuItem btnActualizarPaciente;

    @FXML
    private Button btnCerrarSesion;
    @FXML
    private MenuItem btnConsultaPaciente;

    @FXML
    private Button btnHistorialClinico;

    @FXML
    private TextField txtFieldCedulaPaciente;

    @FXML
    private TextField txtFieldCorreoPaciente;

    @FXML
    private TextField txtFieldDireccionPaciente;

    @FXML
    private TextField txtFieldFechaNacimientoPaciente;

    @FXML
    private TextField txtFieldNombrePaciente;

    @FXML
    private TextField txtFieldTelefonoPaciente;

    @FXML
    private MenuItem btnRegistroTratamiento;

    @FXML
    void actionRegistroTratamiento(ActionEvent event) throws IOException {
        navigateTo("/fxml/Tratamientos/RegTratamiento.fxml");
    }


    private static List<Paciente> listaPacientes = new ArrayList<>();

    @FXML
    public void initialize() {
        if (TempDataStore.nombrePaciente != null) txtFieldNombrePaciente.setText(TempDataStore.nombrePaciente);
        if (TempDataStore.cedulaPaciente != null) txtFieldCedulaPaciente.setText(TempDataStore.cedulaPaciente);
        if (TempDataStore.correoPaciente != null) txtFieldCorreoPaciente.setText(TempDataStore.correoPaciente);
        if (TempDataStore.direccionPaciente != null) txtFieldDireccionPaciente.setText(TempDataStore.direccionPaciente);
        if (TempDataStore.fechaNacimientoPaciente != null) txtFieldFechaNacimientoPaciente.setText(TempDataStore.fechaNacimientoPaciente);
        if (TempDataStore.telefonoPaciente != null) txtFieldTelefonoPaciente.setText(TempDataStore.telefonoPaciente);
    }

    @FXML
    void actionCerrarSesion(ActionEvent event) throws IOException {
        navigateTo("/fxml/Login.fxml", (Stage) btnCerrarSesion.getScene().getWindow());
    }

    @FXML
    void actionHistorialClinico(ActionEvent event) throws IOException {
        saveData();
        navigateTo("/fxml/RegistrarHistorialMedico.fxml", (Stage) btnHistorialClinico.getScene().getWindow());
    }


    private void saveData() {
        TempDataStore.nombrePaciente = txtFieldNombrePaciente.getText();
        TempDataStore.cedulaPaciente = txtFieldCedulaPaciente.getText();
        TempDataStore.correoPaciente = txtFieldCorreoPaciente.getText();
        TempDataStore.direccionPaciente = txtFieldDireccionPaciente.getText();
        TempDataStore.fechaNacimientoPaciente = txtFieldFechaNacimientoPaciente.getText();
        TempDataStore.telefonoPaciente = txtFieldTelefonoPaciente.getText();
    }
    private void navigateTo(String fxmlPath, Stage currentStage) throws IOException {
        currentStage.hide();
        Stage newStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        newStage.setScene(new Scene(root));
        newStage.show();
    }
    private void navigateTo(String fxmlPath) throws IOException {
        Stage currentStage = (Stage) btnCerrarSesion.getScene().getWindow();
        currentStage.hide();
        Stage main = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        main.setScene(new Scene(root));
        main.show();
    }
    @FXML
    void actionConsultaPaciente(ActionEvent event) throws IOException {
        navigateTo("/fxml/ConsultarPaciente.fxml");
    }

    @FXML
    void actionActualizarPaciente(ActionEvent event) throws IOException {
        navigateTo("/fxml/ActualizarPaciente.fxml");
    }


    @FXML
    void actionAddPaciente(ActionEvent event) {
        try {
            String nombre = txtFieldNombrePaciente.getText();
            String cedula = txtFieldCedulaPaciente.getText();
            String direccion = txtFieldDireccionPaciente.getText();
            String telefono = txtFieldTelefonoPaciente.getText();
            String correo = txtFieldCorreoPaciente.getText();
            LocalDate fechaNacimiento = LocalDate.parse(txtFieldFechaNacimientoPaciente.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate fechaCreacion = LocalDate.now();
            ConexionBD cbd = new ConexionBD();
            cbd.conectar();
            int antPersonalId = cbd.getIDAntecedentes();
            int antFamiliarId = cbd.getIDAF();
            int medicamentoId = cbd.getIDMedicamento();
            List<String> cedulas = cbd.getPacienteCedulas();
            Paciente nuevoPaciente = new Paciente(
                    nombre,
                    cedula,
                    direccion,
                    telefono,
                    correo,
                    fechaNacimiento,
                    fechaCreacion,
                    antPersonalId,
                    antFamiliarId,
                    medicamentoId
            );
            cbd.cerrar();

            if(!validarNombre(nombre)){MensajeAlerta.mensaje("Nombre no válido") ;
                return;}
            if(!validarCedula(cedula)){MensajeAlerta.mensaje("Cédula no válida");
                return;}
            if(!validarDireccion(direccion)){MensajeAlerta.mensaje("Dirección no válida");
                return;}
            if(!validarCedulaDuplicada(cedulas,cedula)){MensajeAlerta.mensaje("Número de cédula ya registrado");
                return;
            }
            if(!validarTelefono(telefono)){MensajeAlerta.mensaje("Teléfono no válido");
                return;}
            if(!validarCorreo(correo)){MensajeAlerta.mensaje("Correo no válido");
                return;}
            if(!RegHistorialMedico.correcto){
                MensajeAlerta.mensaje("Añadir historial clínico");
                return;
            }

            listaPacientes.add(nuevoPaciente);

            ConexionBD conexionBD = new ConexionBD();
            conexionBD.conectar();
            boolean guardado = conexionBD.guardarPaciente(nuevoPaciente);
            conexionBD.cerrar();



            if (guardado) {
                System.out.println("Paciente guardado exitosamente.");
                MensajeAlerta.registrarPaciente("Paciente registrado exitosamente");
                txtFieldNombrePaciente.setText(" ");
                txtFieldFechaNacimientoPaciente.setText(" ");
                txtFieldCorreoPaciente.setText(" ");
                txtFieldDireccionPaciente.setText(" ");
                txtFieldTelefonoPaciente.setText(" ");
                txtFieldCedulaPaciente.setText(" ");
                TempDataStore.nombrePaciente = null;
                TempDataStore.cedulaPaciente = null;
                TempDataStore.correoPaciente = null;
                TempDataStore.direccionPaciente = null;
                TempDataStore.fechaNacimientoPaciente = null;
                TempDataStore.telefonoPaciente = null;
            } else {
                System.out.println("Error al guardar el paciente en la base de datos.");
            }

        } catch (DateTimeParseException ex){
            MensajeAlerta.mensaje("Fecha de nacimiento no válida");
        }
        catch (Exception e) {
            System.out.println("Error al guardar el paciente.");
            e.printStackTrace();
        }
    }

    public boolean validarCedulaDuplicada(List<String> cedulasBD, String cedula){
        boolean duplicado = true;
        for(String cedulaBD : cedulasBD){
            if (cedulaBD.equals(cedula)) {
                duplicado = false;
                break;
            }
        }
        return duplicado;
    }

    public boolean validarNombre(String nombre){
        String regex = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$";
        return nombre.matches(regex);
    }
    public boolean validarDireccion(String direccion) {
        String ALLOWED_CHARACTERS = "^[a-zA-Z0-9 .\\-#/]*$";
        if (direccion == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(ALLOWED_CHARACTERS);
        return pattern.matcher(direccion).matches();
    }

    public boolean validarTelefono(String telefono){
        if (telefono == null || telefono.length() != 10) {
            return false;
        }
        for (char c : telefono.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    public boolean validarCorreo(String correo){
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(patron);
        return pattern.matcher(correo).matches();
    }
    public boolean validarCedula(String cd){
        StringTokenizer cedula;
        int[] digitos = new int[10];
        boolean validado = true;
        try {
            if (cd.length() == 10) { // Se verifica la longitud del String cedula
                cedula = new StringTokenizer(cd, "1234567890", true);
                int i = 0;

                while (cedula.hasMoreTokens() && i < 10) {
                    digitos[i] = Integer.parseInt(cedula.nextToken());
                    i++;
                }
                int codigoProvincia = digitos[0] * 10 + digitos[1];
                if ((codigoProvincia < 25 && codigoProvincia > 0) || codigoProvincia == 30) {
                    if (digitos[2] < 6) {
                        int suma = 0;
                        for (int j = 0; j < digitos.length; j++) {
                            if (j % 2 == 0) { // Método de validación llamado "Módulo de 10"

                                digitos[j] = digitos[j] * 2;

                                if (digitos[j] >= 10) {
                                    digitos[j] = digitos[j] - 9;
                                }
                            }
                            suma = suma + digitos[j];
                        }
                        if (suma % 10 == 0) {
                            validado = true;
                        } else if (10 - (suma % 10) == digitos[9]) {
                            validado = true;
                        } else {
                            validado = false;
                        }
                    } else {
                        validado = false;
                    }
                } else {
                    validado = false;
                }
            } else {
                validado = false;
            }
        } catch (NumberFormatException e) { // Captura excepciones sobre los tipos de datos ingresados
            validado = false;
        }
        return validado;
    }
}


