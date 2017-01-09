import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NewProfileWindow extends JFrame {
	private JPanel windowPanel;
	private JLabel windowLabel;
	private JButton billsButton;
	private File profile; 
	
	public NewProfileWindow(File profileIn) {
		profile = profileIn;
		setTitle("Create New Profile:");
		setSize(400, 400);
		setLocationRelativeTo(null);
		newProfileWindow();
		add(windowPanel);
		setVisible(true);
	}
	
	public void newProfileWindow() {
		ProfileName name = new ProfileName(profile);
		IncomePanel income = new IncomePanel(profile);
		billsButton = new JButton("Add Bills");
		billsButton.addActionListener(new addBillButtonListener(profile));
		windowPanel = new JPanel();
		GridLayout layout = new GridLayout(6,1);
		layout.setVgap(10);
		windowPanel.setLayout(layout);
		windowPanel.add(name);
		windowPanel.add(income);
		windowPanel.add(billsButton);
	}
	
	private class addBillButtonListener implements ActionListener {
		private File profile;
		public addBillButtonListener(File profileIn) {
			profile = profileIn;
		}
		
		public void actionPerformed(ActionEvent e) {
			ViewBillsWindow viewWindow = new ViewBillsWindow(profile);
		}
	}
}


