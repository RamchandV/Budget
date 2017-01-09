import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Budget extends JFrame {
	public File profile; 
	private JMenuBar menuBar = new JMenuBar();
	private JMenu profileMenu, loadProfileMenu, editMenu;
	private JPanel welcomeWindow, profileWelcomeWindow, incomeWindow, spendingWindow, billsWindow, paymentsWindow, groceryWindow, wishlistWindow; 
	private JLabel welcomeLabel, profileWelcomeLabel, incomeLabel, monthlyIncomeLabel, weeklyIncomeLabel, spendingLabel, billsLabel, paymentsLabel, groceryLabel, wishlistLabel;
	private JButton newProfileButton, selectProfileButton, loadProfileButton, editProfileButton, clearProfileButton, wishListButton, paymentsButton, billsButton;
	private JTextField profileSelect = new JTextField(27);
	private NewWindow newProfile;
	
	public Budget() {
		setupMenuBar();
		setJMenuBar(menuBar);
		setTitle("Dodongos' Budget Calculator");
		setLayout(new BorderLayout());
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		welcomeWindow();
		add(welcomeWindow, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void setupMenuBar() {
		//Initialize Load Profile Options
		ArrayList<String> profilesArray = new ArrayList<String>();
		File dir = new File("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\");
		File[] profileList = dir.listFiles();		
		for(int i = 0; i < profileList.length; i++) {
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
		profileMenu = new JMenu("Profile");
		loadProfileMenu = new JMenu("Load");
		editMenu = new JMenu("Edit");
		
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
		welcomeWindow = new JPanel();
		welcomeLabel = new JLabel("Welcome to Dodongos Personal Budget Calculator!");
		newProfileButton = new JButton("New Profile");
		selectProfileButton = new JButton("Select Profile");
		loadProfileButton = new JButton("Load Profile");
		profileSelect.setEditable(false);
		//Set button size
		newProfileButton.setPreferredSize(new Dimension(300, 50));
		selectProfileButton.setPreferredSize(new Dimension(300, 50));
		loadProfileButton.setPreferredSize(new Dimension(300, 50));
		//Add action listeners
		newProfileButton.addActionListener(new newProfileListener());
		selectProfileButton.addActionListener(new selectProfileListener());
		loadProfileButton.addActionListener(null);
		//Load panel
		welcomeWindow.add(welcomeLabel);
		welcomeWindow.add(newProfileButton);
		welcomeWindow.add(selectProfileButton);
		welcomeWindow.add(profileSelect);
		welcomeWindow.add(loadProfileButton);
	}
		
	public void profileWelcomeWindow() {
		//TODO add middle action and window to welcome a user before displaying information.
		//Should go load/new -> WELCOME *NAME* (with continue button) -> page display info
		profileWelcomeLabel = new JLabel("Personal Budget Calculator!");
		profileWelcomeWindow = new JPanel();
		profileWelcomeWindow.add(profileWelcomeLabel);
	}
	
	public void incomeWindow() {
		incomeWindow = new JPanel();
		incomeWindow.setLayout(new BorderLayout());
		JPanel values = new IncomePanel(profile);
		incomeLabel = new JLabel("Your Gross and Taxed Incomes:");
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
	
	private class selectProfileListener implements ActionListener {		
		private String profile;
		
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Budget Profiles", "profile");
			chooser.setFileFilter(filter);
			int status = chooser.showOpenDialog(null);
			if(status == JFileChooser.APPROVE_OPTION) {
				profile = chooser.getSelectedFile().getName();
				profileSelect.setText(profile.replaceAll(".profile", ""));
				loadProfileButton.addActionListener(new loadProfileListener(profileSelect.getText()));
			}
		}
	}
	
	private class loadProfileListener implements ActionListener {
		private String profileToLoad;
		
		public loadProfileListener(String profileName) {
			profileToLoad = profileName;
		}
		public void actionPerformed(ActionEvent e) {
			//Sets private File var to the selected profile
			profile = new File("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profileToLoad + ".profile");
			//Add edit menu item
			JMenuItem editAction = new JMenuItem("Edit");
			profileMenu.add(editAction);
			editAction.addActionListener(new editProfileListener());
			setSize(500, 700);
			remove(welcomeWindow);
			setLayout(new GridLayout(6,1));
			incomeWindow();
			
			/**
			profileWelcomeWindow();
			spendingWindow();
			billsWindow();
			paymentsWidnow();
			groceryWindow();
			wishlistWindow();

			add(incomeWindow);
			add(spendingWindow);
			add(billsWindow);
			add(paymentsWindow);
			add(groceryWindow);
			add(wishlistWindow);
			**/
			
			add(incomeWindow);
			repaint();
			setVisible(true);
		}
	}
	
	private class clearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(incomeWindow);
			/**
			profileWelcomeWindow();
			spendingWindow();
			billsWindow();
			paymentsWidnow();
			groceryWindow();
			wishlistWindow();
			**/
			setLayout(new BorderLayout());
			setSize(500, 300);
			welcomeWindow();
			add(welcomeWindow, BorderLayout.CENTER);
			setVisible(true);
			
		}
	}
	
	private class editProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}


