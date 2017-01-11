import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class BillsPanel extends JPanel {
	private JLabel totalLabel = new JLabel("Bills Total: ");
	private JTextField totalBox;
	private JButton viewButton;
	private JPanel billsPanel;
	private File profile;
	public BillsPanel(File profile) {
		billsPanel = this;
		totalBox = new JTextField(BillsFunctions.totalBills(profile));
		totalBox.setEditable(false);
		viewButton = new JButton("View");
		viewButton.addActionListener(new viewButtonListener(profile));
		setLayout(new GridLayout(2,2));
		add(totalLabel);
		add(totalBox);
		add(viewButton);
	}
	
	public void reloadFile(File profile) {
		String profilePath = profile.getAbsolutePath();
		this.profile = null;
		revalidate();
		repaint();
	}
	
	private class viewButtonListener implements ActionListener {
		private File profile;
		
		public viewButtonListener(File profileIn) {
			profile = profileIn;
		}
		public void actionPerformed(ActionEvent e) {
			BillsEditWindow viewWindow = new BillsEditWindow(profile, billsPanel);
		}
	}
}
