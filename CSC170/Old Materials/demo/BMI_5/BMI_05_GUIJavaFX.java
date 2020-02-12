import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BMI_05_GUIJavaFX extends Application
{
	private Stage primaryWindow;
	private Button btnCalculate;
	private TextField txtHeight;
	private TextField txtWeight;
	private final double INVALID_USER_NUMBER = -1;
	private final String NEWLINE = "\n";

	public void start(Stage primaryWindow)
	{
		//Save primary window for use by dialog window.
		this.primaryWindow = primaryWindow;
		//Create a window pane that contains all of the UI controls.
		Pane pane = createPane();
		//Create a scene that contains the window pane.
		Scene scene = new Scene(pane);
		//Setup and show the primary window.
		primaryWindow.setTitle("BMI Calculator");
		primaryWindow.setScene(scene);
		primaryWindow.setMaxWidth(400.0);
		primaryWindow.setMinWidth(400.0);
		primaryWindow.show();
	}

	//pre:  Need to create the user controls for this application.
	//post: Returns a Pane object that contains all of the user controls.
	private Pane createPane()
	{
		final int WIDTH = 10;
		final String BTN_CALC = "Calculate";
		final String LBL_WEIGHT = "Weight:";
		final String LBL_HEIGHT = "Height:";

		//Create label and text field for weight.
		HBox weightPane = new HBox();
		weightPane.setAlignment(Pos.BASELINE_CENTER);
		Label lblWeight = new Label(LBL_WEIGHT);
		txtWeight = new TextField();
		weightPane.getChildren().addAll(lblWeight, txtWeight);

		//Create label and text field for height.
		HBox heightPane = new HBox();
		heightPane.setAlignment(Pos.BASELINE_CENTER);
		Label lblHeight = new Label(LBL_HEIGHT);
		txtHeight = new TextField();
		heightPane.getChildren().addAll(lblHeight, txtHeight);

		//Create button and handler.
		HBox btnPane = new HBox();
		btnPane.setAlignment(Pos.BASELINE_CENTER);
		btnCalculate = new Button(BTN_CALC);
		btnCalculate.setOnAction(new CalcButtonHandler());
		btnCalculate.setDefaultButton(true);
		btnPane.getChildren().addAll(btnCalculate);

		//Add weight, height and button to the main pane.
		VBox mainPane = new VBox();
		mainPane.getChildren().addAll(weightPane, heightPane, btnPane);

		return mainPane;
	}

	//pre: Need to show a pop-up window.
	//post: Pop-up has been displayed and closed.
	private void showMsg(String msg, String title)
	{
		//Create a dialog box window.
		Stage dialog = new Stage();
		//Setup the dialog box.
		dialog.setTitle(title);
		dialog.setMaxWidth(300.0);
		dialog.setMinWidth(300.0);
		dialog.initOwner(primaryWindow);
		dialog.initModality(Modality.WINDOW_MODAL);
		//Center the msg in the dialog box.
		HBox pane = new HBox();
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.getChildren().addAll(new Label(NEWLINE + msg));
		//Add pane to new scene and then add scene to the dialog box.
		dialog.setScene(new Scene(pane));
		//Show the dialog box.
		dialog.show();
	}

	//pre: User has clicked on the Calculate button.
	//post: A popup message has been displayed.
	//      - When no validation errors, display the BMI category.
	//      - When validation errors, display error message(s).
	private class CalcButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			double weight, height;
			String actionCmd, errorMsg;

			weight = Double.valueOf(txtWeight.getText());
			height = Double.valueOf(txtHeight.getText());

			//Allow user to only exit this application.
			btnCalculate.setDisable(true);
			txtHeight.setDisable(true);
			txtWeight.setDisable(true);
			//Display the BMI category.
			BMI_04_SeparateClass bmi = new BMI_04_SeparateClass(weight, height);
			showMsg(bmi.getBMICategory(), "BMI Category");
		} //end of handler method
	} //end of inner class
}
