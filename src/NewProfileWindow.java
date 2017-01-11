import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class NewProfileWindow extends JFrame {
	private JPanel windowPanel, savePanel;
	private ProfileContents profile; 
	
	public NewProfileWindow(ProfileContents profile) {
		this.profile = profile;
		setTitle("Create New Profile:");
		setSize(400, 400);
		setLocationRelativeTo(null);
		newProfileWindow();
		//add(windowPanel);
		setVisible(true);
	}
	
	public void newProfileWindow() {
		ProfileName name = new ProfileName(profile);
		IncomePanel income = new IncomePanel(profile);
		BillsPanel bills = new BillsPanel(profile);
		savePanel = new SaveProfile(profile, this);
		GridLayout layout = new GridLayout(6,1);
		layout.setVgap(10);
		setLayout(layout);
		add(name);
		add(income);
		add(bills);
		add(savePanel, BorderLayout.SOUTH);
	}
}


