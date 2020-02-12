import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ABA_OOD_B_viewGUI_Contact extends JDialog implements ActionListener, WindowListener
{
	private ABA_OOD_B_viewGUI gui;
	private boolean addContact;
	private JButton btnOkay;
	private JButton btnCancel;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JLabel lblMessage;

	private final String OKAY = "Ok";
	private final String CANCEL = "Cancel";
	private final String LBL_NAME = "Name:";
	private final String LBL_PHONE = "Phone:";
	private final String LBL_EMAIL = "EMail:";
	private final String EMPTY_STRING = "";
	private final int TXT_WIDTH = 30;

	//purpose: 
	//assumptions: 
	//inputs: 
	//post-conditions: 
	public ABA_OOD_B_viewGUI_Contact(ABA_OOD_B_viewGUI gui)
	{
		this.gui = gui;
		this.addContact = true;

		createControls();
		showDialog();
	}

	//purpose: 
	//assumptions: 
	//inputs: 
	//post-conditions: 
	public ABA_OOD_B_viewGUI_Contact(ABA_OOD_B_viewGUI gui, ABA_OOD_contactData data)
	{
		this.gui = gui;
		this.addContact = false;

		createControls();

		txtName.setText(data.getName());
		txtPhone.setText(data.getPhone());
		txtEmail.setText(data.getEmail());

		btnCancel.setEnabled(false);

		showDialog();
	}

	//purpose: 
	//assumptions: 
	//inputs: 
	//post-conditions: 
	private void createControls()
	{
		this.setTitle("Contact Data");
		this.addWindowListener(this);
		this.setResizable(false);
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

		//Create JPanel that will contain all of the user controls
		JPanel panelAll = new JPanel();
		panelAll.setPreferredSize(new Dimension(500,150));
		panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));
		//Add this panel to the frame's content pane
		this.getContentPane().add(panelAll);

		JPanel panelFields = createTextFields();
		panelAll.add(panelFields);

		JPanel panelBtns = createButtons();
		panelAll.add(panelBtns);

		lblMessage = new JLabel(EMPTY_STRING, SwingConstants.CENTER);
		panelAll.add(lblMessage);
	}

	//purpose: 
	//assumptions: 
	//inputs: 
	//post-conditions: 
	private void showDialog()
	{
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
		if (cmd.equals(OKAY))
		{
			boolean validAdd = true;
			if (addContact)
				validAdd = createContact();
			if (validAdd)
				exitDialog(validAdd);
		}
		else if (cmd.equals(CANCEL))
			exitDialog(false);
		else
			JOptionPane.showMessageDialog(null, "Unknown command ignored.", "Error", JOptionPane.INFORMATION_MESSAGE);
	}

	//The following methods are needed since this class implements the WindowListener interface.
	//Only the windowClosing event is of interest to this application.
	public void windowActivated(WindowEvent event) { }
	public void windowClosed(WindowEvent event) { }
	public void windowClosing(WindowEvent event) { exitDialog(false); }
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
		//Create JPanel that will contain the buttons
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		btnOkay = new JButton(OKAY);
		btnCancel = new JButton(CANCEL);

		btnOkay.addActionListener(this);
		btnCancel.addActionListener(this);

		panel.add(btnOkay);
		createSpacing(panel, false, 10);
		panel.add(btnCancel);

		return panel;
	}

	//purpose: Create labels/text boxes for the application.
	//assumptions: None.
	//inputs: None.
	//post-conditions: A JPanel contains three label/textBox pairs of user controls.
	private JPanel createTextFields()
	{
		//Create JPanel that will contain the labels and text fields
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		txtName = new JTextField(TXT_WIDTH);
		txtPhone = new JTextField(TXT_WIDTH);
		txtEmail = new JTextField(TXT_WIDTH);

		setTextFieldsEditable();

		Dimension dim = txtName.getPreferredSize();
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

	//purpose: User wants to create a new contact.
	//assumptions: None.
	//inputs: None.
	//post-conditions: New contact has been created OR an error message is displayed.
	private boolean createContact()
	{
		boolean validAdd = false;

		final String CREATED_CONTACT = "New contact has been created.";
		final String DUP_CONTACT = "Contact not added, name already exists in address book.";
		final String INVALID_NAME_PHONE = "Name and phone are invalid, contact NOT added to address book.";
		final String INVALID_NAME = "Name is invalid, contact NOT added to address book.";
		final String INVALID_PHONE = "Phone is invalid, contact NOT added to address book.";

		ABA_OOD_contactData data = new ABA_OOD_contactData(txtName.getText(), txtPhone.getText(), txtEmail.getText());
		ABA_OOD_viewMessage msg = gui.addContact(data);
		System.out.println("createContact msg=" + msg);
		if (msg.isCreatedContact())
		{
			System.out.println("createContact msg is created contact");
			validAdd = true;
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

		return validAdd;
	}

	//purpose: Exit the simulator.
	//assumptions: None.
	//inputs: None.
	//post-conditions: None.
	private void exitDialog(boolean refreshContactList)
	{
		if (refreshContactList)
			gui.refreshContactList();

		this.setVisible(false);
	}

	//purpose:
	//assumptions:
	//inputs:
	//post-conditions: When adding a contact, the three text fields are editable.
	//					When displaying a contact, the three text fields are NOT editable.
	private void setTextFieldsEditable()
	{
		txtName.setEditable(addContact);
		txtPhone.setEditable(addContact);
		txtEmail.setEditable(addContact);
	}
}
