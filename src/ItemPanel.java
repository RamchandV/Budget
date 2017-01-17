import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemPanel extends JPanel {
	private JLabel totalLabel;
	private JTextField totalBox;
	private JButton viewButton;
	private ProfileContents profile;
	private ItemPanel panel;
	private String itemTitle, searchItem;
	
	public ItemPanel(ProfileContents profile, String itemTitle, String searchItem) {
		this.panel = this;
		this.profile = profile;
		this.itemTitle = itemTitle;
		this.searchItem = searchItem;
		totalLabel = new JLabel(itemTitle + " Total: ");
		totalBox = new JTextField(Functions.totalItems(profile, searchItem));
		totalBox.setEditable(false);
		viewButton = new JButton("View");
		viewButton.addActionListener(new viewButtonListener());
		setLayout(new GridLayout(1,3));
		add(totalLabel);
		add(totalBox);
		add(viewButton);
	}
	
	public String getTitle() {
		return itemTitle;
	}
	
	public String getSearchString() {
		return searchItem;
	}
	
	private class viewButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ItemEditFrame viewWindow = new ItemEditFrame(profile, panel);
		}
	}
	
	public void refreshlist() {
		remove(totalBox);
		remove(viewButton);
		totalBox = new JTextField(Functions.totalItems(profile, searchItem));
		totalBox.setEditable(false);
		add(totalBox);
		add(viewButton);
		revalidate();
		repaint();		
	}

}
