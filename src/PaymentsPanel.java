import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class PaymentsPanel extends JPanel {
	private JLabel totalLabel = new JLabel("Required Payments Total: ");
	private JTextField totalBox;
	private JButton viewButton;
	private ProfileContents profile;
	private PaymentsPanel panel;
	
	public PaymentsPanel(ProfileContents profile) {
		this.panel = this;
		this.profile = profile;
		totalBox = new JTextField(Functions.totalItems(profile, "requiredPayment:"));
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
			PaymentsEditWindow viewWindow = new PaymentsEditWindow(profile, panel);
		}
	}
	
	public void refreshPayments() {
		remove(totalBox);
		remove(viewButton);
		totalBox = new JTextField(Functions.totalItems(profile, "requiredPayment:"));
		totalBox.setEditable(false);
		add(totalBox);
		add(viewButton);
		revalidate();
		repaint();
	}
}
