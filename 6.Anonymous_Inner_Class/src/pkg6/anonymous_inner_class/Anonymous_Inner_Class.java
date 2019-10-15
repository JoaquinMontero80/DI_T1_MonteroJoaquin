/*
    Joaquín Montero. 2ºDAM.
      DI. T1 - A6. AnonymousInnerClass
        Programa que crea una escena con 4 botones ( Nuevo, Abrir, Guardar, Imprimir. )
 */
package pkg6.anonymous_inner_class;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author joaquin
 */
public class Anonymous_Inner_Class extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        
        // Creo el contenedor de botones
        HBox hBox = new HBox();  // Creo instancia de HBox
        
        // Crea los 4 botones
        Button btNew = new Button("NUEVO");  // Crea boton con titulo Nuevo
        Button btAbrir = new Button("ABRIR");    // Crea boton con titulo Abrir
        Button btGuardar = new Button("GUARDAR"); // Crea boton con titulo Guardar
        Button btImprimir = new Button("IMPRIMIR"); // crea boton con titulo Imprimir
        
        // Aniade los 4 botones al contenedor hBox 
        hBox.getChildren().add(btNew);  
        hBox.getChildren().add(btAbrir);
        hBox.getChildren().add(btGuardar);  
        hBox.getChildren().add(btImprimir);
        
        // Boton Nuevo
        btNew.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nuevo");
            }
        });
        
        // Boton Abrir
        btAbrir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Abrir");
            }
        });
        
        // Boton Guardar
        btGuardar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Guardar");
            }
        });
        
        // Boton Imprimir
        btImprimir.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Imprimir");
            }
        });
        
        Scene scene = new Scene(hBox, 400, 250);   // Crea la caja/escena
        primaryStage.setTitle("AnonymousHandlerDemo");  // Titulo de caja
        primaryStage.setScene(scene);   // Aniado escena 
        primaryStage.show();    // Muestra escena
        
        hBox.setAlignment(Pos.CENTER);  // Alinea al centro los botones
        hBox.setSpacing(5);  // Espacio entre botones
        
       
    }  // Fin de start

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   // Fin de main
    
    
}   // Fin de clase AnonymousInnerClass