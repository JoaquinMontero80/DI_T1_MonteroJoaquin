/* 
    DI. T1_A2_HelloWorld con JavaFX
        Joaquin Montero. 2ºDAM.    
            Fuente : https://docs.oracle.com/javase/8/javafx/get-started-tutorial/hello_world.htm
*/
package pkg1.hello_world;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Hello_World extends Application {
    
    // Clase principal extiende de : javafx.application.Applicationclase. 
    // start()método es el punto de entrada principal para todas las aplicaciones JavaFX.
    @Override
    public void start(Stage primaryStage) 
    {
        // Crea objeto Boton
        Button btn = new Button();
        // Escribe texto dentro del boton
        btn.setText("Decir : 'Hello World'");
        // Boton acciona ( nuevo evento<ActionEvent> )
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            // Creo un contador para especificar cuantas veces se toca boton
            int contador = 1;
            @Override
            public void handle(ActionEvent event) {
                System.out.println( "Has clickado : "+ contador + " veces en Hello World!");
                contador++;  // Incremento contador
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        // Crea objeto ventana (Scene)
        Scene scene = new Scene(root, 400, 350); // Por defecto (300,250) --> Juego un poco con tamanio.
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}  // Fin de funcion start
