import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class GroceryPanel extends JPanel {
	private JLabel totalLabel = new JLabel("Groceries Purchased: ");
	private JTextField totalBox;
	private JButton viewButton;
	private ProfileContents profile;
	private GroceryPanel panel;
	
	public GroceryPanel(ProfileContents profile) {
		this.panel = this;
		this.profile = profile;
		totalBox = new JTextField(Functions.totalItems(profile, "groceryPurchase:"));
		totalBox.setEditable(false);
		viewButton = new JButton("View");
		viewButton.addActionListener(new viewButtonListener());
		setLayout(new GridLayout(2,2));
		add(totalLabel);
		add(totalBox);
		add(viewButton);
	}
	
	private class viewButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GroceryEditWindow viewWindow = new GroceryEditWindow(profile, panel);
		}
	}
	
	public void refreshGroceries() {
		remove(totalBox);
		remove(viewButton);
		totalBox = new JTextField(Functions.totalItems(profile, "groceryPurchase:"));
		totalBox.setEditable(false);
		add(totalBox);
		add(viewButton);
		revalidate();
		repaint();
	}
}
