/*
    Joaquin Montero. 2ºDAM --> DI T1A10
        Programa crea circulo y rectangulo en borde de circulo. Gira a 4000ms,
        al hacer click pausa el movimiento giratorio.
 */
package pkg10_pathtransition_in_animation;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author joaquin
 */
public class PathTransition_In_Animation extends Application {
    
    @Override
    public void start(Stage primaryStage)
    {
        //Crea la ventana de tipo Pane
        Pane ventana = new Pane();
      
        // Crea objeto escena
        Scene scene = new Scene(ventana, 300, 300);
        primaryStage.setTitle("PathTransition"); // Titulo
        primaryStage.setScene(scene);  // Aniade escena
        primaryStage.show();  // Muestra
        
        
        //Crea el circulo
        Circle circulo = new Circle(150,150,60, Color.RED);  // Uso constructor ( double centerX, double centerY, Paint fill )
        circulo.setStroke(Color.BLACK);   // Borde de circulo color negro
        ventana.getChildren().add(circulo);  // Aniado
        
        //Crea el rectangulo
        Rectangle rectangulo = new Rectangle(30,60, Color.ORANGE);   // Constructor ( double, double, Paint fill )
        rectangulo.setStroke(Color.BLACK);  // Borde del rectangilo color negro
        ventana.getChildren().add(rectangulo);
    
        // Creo PathTransition
        PathTransition pt = new PathTransition();
        
        pt.setDuration(Duration.millis(4000));  // Establece el tiempo
        pt.setPath(circulo);   // Incluye circulo
        pt.setNode(rectangulo);  // Incluye rectangulo
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);  // Orientacion
        pt.setCycleCount(Timeline.INDEFINITE);  // Tiempo que se para ( indefinido ) 
        pt.setAutoReverse(true);  // Boolena por defecto(false)--> Revierte la animacion al llegar al inicio
        pt.play(); // Start animation
        circulo.setOnMousePressed(e -> pt.pause()); // Pausa imagen al hacer click de raton
        circulo.setOnMouseReleased(e -> pt.play()); // Continua al soltar click del raton
        
        
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}