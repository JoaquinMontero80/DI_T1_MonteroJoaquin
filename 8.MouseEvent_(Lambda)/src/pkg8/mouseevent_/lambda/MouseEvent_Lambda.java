/*
    Joaquin Montero. 2ºDAM. DI --> T1A8
    Ejercicio Expresiones Lambda. MouseEvent. 
    Programa con texto en escena, al dejar click de raton presionado
        puedes mover el texto por la pantalla.

    Fuente : https://docs.oracle.com/javase/8/javafx/api/javafx/scene/input/MouseEvent.html
 */
package pkg8.mouseevent_.lambda;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author joaquin
 */
public class MouseEvent_Lambda extends Application {
    
     // Atributos 
    //  (sceneX, sceneY)  -->  en relación con el origen del Scene que contiene el nodo
    double sceneX;
    double sceneY;
    // (screenX,screenY)  --> en relación con el origen de la pantalla que contiene el puntero del mouse.
    double screenX;
    double screenY;
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Crea objeto StackPane
        StackPane root = new StackPane();
        
        // Crea escena --> aniade (StackPane, 300x250 de tamanio )
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("MouseEvent");  // Titulo
        primaryStage.setScene(scene);  // Aniade escena
        primaryStage.show();  // Muestra
        
        // Crea texto que será el que moveremos con ratón
        Text texto = new Text("Programming is fun");
    /*   
        // Metodo agarra texto con click de raton
        texto.setOnMousePressed(new EventHandler<MouseEvent>()  // API --> Este evento ocurre cuando se presiona el botón del mouse.
        {
           public void handle(MouseEvent t)
           {
               
           }
        });   // Fin de metodo 
            
    */
        
    }  // Fin de metodo start
           
    
}   // Fin de clase
