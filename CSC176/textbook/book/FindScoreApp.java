package chapter39; 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import myWebservice.ScoreWebService;
import myWebservice.ScoreService;

public class FindScoreApp extends Application {
  // Declare a service object and a proxy object
  private ScoreWebService scoreWebService = new ScoreWebService();
  private ScoreService proxy 
    = scoreWebService.getScoreServicePort();

  private Button btGetScore = new Button("Get Score");
  private TextField tfName = new TextField();
  private TextField tfScore = new TextField();

  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.add(new Label("Name"), 0, 0);
    gridPane.add(new Label("Score"), 0, 1);
    gridPane.add(tfName, 1, 0);
    gridPane.add(tfScore, 1, 1);
    gridPane.add(btGetScore, 1, 2);

    // Create a scene and place the pane in the stage
    Scene scene = new Scene(gridPane, 250, 250);
    primaryStage.setTitle("FindScoreApp"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    btGetScore.setOnAction(e -> getScore());
  }

  private void getScore() {
    try {
      // Get student score
      double score = proxy.findScore(tfName.getText().trim());

      // Display the result
      if (score < 0)
        tfScore.setText("Not found");
      else
        tfScore.setText(new Double(score).toString());
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}