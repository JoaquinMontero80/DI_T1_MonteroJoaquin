/*
    DI_T1_A4. Joaquin Montero. 2ºDAM
        Programa de efectos visuales y animacion
            Fuente : https://docs.oracle.com/javase/8/javafx/get-started-tutorial/animation.htm
 */
package pkg4.color_ful_circles;

import static java.lang.Math.random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author joaquin
 */
public class Color_Ful_Circles extends Application {
    
    @Override 
    public void start (Stage primaryStage) 
    { 
        Group root = new Group (); 
        Scene scene = new Scene (root, 800, 600, Color.BLACK); 
        primaryStage.setScene (scene); 
        
        /* Aniade graficos ( en este caso 30 circulos dentro del bucle for */
        Group circles = new Group();  // Crea grupo Circle */
        /* Agrega 30 circulos desde for */
        for (int i = 0; i < 30; i++) 
        {
            /* Cada circulo tiene un radio de 150, relleno blanco y opacidad 0,05 ( Bastante transparente ) */
            Circle circle = new Circle(150, Color.web("white", 0.05));
            /* Crea un borde alrededor de los circulos (outside es el limite del circulo --> 4 en este caso ( StrokeWidth ) */
            circle.setStrokeType(StrokeType.OUTSIDE);
            /* Color del trazo blanco, nivel opacidad 16( mas brillante que color de circulos ) */
            circle.setStroke(Color.web("white", 0.16));
            /* El limite del circulo ya comentado */
            circle.setStrokeWidth(4);
            /* Agrega el grupo circles al nodo raíz ( de manera temporal ) */
            circles.getChildren().add(circle);
            
        } /* Fin de for */
        
        /* Crea un rectangulo llamado color y lo llena con degradados lineales */
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(), /* Mismo ancho y alto que escena */
        /* Comienza en esquina inferior izquierda (0,1), termina esquina superior derecha (1,0) */
        new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
         Stop[]{ /*  Indica cuál debería ser el color del degradado en un punto en particular. */
            new Stop(0, Color.web("#f8bd55")),
            new Stop(0.14, Color.web("#c0fe56")),
            new Stop(0.28, Color.web("#5dfbc1")),
            new Stop(0.43, Color.web("#64c2f8")),
            new Stop(0.57, Color.web("#be4af7")),
            new Stop(0.71, Color.web("#ed5fc2")),
            new Stop(0.85, Color.web("#ef504c")),
            new Stop(1, Color.web("#f2660f")),}));
        /* El gradiente lineal se ajusta a medida que cambia el tamaño de la escena al vincular el ancho y la altura 
        del rectángulo con el ancho y la altura de la escena */
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());
        
        /* Configura la estructura para mezclar superposicion */
        Group blendModeGroup = 
            new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(),
                Color.BLACK), circles), colors); /* Crea rectangulo (negro) y circulo ya creado previamente */
        colors.setBlendMode(BlendMode.OVERLAY); /* Aplica posicion al color del rectangulo */
        root.getChildren().add(blendModeGroup); /* Agrega escena de hijo, sobre el nodo raiz */
        
        circles.setEffect(new BoxBlur(10, 10, 3));

        /* Aniade animacion ( movimiento de los circulos y rectangulos de la aplicacion )*/
        Timeline timeline = new Timeline(); /* Viene de libreria Random que importa */
        for (Node circle: circles.getChildren()) 
        { 
            /* Agrega 2 cuadrados a cada uno de los 30 circulos */
            timeline.getKeyFrames().addAll
            (
                    /* Establece lineas de tiempo que van desde 0 hasta 40 */
                new KeyFrame(Duration.ZERO, // set start position at 0s
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)
                ),
                new KeyFrame(new Duration(40000), // set end position at 40s
                    new KeyValue(circle.translateXProperty(), random() * 800),
                    new KeyValue(circle.translateYProperty(), random() * 600)
                )
            );
        }
        
        /* Reproduce los 40 segundos de animacion */
        timeline.play();
        
        primaryStage.show (); 
        
    } // Fin de start
 
    public static void main (String [] args) 
    { 
           launch (args); 
    } // Fin de main
    
}  // Fin de clase DI_Animation_AND_VisualEffects
