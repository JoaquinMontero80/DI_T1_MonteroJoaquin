/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg13.using_gridpane;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author joaquin
 */
public class Using_GridPane extends Application {
    
     @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Controls Layout ");
        Group root = new Group();
        Scene scene = new Scene(root, 380, 118, Color.WHITE);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        Label textoNombre = new Label("NOMBRE : ");
        TextField cuadroNombre = new TextField();
        Label textoApellido = new Label("APELLIDO : ");
        TextField cuadroApellido = new TextField();
        Button guardar = new Button("GUARDAR");
        
        // First name label
        GridPane.setHalignment(textoNombre, HPos.RIGHT);
        gridpane.add(textoNombre, 0, 0);
        
        
        // Last name label
        GridPane.setHalignment(textoApellido, HPos.RIGHT);
        gridpane.add(textoApellido, 0, 1);
        
        // First name field
        GridPane.setHalignment(cuadroNombre, HPos.LEFT);       
        gridpane.add(cuadroNombre, 1, 0);
        
        // Last name field
        GridPane.setHalignment(cuadroApellido, HPos.LEFT);
        gridpane.add(cuadroApellido, 1, 1);

        // Save button
        GridPane.setHalignment(guardar, HPos.RIGHT);
        gridpane.add(guardar, 1, 2);
        
        root.getChildren().add(gridpane);        
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }  // Fin de metodo start
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}  // Fin de clase 