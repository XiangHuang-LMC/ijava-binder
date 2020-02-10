import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.KeyCode;

public class Test2 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    Circle circle = new Circle(50);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);
    pane.getChildren().add(circle);
    
    HBox hBox = new HBox();
    hBox.setSpacing(10);
    hBox.setAlignment(Pos.CENTER);
    Button btEnlarge = new Button("Enlarge");
    
    btEnlarge.setOnAction(e -> {circle.setRadius(circle.getRadius() + 1);});
    Button btShrink = new Button("Shrink");
    btShrink.setOnAction(e -> {circle.setRadius(circle.getRadius() - 1);});

    circle.setOnMouseClicked(e -> {
      if (e.getButton() == MouseButton.PRIMARY)
        circle.setRadius(circle.getRadius() + 1);
      else if (e.getButton() == MouseButton.SECONDARY)
        circle.setRadius(circle.getRadius() - 1);
    });
    
    circle.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.U) {
        circle.setRadius(circle.getRadius() + 1);
      }
      else if (e.getCode() == KeyCode.D) {
        circle.setRadius(circle.getRadius() - 1);
      }
    });
    
    hBox.getChildren().add(btEnlarge);
    hBox.getChildren().add(btShrink);

    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(hBox);
    BorderPane.setAlignment(hBox, Pos.CENTER);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 200, 150);
    primaryStage.setTitle("ControlCircle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    circle.requestFocus();
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}