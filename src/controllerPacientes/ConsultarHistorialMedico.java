package controllerPacientes;

import app.ConexionBD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import obj.AntecedenteFamiliar;
import obj.AntecedentePersonal;
import obj.Medicamentos;
import obj.Paciente;

import java.io.IOException;
import java.sql.SQLException;

public class ConsultarHistorialMedico {

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblNombre1;
    @FXML
    private Label lblGrado1;
    @FXML
    private Label lblNombre2;
    @FXML
    private Label lblGrado2;
    @FXML
    private Label lblNombre3;
    @FXML
    private Label lblGrado3;
    @FXML
    private Label lblNombre4;
    @FXML
    private Label lblGrado4;
    @FXML
    private Label lblNombre5;
    @FXML
    private Label lblGrado5;

    @FXML
    private Label lblNombre1AP;
    @FXML
    private Label lblTiempo1;
    @FXML
    private Label lblNombre2AP;
    @FXML
    private Label lblTiempo2;
    @FXML
    private Label lblNombre3AP;
    @FXML
    private Label lblTiempo3;
    @FXML
    private Label lblNombre4AP;
    @FXML
    private Label lblTiempo4;
    @FXML
    private Label lblNombre5AP;
    @FXML
    private Label lblTiempo5;


    @FXML
    private Label lblNombre1M;
    @FXML
    private Label lblDosis1;
    @FXML
    private Label lblTiempo1M;
    @FXML
    private Label lblNombre2M;
    @FXML
    private Label lblDosis2;
    @FXML
    private Label lblTiempo2M;
    @FXML
    private Label lblNombre3M;
    @FXML
    private Label lblDosis3;
    @FXML
    private Label lblTiempo3M;

    @FXML
    private Label nombrePaciente;

    @FXML
    void actionRegresar(ActionEvent event) throws IOException {
        navigateTo("/fxml/ConsultarPaciente.fxml");
    }

    private void navigateTo(String fxmlPath) throws IOException {
        Stage currentStage = (Stage) btnRegresar.getScene().getWindow();
        currentStage.hide();
        Stage main = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        main.setScene(new Scene(root));
        main.show();
    }

    @FXML
    void initialize() throws SQLException {
        ConexionBD cbd = new ConexionBD();
        cbd.conectar();
        Paciente pacienteActual = PacienteListCell.pacienteActual;
        nombrePaciente.setText(pacienteActual.getNombresCompletos());
        var idAntFamiliar = pacienteActual.getAntFamiliar();
        AntecedenteFamiliar antFamiliar = cbd.getAntecedenteFamiliar(idAntFamiliar);

        if (antFamiliar != null) {
            lblNombre1.setText(antFamiliar.getNombre1());
            lblGrado1.setText(formatGrado(antFamiliar.getGrado1()));
            lblNombre2.setText(antFamiliar.getNombre2());
            lblGrado2.setText(formatGrado(antFamiliar.getGrado2()));
            lblNombre3.setText(antFamiliar.getNombre3());
            lblGrado3.setText(formatGrado(antFamiliar.getGrado3()));
            lblNombre4.setText(antFamiliar.getNombre4());
            lblGrado4.setText(formatGrado(antFamiliar.getGrado4()));
            lblNombre5.setText(antFamiliar.getNombre5());
            lblGrado5.setText(formatGrado(antFamiliar.getGrado5()));
        }

        var idAntPersonal = pacienteActual.getAntPersonal();
        AntecedentePersonal antPersonal = cbd.getAntecedentePersonal(idAntPersonal);

        if (antPersonal != null) {
            lblNombre1AP.setText(antPersonal.getNombre1());
            lblTiempo1.setText(formatTiempo(antPersonal.getTiempo1()));
            lblNombre2AP.setText(antPersonal.getNombre2());
            lblTiempo2.setText(formatTiempo(antPersonal.getTiempo2()));
            lblNombre3AP.setText(antPersonal.getNombre3());
            lblTiempo3.setText(formatTiempo(antPersonal.getTiempo3()));
            lblNombre4AP.setText(antPersonal.getNombre4());
            lblTiempo4.setText(formatTiempo(antPersonal.getTiempo4()));
            lblNombre5AP.setText(antPersonal.getNombre5());
            lblTiempo5.setText(formatTiempo(antPersonal.getTiempo5()));
        }

        var idMedicamento = pacienteActual.getMedicamento();
        Medicamentos medicamentos = cbd.getMedicamento(idMedicamento);
        cbd.cerrar();

        if (medicamentos != null) {
            lblNombre1M.setText(medicamentos.getNombre1());
            lblDosis1.setText(medicamentos.getDosis1());
            lblTiempo1M.setText(formatTiempo(medicamentos.getTiempo1()));
            lblNombre2M.setText(medicamentos.getNombre2());
            lblDosis2.setText(medicamentos.getDosis2());
            lblTiempo2M.setText(formatTiempo(medicamentos.getTiempo2()));
            lblNombre3M.setText(medicamentos.getNombre3());
            lblDosis3.setText(medicamentos.getDosis3());
            lblTiempo3M.setText(formatTiempo(medicamentos.getTiempo3()));
        }
    }

    private String formatGrado(int grado) {
        return grado == 0 ? "" : String.valueOf(grado);
    }

    private String formatTiempo(float tiempo) {
        return tiempo == 0 ? "" : String.valueOf(tiempo);
    }
}
