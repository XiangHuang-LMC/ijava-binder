import java.util.Date;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Temp extends Application {

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane to hold the image views
    Pane pane = new Pane();

    final Label label = new Label();
    pane.getChildren().add(label);


    EventHandler<ActionEvent> h = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        label.setText(" " + new Date());
        System.out.println("called every 1 second on UI thread");
      }
    };
    Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), h));

    fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
    fiveSecondsWonder.play();


    // Create a scene and place it in the stage
    Scene scene = new Scene(pane);
    primaryStage.setTitle("ShowImage"); // Set the stage title
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
