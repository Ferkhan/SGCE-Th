package alertas;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MensajeAlerta {
    public static void mensaje(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText("Importante");
        alerta.setContentText(mensaje);
        alerta.show();
    }

    /*public static void info(String informacion){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("Información de activos");
        alerta.setContentText(informacion);
        alerta.setTitle("Activos");
        alerta.show();

    }*/

    public static void info(String informacion){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("No se han encontrado registros en ese mes ");
        alerta.setContentText(informacion);
        alerta.setTitle("Consulta");
        alerta.show();

    }
    public static void registrarPaciente(String informacion){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("Éxito");
        alerta.setContentText(informacion);
        alerta.show();

    }

    public static void menDespedida(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setHeaderText("Importante");
        alerta.setContentText(mensaje);

        Optional<ButtonType> result = alerta.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
        } else {
            alerta.close();
        }
    }

    public static void menError(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);

        alerta.setHeaderText("Ingreso Incorrecto");
        alerta.setContentText(mensaje);

        Optional<ButtonType> result = alerta.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
        } else {
            alerta.close();
        }
    }

    public static boolean confirmoLogin;
    public static void menRegresoLogin(String confirmar) throws IOException {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setHeaderText("Importante");
        alerta.setContentText(confirmar);

        Optional<ButtonType> result = alerta.showAndWait();
        if (result.get() == ButtonType.OK){
            Stage main = new Stage();
            Parent root = FXMLLoader.load(MensajeAlerta.class.getResource("/fxml/Reporte.fxml"));
            Scene scene = new Scene(root);
            main.setScene(scene);
            main.show();
            confirmoLogin = true;
        } else {
            alerta.close();
            confirmoLogin = false;
        }
    }

    public static void menConfirmacion(String confirmacion){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText("Confirmación");
        alerta.setContentText(confirmacion);
        alerta.show();
    }
}
