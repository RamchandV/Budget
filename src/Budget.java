import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class Budget extends JFrame {
	File profile; 
	private JPanel openProgramWindow;
	private JLabel welcomeLabel;
	//private JTextField textField;
	private JButton newProfileButton, loadProfileButton; 
	int WINDOW_WIDTH = 450;
	int WINDOW_HEIGHT = 600;
	
	public Budget() {
		setTitle("Dodongos' Budget Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openProgramWindow();
		add(openProgramWindow);
		setVisible(true);
	}
	
	public void openProgramWindow() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		newProfileButton = new JButton("New Profile");
		loadProfileButton = new JButton("Load Profile");
		newProfileButton.addActionListener(new newProfileListener());
		loadProfileButton.addActionListener(new loadProfileListener());
		openProgramWindow = new JPanel();
		openProgramWindow.add(welcomeLabel);
		openProgramWindow.add(newProfileButton);
		openProgramWindow.add(loadProfileButton);
	}
	
	private class newProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NewWindow newProfile = new NewWindow("newProfile", profile);
		}
	}
	
	private class loadProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NewWindow loadProfile = new NewWindow("loadProfile", profile);
		}
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


