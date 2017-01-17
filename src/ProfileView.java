import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class ProfileView extends JPanel {
	public ProfileView(ProfileContents profile){
		//Set Window format
		GridLayout layout = new GridLayout(7,1);
		layout.setVgap(10);
		setLayout(layout);
		//Create new panels
		ProfileNameWindow nameWindow = new ProfileNameWindow(profile);
		IncomePanel incomeWindow = new IncomePanel(profile);
		BillsPanel billsWindow = new BillsPanel(profile);
		PaymentsPanel paymentsPanel = new PaymentsPanel(profile);
		SaveProfile savePanel = new SaveProfile(profile, this);
		/**
		add(spendingWindow);
		add(paymentsWindow);
		add(groceryWindow);
		add(wishlistWindow);
		**/
		add(nameWindow);
		add(incomeWindow);
		add(billsWindow);
		add(paymentsPanel);
		add(savePanel, BorderLayout.SOUTH);
	}
}
