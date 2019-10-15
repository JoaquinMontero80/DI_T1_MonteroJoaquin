/*
    Joaquin Montero. 2ºDAM. DI --> T1_A7
        Calculadora de préstamo con expresión Lambda para registrar
        el manejador de eventos del control Button.
            // Fuente : https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/index.html
 */
package pkg7.action_event_.lambda;

import static java.lang.Math.pow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author joaquin
 */
public class Action_Event_Lambda extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    {
        // Creo objeto ventana de tipo GridPane
        GridPane ventana = new GridPane();
        ventana.setHgap(10);  // Distancia 10 de panel desde izquierda
        ventana.setVgap(10); // Distancia 10 de panel desde arriba
        
        // Creo objeto Scene
        Scene escena = new Scene(ventana,300, 250);  // Introduce ventana , 300 x 250
        
        // Introduzco título
        primaryStage.setTitle("ActionEvent");
        primaryStage.setScene(escena);  // Incluyo la escena 
        primaryStage.show();  // Muestra
        
        // Creo 5 Label + 5 TextField  ||   ventana.add (Objeto, columna, fila )
        Label interes = new Label("Interes Anual:");
        ventana.add(interes, 2, 2); // Columna 2 -- fila 2 )
        TextField uno = new TextField();
        ventana.add(uno, 3, 2); // Columna 3 -- fila 2
        
        Label años = new Label("Numero De Años:");
        ventana.add(años, 2, 3);
        TextField dos = new TextField();
        ventana.add(dos, 3, 3);
        
        Label prestamoTotal = new Label("Prestamo Total:");
        ventana.add(prestamoTotal, 2, 4);
        TextField tres = new TextField();
        ventana.add(tres, 3, 4);
        
        Label pagoMensual = new Label("Pago Mensual:");
        ventana.add(pagoMensual, 2, 5);
        TextField cuatro = new TextField();
        ventana.add(cuatro, 3, 5);
        
        Label pagoTotal = new Label("Pago Total:");
        ventana.add(pagoTotal, 2, 6);
        TextField cinco = new TextField();
        ventana.add(cinco, 3, 6);
        
        
        // Creo boton para utilizar logica de cálculo ( columna 3, fila 7 )
        Button calcular = new Button("Calcular:");
        ventana.add(calcular, 3, 7);
        
        // Metodo calcular
        calcular.setOnAction(( javafx.event.ActionEvent e) ->
        {   
            // No realizo control de flujo ( hay que introducir datos correctos )
            double interess = Double.parseDouble(uno.getText());  // Casting de texto 1 introducido a double
            double anio = Double.parseDouble(dos.getText());  // Idem texto2
            double tot = Double.parseDouble(tres.getText());  // Idem texto3
            double im = interess / (100 * 12);  // Interes mensual ( interes / 100% * 12meses ) 
            
            // (prestamoTotal * interesMensual) / (1 - potencia(1+im)(-12) * numero de anios)
            double m = (tot * im) / (1 - pow((1 + im), -12 * anio )); 
            
            // Introduzco resultado en casilla 4
            cuatro.setText(String.format("$"+"%.2f", m));
            
            double totalAños = m * (anio * 12);
            
            // Introduzco resultado en casilla 5
            cinco.setText(String.format("$"+"%.2f", totalAños)); // (xxx.xx, total a pagar)
            
        });  // Fin de metodo calcular
        
    }  // Fin de metodo start

  
    
}  // Fin de clase
