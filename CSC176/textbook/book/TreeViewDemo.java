import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    TreeItem<String> root = new TreeItem<>("Country");
    root.setExpanded(true);
    
    TreeItem<String> us = new TreeItem<>("US", 
      new ImageView("image/usIcon.gif"));
    TreeItem<String> uk = new TreeItem<>("UK",
      new ImageView("image/ukIcon.gif"));
    TreeItem<String> france = new TreeItem<>("France");
    
    TreeItem<String> georgia = new TreeItem("Georgia");
    TreeItem<String> floria = new TreeItem("Florida");
    TreeItem<String> alabama = new TreeItem("Alabama");

    root.getChildren().addAll(us, uk, france);
    us.getChildren().addAll(georgia, floria, alabama);
    TreeView<String> tree = new TreeView<>(root);
    tree.setEditable(true);
    
    Scene scene = new Scene(tree, 300, 250);  
    primaryStage.setTitle("TreeViewDemo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   * line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
