import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class ProfileView extends JPanel {
	JPanel incomePanel, outgoingGroup;
	ItemPanel billsWindow, paymentsPanel, groceryPanel, wishlistPanel;
	public ProfileView(ProfileContents profile){
		setLayout(new BorderLayout());
		incomePanel = new JPanel();
		outgoingGroup = new JPanel();
		//Set Window format
		GridLayout layout = new GridLayout(5,1);
		layout.setVgap(10);
		outgoingGroup.setLayout(layout);
		//Create new panels
		ProfileNameWindow nameWindow = new ProfileNameWindow(profile);
		IncomePanel incomeWindow = new IncomePanel(profile);
		ItemPanel billsWindow = new ItemPanel(profile, "Bills", "monthlyBill:");
		ItemPanel paymentsPanel = new ItemPanel(profile, "Payments", "requiredPayment:");
		ItemPanel groceryPanel = new ItemPanel(profile, "Grocery", "groceryPurchase:");
		ItemPanel wishlistPanel = new ItemPanel(profile, "Wishlist", "wishlistItem:");
		SaveProfile savePanel = new SaveProfile(profile, this);
		/**
		add(spendingWindow);
		**/
		incomePanel.add(nameWindow);
		incomePanel.add(incomeWindow);
		outgoingGroup.add(billsWindow);
		outgoingGroup.add(paymentsPanel);
		outgoingGroup.add(groceryPanel);
		outgoingGroup.add(wishlistPanel);
		add(incomePanel, BorderLayout.NORTH);
		add(outgoingGroup, BorderLayout.CENTER);
		add(savePanel, BorderLayout.SOUTH);
	}
}
