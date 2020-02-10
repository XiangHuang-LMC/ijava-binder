
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ImagePatternDemo extends Application {
  private static final String imageURL =
    "http://www.cs.armstrong.edu/liang/common/image/ohioMap.gif";

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    Pane pane = new Pane();

    Rectangle rectangle1 = new Rectangle(10, 10, 50, 50);
    Rectangle rectangle2 = new Rectangle(70, 10, 50, 50);
    Rectangle rectangle3 = new Rectangle(130, 10, 50, 50);
    Rectangle rectangle4 = new Rectangle(190, 10, 50, 50);

    Image image = new Image(imageURL);
    rectangle1.setFill(new ImagePattern(image, 0, 0, 1, 1, true));
    rectangle2.setFill(new ImagePattern(image, 0, 0, 0.5, 0.5, true));
    rectangle3.setFill(new ImagePattern(image, 0, 0, 50, 50, false));
    rectangle4.setFill(new ImagePattern(image, 0, 0, 25, 25, false));
    
    pane.getChildren().addAll(rectangle1, rectangle2, 
      rectangle3, rectangle4);
    Scene scene = new Scene(pane, 300, 250);           
    primaryStage.setTitle("ImagePatternDemo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  // Lauch the program from command-line
  public static void main(String[] args) {
    launch(args);
  }
}
