import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.SwingConstants;

public class BMI_05_GUISwing_NoValidation
{
	private JFrame window;
	private JButton btnCalculate;
	private JTextField txtHeight;
	private JTextField txtWeight;

	private final double INVALID_USER_NUMBER = -1;

	//purpose: Need to construct a BMI_05_GUISwing_NoValidation object.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A BMI_05_GUISwing_NoValidation object has been created.
	public BMI_05_GUISwing_NoValidation()
	{
		window = createJFrame();
		JPanel panel = createJPanel();
		//Add panel to window; show the window.
		window.getContentPane().add(panel);
		window.pack();
		window.setVisible(true);
	}

	//purpose: Need to create an application window.
	//assumptions: None.
	//inputs: None.
	//post-conditions: Returns an application window.
	private JFrame createJFrame()
	{
		JFrame window = new JFrame("BMI Calculator");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return window;
	}

	//purpose: Need to create the user controls for this application.
	//assumptions: None.
	//inputs: None.
	//post-conditions: Returns a JPanel object that contains all of the user controls.
	private JPanel createJPanel()
	{
		final int WIDTH = 10;
		final String BTN_CALC = "Calculate";
		final String LBL_WEIGHT = "Weight:";
		final String LBL_HEIGHT = "Height:";

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout (new BoxLayout (mainPanel, BoxLayout.Y_AXIS));

		//Create label and text field for weight.
		JPanel weightPanel = new JPanel();
		weightPanel.setLayout (new BoxLayout (weightPanel, BoxLayout.X_AXIS));
		JLabel lblWeight = new JLabel(LBL_WEIGHT);
		txtWeight = new JTextField(WIDTH);
		weightPanel.add(lblWeight);
		weightPanel.add(txtWeight);

		//Create label and text field for height.
		JPanel heightPanel = new JPanel();
		heightPanel.setLayout (new BoxLayout (heightPanel, BoxLayout.X_AXIS));
		JLabel lblHeight = new JLabel(LBL_HEIGHT);
		txtHeight = new JTextField(WIDTH);
		heightPanel.add(lblHeight);
		heightPanel.add(txtHeight);

		//Create button and listener.
		btnCalculate = new JButton(BTN_CALC);
		ButtonListener listener = new ButtonListener();
		btnCalculate.addActionListener(listener);

		//Add weight panel, height panel, button, and bmi label to the main panel
		mainPanel.add(weightPanel);
		mainPanel.add(heightPanel);
		mainPanel.add(btnCalculate);

		return mainPanel;
	}

	//A nested class used only by this BMI_05_GUISwing_NoValidation class.
	private class ButtonListener implements ActionListener
	{
		//purpose: React to user clicking on a buttom.
		//assumptions: User has clicked on the Calculate button.
		//inputs: None.
		//post-conditions: A popup message has been displayed.
		//      - When no validation errors, display the BMI category.
		//      - When validation errors, display error message(s).
		public void actionPerformed (ActionEvent event)
		{
			String actionCmd, errorMsg;
			final String ERROR_MSG_UNKNOWN = "Logic error in program, an unknown user command was initiated";

			errorMsg = "";
			actionCmd = event.getActionCommand();

			if (! actionCmd.equals(btnCalculate.getActionCommand()))
				//This error should never happen!
				errorMsg = ERROR_MSG_UNKNOWN;

			//Did any errors occur?
			if (errorMsg.length() > 0)
				//Display errors to user.
				JOptionPane.showMessageDialog(window, errorMsg, "Data Entry Error", JOptionPane.ERROR_MESSAGE);
			else
			{
				//Allow user to only exit this application.
				btnCalculate.setEnabled(false);
				txtHeight.setEnabled(false);
				txtWeight.setEnabled(false);
				//Display the BMI category.
				BMI_04_SeparateClass bmi = new BMI_04_SeparateClass(Double.valueOf(txtWeight.getText()), Double.valueOf(txtHeight.getText()));
				JOptionPane.showMessageDialog(window, bmi.getBMICategory(), "BMI Category", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
