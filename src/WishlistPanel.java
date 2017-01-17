import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class WishlistPanel extends JPanel {
	private JLabel totalLabel = new JLabel("Wishlist Total: ");
	private JTextField totalBox;
	private JButton viewButton;
	private ProfileContents profile;
	private WishlistPanel panel;
	
	public WishlistPanel(ProfileContents profile) {
		this.panel = this;
		this.profile = profile;
		totalBox = new JTextField(Functions.totalItems(profile, "wishlistItem:"));
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
			WishlistEditWindow viewWindow = new WishlistEditWindow(profile, panel);
		}
	}
	
	public void refreshWishlist() {
		remove(totalBox);
		remove(viewButton);
		totalBox = new JTextField(Functions.totalItems(profile, "wishlistItem:"));
		totalBox.setEditable(false);
		add(totalBox);
		add(viewButton);
		revalidate();
		repaint();
	}
}
