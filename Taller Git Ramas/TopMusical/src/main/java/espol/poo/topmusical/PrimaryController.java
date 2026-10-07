package espol.poo.topmusical;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Cancion;

public class PrimaryController {

    @FXML
    private VBox vbTop10;
    @FXML
    private Label lblTitulo;
    @FXML
    private HBox hbHistorial;
    @FXML
    private ImageView ivCancion;
    @FXML
    private Label lblInfo;
    
    private static ArrayList<Cancion> listaCanciones;

    public void initialize() {
        listaCanciones = Cancion.leerCanciones();
        Collections.sort(listaCanciones);
        for (Cancion c : listaCanciones ) {

            HBox hb = new HBox(10); // HBox para ubicar info de cada canción
            Label lbp = new Label(c.getPosActual() + "");
            lbp.setStyle("-fx-font-weight: bold;-fx-font-size: 40;");
            ImageView iv = new ImageView();
            try {
                Image img = new Image(new FileInputStream("img/" + c.getImagen()), 50, 50, true, true);
                iv.setImage(img);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            Label lbT = new Label(c.getTitulo() + " \n" + c.getCantante()); // Título y cantante
            lbT.setStyle("-fx-font-weight: bold;-fx-font-size: 14;");

            hb.getChildren().addAll(lbp, iv, lbT); // Agregar al HBox

            hb.setOnMouseClicked(eh -> mostrarHistorial(c)); // Establecer el evento del click
            vbTop10.getChildren().add(hb); // Agregar al VBox

        }
    }

    private void mostrarHistorial(Cancion c) {
        // CAMBIO APLICADO AQUÍ: Formato "Artista - Nombre Canción"
        lblTitulo.setText(c.getCantante() + " - " + c.getTitulo());

        try {
            Image img = new Image(new FileInputStream("img/" + c.getImagen()), 100, 100, true, true);
            ivCancion.setImage(img);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        lblInfo.setText("Posición anterior: " + c.getPosPrevia() + "\n Semanas en Top: " + c.getSemanas());
 
        System.out.println(c.getHistorialPos());
        // La actualización del historial se realiza en un hilo
        Thread th = new Thread(() -> {

            int prev = -1;
            for (int p : c.getHistorialPos()) {
                System.out.println("posicion" + p);
                String ruta = "right.PNG";
                if (prev == -1) {
                    // Imagen de ingreso
                    ruta = "right.PNG";
                    prev = p;
                } else if (p <= prev) {
                    // Imagen de subida
                    ruta = "up.PNG";
                } else {
                    // Imagen de bajada
                    ruta = "down.PNG";
                }
                Label lbP = new Label(p + "");
                lbP.setStyle("-fx-font-weight: bold;-fx-font-size: 30;");
                prev = p;
                ImageView iv = new ImageView();
                try {
                    Image img = new Image(new FileInputStream("img/" + ruta));
                    iv.setImage(img);

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                // Actualizar el HBox
                Platform.runLater(() -> hbHistorial.getChildren().setAll(iv, lbP));

                // Esperar 1 segundo
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }
        });

        th.start();
    }
}