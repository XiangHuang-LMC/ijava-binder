import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Figure9_1 extends Application { 
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    
    HBox hBox = new HBox(8);
    hBox.setPadding(new Insets(10, 10, 10, 10));
    
    ComboBox<String> cb = new ComboBox<>();
    cb.getItems().addAll("Freshman", "Sophmore");
    
    TextField tf = new TextField();
    tf.setPrefColumnCount(9);
    
    hBox.getChildren().addAll(new Button("OK"), new Button("Cancel"), 
        new Label("Enter Your Name:"), tf, new CheckBox("Bold"),
        new CheckBox("Italic"), new RadioButton("Red"), new RadioButton("Yellow"),
        cb);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(hBox, 650, 100);
    primaryStage.setTitle("Show GUI"); // Set the stage title
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
