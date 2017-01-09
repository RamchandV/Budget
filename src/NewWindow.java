import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NewWindow extends JFrame {
	private JPanel windowPanel;
	private JLabel windowLabel;
	private JButton addBillButton, removeBillButton, doneButton;
	private File profile; 
	
	public NewWindow(String windowType, File profileIn) {
		profile = profileIn;
		switch(windowType){
		case "newProfile":
			setTitle("New Profile");
			setSize(400, 400);
			newProfileWindow();
			add(windowPanel);
			setVisible(true);
			break;
		case "billsView":
			setTitle("View Bills");
			setSize(300, 350);
			billsViewWindow();
			add(windowPanel);
			setVisible(true);
			break;
		}
	}
	
	public void newProfileWindow() {
		ProfileName name = new ProfileName(profile);
		IncomePanel income = new IncomePanel(profile);
		windowLabel = new JLabel("Please enter your new profile details:");
		windowPanel = new JPanel();
		GridLayout layout = new GridLayout(7,1);
		layout.setVgap(10);
		windowPanel.setLayout(layout);
		windowPanel.add(windowLabel);
		windowPanel.add(name);
		windowPanel.add(income);
	}
	
	public void billsViewWindow() {
		JPanel billsList = createBillsList();
		//create components
		windowLabel = new JLabel("Bills details:");
		addBillButton = new JButton("Add");
		doneButton = new JButton("Done");
		windowPanel = new JPanel();
		//create button listener links
		addBillButton.addActionListener(new addBillButtonListener(profile));
		doneButton.addActionListener(new doneBillsButtonListener(profile));	
		//add components
		windowPanel.add(windowLabel);
		windowPanel.add(billsList);
		windowPanel.add(addBillButton);
		windowPanel.add(doneButton);
	}
	
	public JPanel createBillsList() {
		HashMap<String, String> billsMap = BillsFunctions.getCurrentBills(profile);
		JPanel list = new JPanel();
		list.setLayout(new GridLayout(billsMap.size(),3));
		for(Map.Entry<String, String> entry : billsMap.entrySet()) {
			removeBillButton = new JButton("Remove");
			removeBillButton.addActionListener(new removeBillButtonListener(profile));
			JLabel name = new JLabel(entry.getKey());
			list.add(name);
			JTextField amount = new JTextField(entry.getValue());
			list.add(amount);
			list.add(removeBillButton);
		}
		return list;
	}
	
	private class addBillButtonListener implements ActionListener {
		private File profile;
		public addBillButtonListener(File profileIn) {
			profile = profileIn;
		}
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class removeBillButtonListener implements ActionListener {
		private File profile;
		public removeBillButtonListener(File profileIn) {
			profile = profileIn;
		}
		
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class doneBillsButtonListener implements ActionListener {
		private File profile;
		public doneBillsButtonListener(File profileIn) {
			profile = profileIn;
		}
		
		public void actionPerformed(ActionEvent e) {

		}
	}
}


