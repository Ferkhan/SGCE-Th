package controllerPacientes;

import app.ConexionBD;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import obj.AntecedenteFamiliar;
import obj.Paciente;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.time.LocalDate;

public class PacienteListCell extends ListCell<Paciente> {
    private VBox mainContent;
    private HBox content;
    private VBox vBoxNombre;
    private VBox vBoxCedula;
    private VBox vBoxDireccion;
    private VBox vBoxTelefono;
    private VBox vBoxCorreo;
    private VBox vBoxFechaNac;

    private Text nombre;
    private Text nombreLabel;
    private Text cedula;
    private Text cedulaLabel;
    private Text direccion;
    private Text direccionLabel;
    private Text telefono;
    private Text telefonoLabel;
    private Text correo;
    private Text correoLabel;
    private Text fechaNac;
    private Text fehaNacLabel;
    private ImageView imageView;
    public static Paciente pacienteActual;


    public PacienteListCell() {
        super();

        nombreLabel = new Text("Nombre:");
        nombreLabel.getStyleClass().add("label-text");
        nombre = new Text();
        nombre.getStyleClass().add("value-text");

        cedulaLabel = new Text("Nro. Cédula:");
        cedulaLabel.getStyleClass().add("label-text");
        cedula = new Text();
        cedula.getStyleClass().add("value-text");

        direccionLabel = new Text("Dirección:");
        direccionLabel.getStyleClass().add("label-text");
        direccion = new Text();
        direccion.getStyleClass().add("value-text");

        telefonoLabel = new Text("Nro. Teléfono:");
        telefonoLabel.getStyleClass().add("label-text");
        telefono = new Text();
        telefono.getStyleClass().add("value-text");

        correoLabel = new Text("Correo electrónico:");
        correoLabel.getStyleClass().add("label-text");
        correo = new Text();
        correo.getStyleClass().add("value-text");

        fehaNacLabel = new Text("Fecha de Nacimiento");
        fehaNacLabel.getStyleClass().add("label-text");
        fechaNac= new Text();
        fechaNac.getStyleClass().add("value-text");

        vBoxNombre = new VBox(nombreLabel, nombre);
        vBoxCedula = new VBox(cedulaLabel, cedula);
        vBoxDireccion = new VBox(direccionLabel, direccion);
        vBoxTelefono = new VBox(telefonoLabel, telefono);
        vBoxCorreo = new VBox(correoLabel, correo);
        vBoxFechaNac = new VBox(fehaNacLabel, fechaNac);

        imageView = new ImageView(new Image(getClass().getResourceAsStream("/imagenes/histMedico.png")));
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        imageView.setOnMouseClicked(this::handleImageClick);

        HBox textContent = new HBox(vBoxNombre, vBoxCedula, vBoxDireccion, vBoxTelefono, vBoxCorreo, vBoxFechaNac);
        textContent.setSpacing(25);
        textContent.setAlignment(Pos.CENTER_LEFT);

        HBox container = new HBox(textContent, imageView);
        container.setSpacing(10);
        HBox.setHgrow(textContent, Priority.ALWAYS);
        container.setAlignment(Pos.CENTER_LEFT);

        mainContent = new VBox(container);
        mainContent.setSpacing(10);
        mainContent.setPadding(new Insets(10));
        mainContent.getStyleClass().add("list-item");
    }

    private void handleImageClick(MouseEvent event) {
        if (pacienteActual != null) {
            try {
                System.out.println("Paciente clicado: " + pacienteActual.getNombresCompletos());
                navigateTo("/fxml/ConsultarHistorialMedico.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No hay paciente seleccionado.");
        }
    }



    private void navigateTo(String fxmlPath) throws IOException {
        try {
            Stage currentStage = (Stage) getScene().getWindow();
            currentStage.hide();
            Stage newStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void updateItem(Paciente item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            pacienteActual = item; // Guardar el paciente actual
            nombre.setText(item.getNombresCompletos());
            cedula.setText(item.getNumeroCedulaIdentidad());
            direccion.setText(item.getDireccionDomiciliaria());
            telefono.setText(item.getNumeroDeTelefono());
            correo.setText(item.getCorreoElectronico());
            LocalDate ld = item.getFechaDeNacimiento();
            fechaNac.setText(ld.toString());
            setGraphic(mainContent);
        } else {
            pacienteActual = null; // Limpiar la referencia cuando el ítem está vacío
            setGraphic(null);
        }
    }

}
