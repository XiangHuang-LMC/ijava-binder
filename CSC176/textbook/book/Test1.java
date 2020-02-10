import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class Test1 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {   
    Pane pane = new Pane();
    Circle c = new Circle();
    c.setRadius(40); c.setCenterX(150); c.setCenterY(100);
    pane.getChildren().add(c);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 300, 200);
    primaryStage.setTitle("Test1"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    c.centerXProperty().bind(pane.widthProperty().divide(2));
    c.centerYProperty().bind(pane.heightProperty().divide(2));
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}