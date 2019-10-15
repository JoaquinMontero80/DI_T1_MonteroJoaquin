/*
    Joaquin Montero. 2DAM. DI --> T1A11
        Ejercicio FadeTransition. 
        Programa crea una elipse, Aplica una transición
        gradual (Fade Transition) a la elipse. Y controla la animación con la pulsación 
        de ratón, mientras pulsado que pause la animación y cuando se suelte 
        la pulsación que vuelva a reproducirse.
 */
package pkg11.prueba_fadetransition;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author joaquin
 */
public class Prueba_FadeTransition extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        
        //Crea la ventana de tipo Pane
        StackPane ventana = new StackPane();
      
        // Crea objeto escena
        Scene scene = new Scene(ventana, 400, 300);
        primaryStage.setTitle("PathTransition"); // Titulo
        primaryStage.setScene(scene);  // Aniade escena
        primaryStage.show();  // Muestra
        
        Ellipse ellipse = new Ellipse(200, 140, 100, 70);  // ( tamanioX, tmanioY, ejeX, ejeY )
        ellipse.setStroke(Color.BLACK);   // Color de borde circulo
        ellipse.setFill(Color.RED);      // Color interno de circulo
        ventana.getChildren().add(ellipse);  // Aniade
        
        
        // Applica una fade transition a ellipse
        FadeTransition ft = new FadeTransition(Duration.millis(3000), ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play(); // Start animation
        // Control animation
        ellipse.setOnMousePressed(e -> ft.pause());  // Para al hacer click
        ellipse.setOnMouseReleased(e -> ft.play());  // Continua al soltar click
        
        
        
        
    }   // Fin de metodo start

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

  

    
}