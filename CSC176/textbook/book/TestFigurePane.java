import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class TestFigurePane extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {   
    // Create a pane
    TilePane pane = new TilePane();
    
    FigurePane p = new FigurePane(FigureType.LINE);
    p.setPrefSize(40, 40);
    pane.getChildren().add(p);
    pane.getChildren().add(new FigurePane(FigureType.RECTANGLE));
    pane.getChildren().add(new FigurePane(FigureType.ROUND_RECTANGLE));
    pane.getChildren().add(new FigurePane(FigureType.ELLIPSE));
        
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 300, 200);
    primaryStage.setTitle("TestFigurePane"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
