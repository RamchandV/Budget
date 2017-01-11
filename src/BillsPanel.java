import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class BillsPanel extends JPanel {
	private JLabel totalLabel = new JLabel("Bills Total: ");
	private JTextField totalBox;
	private JButton viewButton;
	private ProfileContents profile;
	private BillsPanel panel;
	
	public BillsPanel(ProfileContents profile) {
		this.panel = this;
		this.profile = profile;
		totalBox = new JTextField(BillsFunctions.totalBills(profile));
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
			BillsEditWindow viewWindow = new BillsEditWindow(profile, panel);
		}
	}
	
	public void refreshBills() {
		remove(totalBox);
		remove(viewButton);
		totalBox = new JTextField(BillsFunctions.totalBills(profile));
		totalBox.setEditable(false);
		add(totalBox);
		add(viewButton);
		revalidate();
		repaint();
	}
}
