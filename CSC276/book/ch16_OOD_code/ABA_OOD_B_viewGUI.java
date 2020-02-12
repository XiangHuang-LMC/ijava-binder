import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.Set;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class ABA_OOD_B_viewGUI extends JFrame implements ActionListener, WindowListener
{
	private ABA_OOD_B_view view;
//	private JButton btnCreate;
//	private JButton btnDisplay;
//	private JButton btnExit;
	private JList<String> lstContactNames;
	private JLabel lblMessage;

	private final String CREATE_CONTACT = "Create";
	private final String DISPLAY_CONTACT = "Display";
	private final String EXIT_ABA = "Exit";
	private final String EMPTY_STRING = "";
	private final int TXT_WIDTH = 30;

	public ABA_OOD_B_viewGUI(ABA_OOD_B_view view)
	{
		this.view = view;
		this.setTitle("Address Book Application");
		this.addWindowListener(this);
		this.setResizable(false);

		//Create JPanel that will contain all of the user controls
		JPanel panelAll = new JPanel();
		panelAll.setPreferredSize(new Dimension(300,600));
		panelAll.setLayout(new BoxLayout(panelAll, BoxLayout.Y_AXIS));
		//Add this panel to the frame's content pane
		this.getContentPane().add(panelAll);

		lstContactNames = new JList<String>();
		lstContactNames.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setView(lstContactNames);
		panelAll.add(scrollPane);

		JPanel panelBtns = createButtons();
		panelAll.add(panelBtns);

		lblMessage = new JLabel(EMPTY_STRING, SwingConstants.CENTER);
		panelAll.add(lblMessage);
		
		this.pack();
		this.setVisible(true);
	}
	
	//purpose: React to user actions in this window.
	//assumptions: None.
	//inputs: event - the user action.
	//post-conditions: performs the request action.
	public void actionPerformed(ActionEvent event)
	{
		final String NO_SELECTION = "Must select a contact name to display.";

		lblMessage.setText(EMPTY_STRING);
		String cmd = event.getActionCommand();
		if (cmd.equals(CREATE_CONTACT))
			showDialog();
		else if (cmd.equals(DISPLAY_CONTACT))
		{
			if (lstContactNames.isSelectionEmpty())
				lblMessage.setText(NO_SELECTION);
			else
			{
				String name = lstContactNames.getSelectedValue();
				ABA_OOD_contactData data = new ABA_OOD_contactData(name, null, null);
				//ABA_OOD_viewRequest request = new ABA_OOD_viewRequest(ABA_OOD_viewRequest.REQUEST.DISPLAY, data);
				ABA_OOD_viewMessage msg = view.displayContact(data);
				if (msg.isNoError())
				{
					data = msg.getData();
					showDialog(data);
				}
			}
		}
		else if (cmd.equals(EXIT_ABA))
			exitABA();
		else
			JOptionPane.showMessageDialog(null, "Unknown command ignored.", "Error", JOptionPane.INFORMATION_MESSAGE);
	}

	//purpose:
	//assumptions:
	//inputs:
	//post-conditions:
	public ABA_OOD_viewMessage addContact(ABA_OOD_contactData data)
	{
		ABA_OOD_viewMessage msg = view.addContact(data);
		return msg;
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
		//Create JPanel that will contain the three buttons
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JButton btnCreate = new JButton(CREATE_CONTACT);
		JButton btnDisplay = new JButton(DISPLAY_CONTACT);
		JButton btnExit = new JButton(EXIT_ABA);

		btnCreate.addActionListener(this);
		btnDisplay.addActionListener(this);
		btnExit.addActionListener(this);

		panel.add(btnCreate);
		createSpacing(panel, true, 10);
		panel.add(btnDisplay);
		createSpacing(panel, true, 10);
		panel.add(btnExit);

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

	private void clearMessage()
	{
		lblMessage.setText(EMPTY_STRING);
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

	//purpose: 
	//assumptions: 
	//inputs: None.
	//post-conditions: 
	public void refreshContactList()
	{
		Set<String> contactNames = view.getContactList();
		DefaultListModel<String> listModel = new DefaultListModel<String>();

		//Put all contact names in the list model
		Iterator<String> iter = contactNames.iterator();
		while (iter.hasNext())
			listModel.addElement(iter.next());

		//Update the JList
		lstContactNames.setModel(listModel);
	}

	//purpose: 
	//assumptions: 
	//inputs: 
	//post-conditions: 
	private void showDialog()
	{
		ABA_OOD_B_viewGUI_Contact dialog = new ABA_OOD_B_viewGUI_Contact(this);
	}

	//purpose: 
	//assumptions: 
	//inputs: 
	//post-conditions: 
	private void showDialog(ABA_OOD_contactData data)
	{
		ABA_OOD_B_viewGUI_Contact dialog = new ABA_OOD_B_viewGUI_Contact(this, data);
	}
}
