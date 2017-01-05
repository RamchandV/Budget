import javax.swing.*;
import java.io.*;

public class NewWindow extends JFrame {
	private JPanel windowPanel;
	private JLabel windowLabel;
	
	public NewWindow(String windowType, File profile) {
		switch(windowType){
		case "newProfile":
			setTitle("New Profile");
			setSize(600, 400);
			newProfileWindow();
			add(windowPanel);
			setVisible(true);
			break;
		case "loadProfile":
			setTitle("Load Profile");
			setSize(320, 400);
			loadProfileWindow();
			add(windowPanel);
			setVisible(true);
			break;
		}
	}
	
	public void newProfileWindow() {
		windowLabel = new JLabel("Please enter your new profile details:");
		windowPanel = new JPanel();
		windowPanel.add(windowLabel);
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


