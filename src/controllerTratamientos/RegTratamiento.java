package controllerTratamientos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegTratamiento {

    @FXML
    private MenuItem btnActualizarPaciente;

    @FXML
    private MenuItem btnActualizarPaciente1;

    @FXML
    private MenuItem btnActualizarPaciente11;

    @FXML
    private MenuItem btnActualizarPaciente111;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private MenuItem btnConsultaPaciente;

    @FXML
    private MenuItem btnConsultaPaciente1;

    @FXML
    private MenuItem btnConsultaPaciente11;

    @FXML
    private MenuItem btnConsultaPaciente111;

    @FXML
    private MenuItem btnConsultaPaciente1111;

    @FXML
    private MenuItem btnRegistroPaciente;

    @FXML
    private TextField txtFieldNombreTerapia1;

    @FXML
    private TextField txtFieldNombreTerapia2;

    @FXML
    private TextField txtFieldNombreTerapia3;

    @FXML
    private TextField txtFieldNombreTerapia4;

    @FXML
    private TextField txtFieldNombreTerapia5;

    @FXML
    private TextField txtFieldNombreTratamiento;

    @FXML
    private TextField txtFieldNumSesiones1;

    @FXML
    private TextField txtFieldNumSesiones2;

    @FXML
    private TextField txtFieldNumSesiones3;

    @FXML
    private TextField txtFieldNumSesiones4;

    @FXML
    private TextField txtFieldNumSesiones5;

    @FXML
    private TextField txtFieldPrecioTratamiento;

    @FXML
    private TextField txtFieldTipoTratamiento;

    @FXML
    void actionRegistroPaciente(ActionEvent event) throws IOException {
        navigateTo("/fxml/RegistrarPaciente.fxml");
    }

    @FXML
    void actionConsultaPaciente(ActionEvent event) throws IOException {
        navigateTo("/fxml/ConsultarPaciente.fxml");
    }

    @FXML
    void actionActualizarPaciente(ActionEvent event) throws IOException {
        navigateTo("/fxml/ActualizarPaciente.fxml");
    }

    private void navigateTo(String fxmlPath) throws IOException {
        Stage currentStage = (Stage) btnCerrarSesion.getScene().getWindow();
        currentStage.hide();
        Stage main = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        main.setScene(new Scene(root));
        main.show();
    }

}
