import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class NewProfileWindow extends JFrame {
	private JPanel windowPanel;
	private ProfileContents profile; 
	
	public NewProfileWindow(ProfileContents profile) {
		this.profile = profile;
		setTitle("Create New Profile:");
		setSize(400, 400);
		setLocationRelativeTo(null);
		newProfileWindow();
		add(windowPanel);
		setVisible(true);
	}
	
	public void newProfileWindow() {
		windowPanel = new JPanel();
		ProfileNameWindow name = new ProfileNameWindow(profile);
		IncomePanel income = new IncomePanel(profile);
		ItemPanel billsWindow = new ItemPanel(profile, "Bills", "monthlyBill:");
		ItemPanel paymentsPanel = new ItemPanel(profile, "Payments", "requiredPayment:");
		ItemPanel groceryPanel = new ItemPanel(profile, "Grocery", "groceryPurchase:");
		ItemPanel wishlistPanel = new ItemPanel(profile, "Wishlist", "wishlistItem:");
		SaveProfile savePanel = new SaveProfile(profile, windowPanel);
		GridLayout layout = new GridLayout(6,1);
		layout.setVgap(10);
		windowPanel.setLayout(layout);
		windowPanel.add(name);
		windowPanel.add(income);
		windowPanel.add(billsWindow);
		windowPanel.add(paymentsPanel);
		windowPanel.add(groceryPanel);
		windowPanel.add(wishlistPanel);
		windowPanel.add(savePanel, BorderLayout.SOUTH);
	}
}


