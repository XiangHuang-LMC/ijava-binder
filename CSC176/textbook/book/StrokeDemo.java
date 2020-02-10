import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class StrokeDemo extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) { 
    RectangleBuilder rectangleBuilder = RectangleBuilder.create()
      .x(20).y(20).width(70).height(120).fill(Color.WHITE)
      .strokeWidth(15).stroke(Color.ORANGE);

    Rectangle rectangle1 = rectangleBuilder.build();
    
    Rectangle rectangle2 = rectangleBuilder.build();
    rectangle2.setTranslateX(100);
    rectangle2.setStrokeLineJoin(StrokeLineJoin.BEVEL);
    
    Rectangle rectangle3 = rectangleBuilder.build();
    rectangle3.setTranslateX(200);
    rectangle3.setStrokeLineJoin(StrokeLineJoin.ROUND);
       
    Line line1 = new Line(320, 20, 420, 20);
    line1.setStrokeLineCap(StrokeLineCap.BUTT);
    line1.setStrokeWidth(20);
    
    Line line2 = new Line(320, 70, 420, 70);
    line2.setStrokeLineCap(StrokeLineCap.ROUND);
    line2.setStrokeWidth(20);
    
    Line line3 = new Line(320, 120, 420, 120);
    line3.setStrokeLineCap(StrokeLineCap.SQUARE);
    line3.setStrokeWidth(20);

    Line line4 = new Line(460, 20, 560, 120);
    line4.getStrokeDashArray().addAll(10.0, 20.0, 30.0, 40.0);
   
    Pane pane = new Pane();
    pane.getChildren().addAll(rectangle1, rectangle2, rectangle3,
      line1, line2, line3, line4);

    Scene scene = new Scene(pane, 610, 180);           
    primaryStage.setTitle("StrokeDemo"); // Set the window title
    primaryStage.setScene(scene); // Place the scene in the window
    primaryStage.show(); // Display the window
  }

  // Lauch the program from command-line
  public static void main(String[] args) {
    launch(args);
  }
}


