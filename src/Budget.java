import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO CHANGE LOAD BUTTON TO BE AN EXPLORER WHERE YOU SELECT THE FILE
public class Budget extends JFrame {
	public File profile = new File("C:\\Users\\Dodongos\\git\\Budget\\Default.profile"); 
	private JMenuBar menuBar = new JMenuBar();
	private JPanel welcomeWindow, profileWelcomeWindow, incomeWindow, spendingWindow, billsWindow, paymentsWindow, groceryWindow, wishlistWindow; 
	private JLabel welcomeLabel, profileWelcomeLabel, incomeLabel, monthlyIncomeLabel, weeklyIncomeLabel, spendingLabel, billsLabel, paymentsLabel, groceryLabel, wishlistLabel;
	private JButton newProfileButton, loadProfileButton, clearProfileButton, wishListButton, paymentsButton, billsButton;
	private NewWindow newProfile, loadProfile;
	//private JTextField textField; 
	final int WINDOW_WIDTH = 500;
	final int WINDOW_HEIGHT = 700;
	
	public Budget() throws IOException {
		setupMenuBar();
		setJMenuBar(menuBar);
		setTitle("Dodongos' Budget Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLayout(new GridLayout(6,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeWindow();
		//incomeWindow = new IncomePanel(profile);
		add(welcomeWindow);
		//add(incomeWindow);
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
		JMenuItem clearAction = new JMenuItem("Clear");
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
		profileMenu.add(clearAction);
		
		//Add Edit Menu Buttons
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		//Link Listeners
		newAction.addActionListener(new newProfileListener());
		clearAction.addActionListener(new clearActionListener());
		for(int i = 0; i < loadProfileMenu.getItemCount(); i++) {
			loadProfileMenu.getItem(i).addActionListener(new loadProfileListener(loadProfileMenu.getItem(i).getText()));
		}
	}
	
	public void welcomeWindow() {
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		welcomeWindow = new JPanel();
		welcomeWindow.add(welcomeLabel);
	}
	
	public void profileWelcomeWindow() {
		profileWelcomeLabel = new JLabel("Personal Budget Calculator!");
		profileWelcomeWindow = new JPanel();
		profileWelcomeWindow.add(profileWelcomeLabel);
	}
	
	public void incomeWindow() {
		incomeWindow = new JPanel();
		incomeWindow.setLayout(new BorderLayout());
		JPanel values = new IncomePanel(profile);
		incomeLabel = new JLabel("Personal Budget Calculator!");
		incomeWindow.add(incomeLabel, BorderLayout.NORTH);
		incomeWindow.add(values, BorderLayout.WEST);
	}
	
	public void spendingWindow() {
		spendingLabel = new JLabel("Personal Budget Calculator!");
		spendingWindow = new JPanel();
		spendingWindow.add(spendingLabel);
	}
	
	public void billsWindow() {
		billsLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		billsWindow = new JPanel();
		billsWindow.add(billsLabel);
	}
	
	public void paymentsWidnow() {
		paymentsLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		paymentsWindow = new JPanel();
		paymentsWindow.add(paymentsLabel);
	}
	
	public void groceryWindow() {
		groceryLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		groceryWindow = new JPanel();
		groceryWindow.add(groceryLabel);
	}
	
	public void wishlistWindow() {
		wishlistLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		wishlistWindow = new JPanel();
		wishlistWindow.add(wishlistLabel);
	}
		
	private class newProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			newProfile = new NewWindow("newProfile", profile);
		}
	}
	
	private class loadProfileListener implements ActionListener {
		private String profileToLoad;
		
		public loadProfileListener(String profileName) {
			profileToLoad = profileName;
		}
		public void actionPerformed(ActionEvent e) {
			//Sets private File var to the selected profile
			profile = new File("C:\\Users\\Dodongos\\git\\Budget\\" + profileToLoad + ".profile");
			remove(welcomeWindow);
			incomeWindow();
			/**
			profileWelcomeWindow();
			
			spendingWindow();
			billsWindow();
			paymentsWidnow();
			groceryWindow();
			wishlistWindow();
			remove(welcomeWindow);
			Budget.this.add(profileWelcomeWindow);
			add(incomeWindow);
			add(spendingWindow);
			add(billsWindow);
			add(paymentsWindow);
			add(groceryWindow);
			add(wishlistWindow);
			revalidate();
			repaint();
			setVisible(true);
			**/
			
			add(incomeWindow);
			repaint();
			setVisible(true);
		}
	}
	
	private class clearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
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


