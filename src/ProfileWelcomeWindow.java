import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ProfileWelcomeWindow extends JFrame {
	private JPanel windowPanel;
	private JLabel windowLabel;
	private JButton continueButton;
	private JTextField profileName;
	private File profile; 
	
	public ProfileWelcomeWindow(File profile) {
		windowPanel = new JPanel();
		setLocationRelativeTo(null);
		if(profile == null) {
			setTitle("Create New Profile:");
			setSize(400, 400);
			newProfileCreator();
			add(windowPanel);
			setVisible(true);
		} else {
			String profileName = profile.getName().replaceAll(".profile", "");
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
		continueButton.addActionListener(new loadProfileListener(windowPanel));
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
	
	private class loadProfileListener implements ActionListener {
		private JPanel panel;
		public loadProfileListener(JPanel panelIn) {
			panel = panelIn;
		}
		public void actionPerformed(ActionEvent e)
	    {
	    	profile = new File("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profileName.getText() + ".profile"); 
	    	if(profileName.getText().equals("")) {
	    		JLabel error = new JLabel("Please enter a profile name:");
	    		panel.add(error);
	    		repaint();
				setVisible(true);
	    	} else if(profile.exists()) {
	    		JLabel error = new JLabel("This Profile Already Exists, please try again:");
	    		panel.add(error);
	    		repaint();
	    		setVisible(true);
	    	} else {
	    		PrintWriter newProfileName;
				try {
					newProfileName = new PrintWriter("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profileName.getText() + ".profile");
					newProfileName.close();
					dispose();
					NewProfileWindow newProfile = new NewProfileWindow(profile);
				} catch (FileNotFoundException e1) {
					System.out.println(e1);
				}
	    	}
	    }
	}
}
