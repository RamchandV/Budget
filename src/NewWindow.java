import javax.swing.*;

import java.awt.GridLayout;
import java.io.*;

public class NewWindow extends JFrame {
	private JPanel windowPanel;
	private JLabel windowLabel;
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
		case "editProfile":
			setTitle("Load Profile");
			setSize(320, 400);
			loadProfileWindow();
			add(windowPanel);
			setVisible(true);
			break;
		}
	}
	
	public void newProfileWindow() {
		IncomePanel income = new IncomePanel(profile);
		windowLabel = new JLabel("Please enter your new profile details:");
		windowPanel = new JPanel();
		windowPanel.setLayout(new GridLayout(6,1));
		windowPanel.add(windowLabel);
		windowPanel.add(income);
	}
	
	public void loadProfileWindow() {
		windowLabel = new JLabel("Please select a profile from the list below:");
		windowPanel = new JPanel();
		windowPanel.add(windowLabel);
	}
	
	/**
	private class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input;
			double salary;
			
			input = textField.getText();
			salary = Double.parseDouble(input) / 1000;
			//insert to text file to store input
			JOptionPane.showMessageDialog(null, "Your Salary has been stored as $" + salary + "k per year");
		}
	} 
	**/
}


