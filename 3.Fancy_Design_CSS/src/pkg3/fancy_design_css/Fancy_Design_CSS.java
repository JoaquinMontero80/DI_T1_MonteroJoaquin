/*
    DI. T1_A3. Joaquin Montero. 2ºDAM.
        Ejercicio para dar forma con estilos CSS en ventana ( ejercicio anterior ) 
            Fuente : https://docs.oracle.com/javase/8/javafx/get-started-tutorial/css.htm
 */
package pkg3.fancy_design_css;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author joaquin
 */
public class Fancy_Design_CSS extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        
        // Modifico el contenido inicial de "start()", por defecto el de "Hello World", aniado:
        primaryStage.setTitle("JavaFX Welcome"); // Esta linea + primaryStage.show() que esta debajo
        
        primaryStage.show();
        /*
            Una vez modificado el codigo de "Hello World:
                Ctrl + shift + i  -->   Importa paquetes necesarios al programa
        */
        
        // Agrego código para crear el objeto GridPane
        GridPane grid = new GridPane();  // Crea objeto GridPane
        grid.setAlignment(Pos.CENTER);   // Alinea desde la izquierda al centro objeto GridPane ( grid ) 
        grid.setHgap(10);  // Espacio entre filas 
        grid.setVgap(10);  // Espacio entre columnas
        grid.setPadding(new Insets(25, 25, 25, 25)); // Gestiona espacio entre bordes del panel ( arr, dcha, debajo e izda )

        // Crea panel de cuadricula, si cambia tamanio, los nodos internos cambian acordemente
        Scene scene = new Scene(grid, 300, 275);  // Ancho 300, altura 275. ( si no se especifica, tamanio minimo ) 
        primaryStage.setScene(scene); 
// -->  Aqui aniado la hoja de estilos CSS
        scene.getStylesheets().add
        (Fancy_Design_CSS.class.getResource("ArchivoCSS.css").toExternalForm());  // Nombre de mi clase + nombre del archivo CSS
        primaryStage.show();

        /*Aniade nombre de la ventana, campo
        usuario y campo contrasenia*/
        Text scenetitle = new Text("Welcome");  // Crea el nombre de la ventana
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));  // Establece : fuente, peso y tamanio de letras.
       // Agrega al metodo grid ( variable scenetitle )
        grid.add(scenetitle, 0, 0, 2, 1);  // Comienza en 0,0 - termina en 2,1

        Label userName = new Label("User Name : ");  // Crea objeto Label donde insertamos nombre de usuario.
        grid.add(userName, 0, 1);  //  ( columna 0, fila 1 )

        // Cuadricula donde usuario introduce el texto
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1); // ( columna 1, fila 1 )

        // Cuadricula donde usuario introduce contrasenia
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        // Agrega boton y texto
        Button btn = new Button("Sign in");  // Crea objeto button con etiqueta "sign in"
        HBox hbBtn = new HBox(10);  // Crea panel HBox con un espacio de 10px
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT); // La propiedad alignment tiene un valor de Posicion --> BOTTOM_RIGHT
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);  // Agrega a la cuadricula columna 1, fila 4.
        
        // Agraga texto para mostrar el mensaje
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        /* Añade un texto al presionar un evento ( en este caso :  boton de login ) */
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
        @Override
        public void handle(ActionEvent e) {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Sign in button pressed");
        }  // Fin de handle
        
        });   // Fin de start
        
        
    }  // Fin de start
    
}  // Fin de clase
