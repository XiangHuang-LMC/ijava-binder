import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ABA_OOD_A_viewGUI extends JFrame implements ActionListener, WindowListener
{
	private ABA_OOD_A_view view;
//	private JButton btnClear;
//	private JButton btnCreate;
//	private JButton btnDisplay;
//	private JButton btnExit;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JLabel lblMessage;

	private final String CLEAR_CONTACT = "Clear Contact";
	private final String CREATE_CONTACT = "Create Contact";
	private final String DISPLAY_CONTACT = "Display Contact";
	private final String EXIT_ABA = "Exit";
	private final String LBL_NAME = "Name:";
	private final String LBL_PHONE = "Phone:";
	private final String LBL_EMAIL = "EMail:";
	private final String EMPTY_STRING = "";
	private final int TXT_WIDTH = 30;

	public ABA_OOD_A_viewGUI(ABA_OOD_A_view view)
	{
		this.view = view;
		this.setTitle("Address Book Application");
		this.addWindowListener(this);
		this.setResizable(false);

		//Create JPanel that will contain all of the user controls
		JPanel panelAll = new JPanel();
		panelAll.setPreferredSize(new Dimension(600,150));
		panelAll.setLayout(new BorderLayout());
		//Add this panel to the frame's content pane
		this.getContentPane().add(panelAll);

		JPanel panelBtns = createButtons();
		panelAll.add(panelBtns, BorderLayout.WEST);

		panelAll.add(Box.createVerticalStrut(20), BorderLayout.CENTER);

		JPanel panelFields = createTextFields();
		panelAll.add(panelFields, BorderLayout.EAST);

		lblMessage = new JLabel(EMPTY_STRING, SwingConstants.CENTER);
		panelAll.add(lblMessage, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}

	//purpose: React to user actions in this window.
	//assumptions: None.
	//inputs: event - the user action.
	//post-conditions: performs the request action.
	public void actionPerformed(ActionEvent event)
	{
		String cmd = event.getActionCommand();
		if (cmd.equals(CREATE_CONTACT))
			createContact();
		else if (cmd.equals(DISPLAY_CONTACT))
			displayContact();
		else if (cmd.equals(CLEAR_CONTACT))
			clearContact();
		else if (cmd.equals(EXIT_ABA))
			exitABA();
		else
			JOptionPane.showMessageDialog(null, "Unknown command ignored.", "Error", JOptionPane.INFORMATION_MESSAGE);
	}

	//The following methods are needed since this class implements the WindowListener interface.
	//Only the windowClosing event is of interest to this application.
	public void windowActivated(WindowEvent event) { }
	public void windowClosed(WindowEvent event) { }
	public void windowClosing(WindowEvent event) { exitABA(); }
	public void windowDeactivated(WindowEvent event) { }
	public void windowDeiconified(WindowEvent event) { }
	public void windowIconified(WindowEvent event) { }
	public void windowOpened(WindowEvent event) { }

	//purpose: Create push buttons for the application.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A JPanel contains three push buttons.
	private JPanel createButtons()
	{
		System.out.println("createButtons()");

		//Create JPanel that will contain the three buttons
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnCreate = new JButton(CREATE_CONTACT);
		JButton btnDisplay = new JButton(DISPLAY_CONTACT);
		JButton btnClear = new JButton(CLEAR_CONTACT);
		JButton btnExit = new JButton(EXIT_ABA);

		btnCreate.addActionListener(this);
		btnDisplay.addActionListener(this);
		btnClear.addActionListener(this);
		btnExit.addActionListener(this);

		panel.add(btnCreate);
		createSpacing(panel, true, 10);
		panel.add(btnDisplay);
		createSpacing(panel, true, 10);
		panel.add(btnClear);
		createSpacing(panel, true, 10);
		panel.add(btnExit);

		return panel;
	}

	//purpose: Create labels/text boxes for the application.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A JPanel contains three label/textBox pairs of user controls.
	private JPanel createTextFields()
	{
		System.out.println("createTextFields()");

		//Create JPanel that will contain the labels and text fields
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		txtName = new JTextField(TXT_WIDTH);
		txtPhone = new JTextField(TXT_WIDTH);
		txtEmail = new JTextField(TXT_WIDTH);

		Dimension dim = txtName.getPreferredSize();
		System.out.println(dim);
		txtName.setMaximumSize(dim);
		txtPhone.setMaximumSize(dim);
		txtEmail.setMaximumSize(dim);

		panel.add(createLblTxtPair(new JLabel(LBL_NAME), txtName));
		createSpacing(panel, true, 10);
		panel.add(createLblTxtPair(new JLabel(LBL_PHONE), txtPhone));
		createSpacing(panel, true, 10);
		panel.add(createLblTxtPair(new JLabel(LBL_EMAIL), txtEmail));

		return panel;
	}

	//purpose: Create a label and its corresponding text box.
	//assumptions: None.
	//inputs: lbl - the label object.
	//		    txt - the text box object.
	//post-conditions: A JPanel contains the label/text box pair of user controls.
	private JPanel createLblTxtPair(JLabel lbl, JTextField txt)
	{
		//Create JPanel that will contain one label and its correspondign text field
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		panel.add(lbl);
		panel.add(txt);

		return panel;
	}

	//purpose: Add a vertical or horizontal strut to a panel.
	//assumptions: None.
	//inputs: panel - panel that will have a struct added to it.
	//			vertical - when true: add a vertical strut. Otherwise, add a horizontal strut.
	//			size - the height (vertical) or width( horizontal) size of the strut.
	//post-conditions: panel not contains a strut.
	private void createSpacing(JPanel panel, boolean vertical, int size)
	{
		if (vertical)
			panel.add(Box.createVerticalStrut(size));
		else
			panel.add(Box.createHorizontalStrut(size));
	}

	private void clearContact()
	{
		txtName.setText(EMPTY_STRING);
		txtPhone.setText(EMPTY_STRING);
		txtEmail.setText(EMPTY_STRING);
		lblMessage.setText(EMPTY_STRING);
	}

	//purpose: User wants to create a new contact.
	//assumptions: None.
	//inputs: None.
	//post-conditions: New contact has been created OR an error message is displayed.
	private void createContact()
	{
//		final String MISSING_DATA = "Must enter a name, phone number, and email address to create a contact.";
		final String CREATED_CONTACT = "New contact has been created.";
		final String DUP_CONTACT = "Contact not added, name already exists in address book.";
		final String INVALID_NAME_PHONE = "Name and phone are invalid, contact NOT added to address book.";
		final String INVALID_NAME = "Name is invalid, contact NOT added to address book.";
		final String INVALID_PHONE = "Phone is invalid, contact NOT added to address book.";

//		if (txtName.getText().equals(EMPTY_STRING) || txtPhone.getText().equals(EMPTY_STRING) ||txtEmail.getText().equals(EMPTY_STRING))
//			lblMessage.setText(MISSING_DATA);
//		else
//		{
		ABA_OOD_contactData data = new ABA_OOD_contactData(txtName.getText(), txtPhone.getText(), txtEmail.getText());
		ABA_OOD_viewMessage msg = view.addContact(data);
		System.out.println("createContact msg=" + msg);
		if (msg.isCreatedContact())
		{
			System.out.println("createContact msg is created contact");
			lblMessage.setText(CREATED_CONTACT);
		}
		else if (msg.isDupContact())
		{
			System.out.println("createContact msg is dup contact");
			lblMessage.setText(DUP_CONTACT);
		}
		else if (msg.isInvalidName() && msg.isInvalidPhone())
		{
			System.out.println("createContact msg is invalid name and phone");
			lblMessage.setText(INVALID_NAME_PHONE);
		}
		else if (msg.isInvalidName())
		{
			System.out.println("createContact msg is invalid name");
			lblMessage.setText(INVALID_NAME);
		}
		else if (msg.isInvalidPhone())
		{
			System.out.println("createContact msg is invalid phone");
			lblMessage.setText(INVALID_PHONE);
		}
		else
		{
			System.out.println("createContact msg is no error");
			lblMessage.setText(EMPTY_STRING);
		}
//		}
	}

	//purpose: Stop the scenario selected by the user.
	//assumptions: None.
	//inputs: None.
	//post-conditions: User can select another scenario or exit simulator.
	private void displayContact()
	{
		final String NOT_FOUND = "Name is not in the address book.";

		ABA_OOD_contactData data = new ABA_OOD_contactData(txtName.getText(), null, null);
		ABA_OOD_viewMessage msg = view.displayContact(data);
		System.out.println("displayContact msg=" + msg);

		if (msg.isNotFound())
		{
			System.out.println("displayContact msg name not found");
			lblMessage.setText(NOT_FOUND);
		}
		else
		{
			System.out.println("displayContact msg is no error");
			lblMessage.setText(EMPTY_STRING);
			data = msg.getData();
			txtName.setText(data.getName());
			txtPhone.setText(data.getPhone());
			txtEmail.setText(data.getEmail());
		}
	}
	
	//purpose: Exit the simulator.
	//assumptions: None.
	//inputs: None.
	//post-conditions: None.
	private void exitABA()
	{
		this.setVisible(false);
		//Tell controller to exit the simulator
		view.exitABA();
	}
}
