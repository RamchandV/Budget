import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

//TODO CHANGE LOAD BUTTON TO BE AN EXPLORER WHERE YOU SELECT THE FILE
public class Budget extends JFrame {
	public File profile; 
	private JMenuBar menuBar = new JMenuBar();
	private JPanel displayWindow, wishlistWindow, paymentsWidnow, billsWindow, profilewelcomeWindow, groceryButton;
	private JLabel welcomeLabel, incomeLabel, salaryLabel, monthlyIncomeLabel, weeklyIncomeLabel, spendingLabel, billsLabel, groceryLabel;
	private JButton newProfileButton, loadProfileButton, clearProfileButton, wishListButton, paymentsButton, billsButton;
	private NewWindow newProfile, loadProfile;
	//private JTextField textField; 
	final int WINDOW_WIDTH = 400;
	final int WINDOW_HEIGHT = 600;
	
	public Budget() {
		setupMenuBar();
		setJMenuBar(menuBar);
		setTitle("Dodongos' Budget Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeWindow();
		add(displayWindow);
		setVisible(true);
	}
	
	public void setupMenuBar() {
		//Initialize Load Profile Options
		ArrayList<String> profilesArray = new ArrayList<String>();
		File dir = new File("C:\\Users\\Dodongos\\git\\Budget");
		File[] profileList = dir.listFiles();		
		for(int i = 0; i < profileList.length-1; i++) {
			if(profileList[i].isFile()) {
				String name = profileList[i].getName();
				if(name.endsWith(".profile")) {
					profilesArray.add(name);
				}
			}
		}
		String[] existingProfiles = new String[profilesArray.size()];
		existingProfiles = profilesArray.toArray(existingProfiles);
		
		//Initialize Menu Bar Dropdowns
		JMenu profileMenu = new JMenu("Profile");
		JMenu loadProfileMenu = new JMenu("Load");
		JMenu editMenu = new JMenu("Edit");
		
		//Initialize Buttons for Dropdowns
		JMenuItem newAction = new JMenuItem("New");
		JMenuItem cutAction = new JMenuItem("Cut");
		JMenuItem copyAction = new JMenuItem("Copy");
		JMenuItem pasteAction = new JMenuItem("Paste");
		
		//Add Profile and Edit to Menu Bar
		menuBar.add(profileMenu);
		menuBar.add(editMenu);
		
		//Add Profile Menu Buttons
		profileMenu.add(newAction);
		profileMenu.add(loadProfileMenu);
		for(final String profileEntry : existingProfiles) {
			loadProfileMenu.add(new JMenuItem(profileEntry.replaceAll(".profile", "")));
		}
		
		//Add Edit Menu Buttons
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		//Link Listeners
		newAction.addActionListener(new newProfileListener());
		for(int i = 0; i < loadProfileMenu.getItemCount(); i++) {
			loadProfileMenu.getItem(i).addActionListener(new loadProfileListener());
		}
	}
	
	public void welcomeWindow() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		displayWindow = new JPanel();
		displayWindow.add(welcomeLabel);
	}
	
	public void profilewelcomeWindow() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		displayWindow = new JPanel();
		displayWindow.add(welcomeLabel);
	}
	
	public void wishlistWindow() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		displayWindow = new JPanel();
		displayWindow.add(welcomeLabel);
	}
	
	public void paymentsWidnow() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		displayWindow = new JPanel();
		displayWindow.add(welcomeLabel);
	}
	
	public void billsWindow() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		displayWindow = new JPanel();
		displayWindow.add(welcomeLabel);
	}
	
	public void groceryButton() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		displayWindow = new JPanel();
		displayWindow.add(welcomeLabel);
	}
		
	private class newProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newProfile = new NewWindow("newProfile", profile);
		}
	}
	
	private class loadProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//loadProfile = new NewWindow("loadProfile", profile);
			/**
			profilewelcomeWindow();
			wishlistWindow();
			paymentsWidnow();
			billsWindow();
			groceryButton();
			Budget.this.add(profilewelcomeWindow);
			Budget.this.add(wishlistWindow);
			Budget.this.add(paymentsWidnow);
			Budget.this.add(billsWindow);
			Budget.this.add(groceryButton);
			setVisible(true);
			**/
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


