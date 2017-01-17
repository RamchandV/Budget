import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class ProfileWelcomeWindow extends JFrame {
	private JPanel windowPanel;
	private JLabel windowLabel;
	private JButton continueButton;
	private JTextField profileName;
	private ProfileContents profile;
	
	public ProfileWelcomeWindow(ProfileContents profile) {
		this.profile = profile;
		this.windowPanel = new JPanel();
		setLocationRelativeTo(null);
		if(profile == null) {
			setTitle("Create New Profile:");
			setSize(450, 150);
			newProfileCreator();
			add(windowPanel);
			setVisible(true);
		} else {
			String profileName = profile.getName();
			setTitle("Welcome " + profileName);	
			setSize(350, 200);
			loadExistingProfile(profileName);
			add(windowPanel);
			setVisible(true);
		}
	}
	
	public void newProfileCreator() {		
		windowLabel = new JLabel("Welcome to Dodongos' Budget Calculator: Please provide a profile name!");
		profileName = new JTextField(10);
		continueButton = new JButton("Continue");
		continueButton.addActionListener(new newProfileListener());
		windowPanel.add(windowLabel);
		windowPanel.add(profileName);
		windowPanel.add(continueButton);
	}
	
	public void loadExistingProfile(String profileName) {
		windowLabel = new JLabel("Welcome " + profileName + ": Your profile has been loaded");
		continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e)
		    {
		       dispose();
		    }
		});
		windowPanel.add(windowLabel);
		windowPanel.add(continueButton);
	}
	
	private class newProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e)
	    {
	    	if(profileName.getText().equals("")) {
	    		JLabel error = new JLabel("Please enter a profile name:");
	    		windowPanel.add(error);
	    		repaint();
				setVisible(true);
	    	} else if(new File("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profileName.getText() + ".profile").exists()) {
	    		JLabel error = new JLabel("This Profile Already Exists, please try again:");
	    		windowPanel.add(error);
	    		repaint();
	    		setVisible(true);
	    	} else {
	    		profile = new ProfileContents(new File("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profileName.getText() + ".profile"));
	    		profile.put("name:", new ArrayList<String>());
	    		profile.get("name:").add(profileName.getText());
				dispose();
				NewProfileWindow newProfile = new NewProfileWindow(profile);
		  	}
	    }
	}
}
