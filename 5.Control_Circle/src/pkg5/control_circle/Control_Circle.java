/*
    Joaquin Montero. 2ºDAM. DI --> T1_A5
        Ejercicio incrementa-decrementa circulo
            // Fuente : Carpeta profe --> Termino la logica implementada 
 */
package pkg5.control_circle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Circle;

/**
 *
 * @author joaquin
 */
public class Control_Circle extends Application {
    
    private final CirclePane circlePane = new CirclePane();  // Crea Circulo
    @Override
    public void start(Stage primaryStage) {
        
        HBox hBox = new HBox();  // Crea instancia de HBox
        Button btEnlarge = new Button("Enlarge");  // Crea boton con titulo Enlarge
        Button btShrink = new Button("Shrink");    // Crea boton con titulo Shrink
        
        // Aniade los 2 botones a la escena 
        hBox.getChildren().add(btEnlarge);  
        hBox.getChildren().add(btShrink);
        
        
        btEnlarge.setOnAction(new EnlargeHandler());  // Instancia clase EnlargeHandler ( clase Inner --> bajo el main ) 
        
        btShrink.setOnAction(new ShrinkHandler());   //  --> --> --> Instancio la calse creada debajo ShrinkHandler
        
        BorderPane borderPane = new BorderPane();  
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene); 
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    // Inner Class
    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.enlarge();
        }
    }
// Punto de mejora --> --> --> Creo otra clase ( ShrinkHandler )
    // Inner Class
    class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.shrink();
        }
    }
}
class CirclePane extends StackPane {
    private final Circle circle = new Circle(50);
    
    public CirclePane() {
        getChildren().add(circle);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
    }
    public void enlarge() {
       circle.setRadius(circle.getRadius() + 2);  // +2 es el tamanio de incremento al realizar el click
    }
    public void shrink() {
        circle.setRadius(circle.getRadius() > 2   //  >2 es el tamanio tope que se puede hacer pequeño, no se sale de escena (HBox)
        ? circle.getRadius() - 2 : circle.getRadius());
    }
}
