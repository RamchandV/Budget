import javax.swing.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Budget extends JFrame {
	//public File profile; 
	private JMenuBar menuBar = new JMenuBar();
	private JMenu profileMenu, loadProfileMenu, editMenu;
	private JPanel welcomeWindow, viewPanel; 
	private JLabel welcomeLabel;
	private JButton newProfileButton, selectProfileButton, loadProfileButton;
	private JTextField profileSelect = new JTextField(27);
	private ProfileContents profile;
	
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
	
	private void setProfile(ProfileContents toSet) {
		this.profile = toSet;
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
	
	public void profileViewWindow(String profileToLoad) {
		//Sets private File var to the selected profile
		File toLoad = new File("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profileToLoad + ".profile");
		profile = new ProfileContents(toLoad);
		setProfile(profile);
		toLoad = null;
		//Recreate profile view after load	
		if(welcomeWindow != null){ remove(welcomeWindow); }
		if(viewPanel != null){ remove(viewPanel); }
		setSize(500, 800);
		viewPanel = new ProfileView(profile);
		add(viewPanel);
		revalidate();
		repaint();
		//Display Welcome Window
		profileWelcomeWindow();
	}
	
	public void profileWelcomeWindow() {
		ProfileWelcomeWindow profileWelcome = new ProfileWelcomeWindow(this.profile);
	}
		
	private class newProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			profileWelcomeWindow();
		}
	}
	
	private class selectProfileListener implements ActionListener {				
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Budget Profiles", "profile");
			chooser.setFileFilter(filter);
			int status = chooser.showOpenDialog(null);
			if(status == JFileChooser.APPROVE_OPTION) {
				String profile = chooser.getSelectedFile().getName();
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
			profileViewWindow(profileToLoad);
		}
	}
	
	private class clearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//clear old profile
			if(viewPanel != null){ remove(viewPanel); }
			//clear text box
			profileSelect.setText("");
			//Reset welcome window
			setLayout(new BorderLayout());
			setSize(500, 300);
			welcomeWindow();
			add(welcomeWindow, BorderLayout.CENTER);
			setVisible(true);
			
		}
	}
}


