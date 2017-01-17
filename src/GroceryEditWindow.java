import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

@SuppressWarnings("serial")
public class GroceryEditWindow extends JFrame {
	private JPanel donePanel;
	private JButton doneButton;
	private HashMap<String,String> groceriesMap, finishedMap;
	private ProfileContents profile;
	private OutgoingList groceryListPanel;
	private GroceryPanel caller;
	
	public GroceryEditWindow(ProfileContents profile, GroceryPanel caller) {
		this.profile = profile;
		this.caller = caller;
		setTitle("Bills details:");
		setSize(350, 350);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		billsList();
		donePanel();
		add(groceryListPanel);
		add(donePanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void billsList() {
		groceriesMap = Functions.getCurrentItems(profile, "groceryPurchase:");
		groceryListPanel = new OutgoingList(groceriesMap);
	}
	
	public void donePanel() {
		donePanel = new JPanel();
		doneButton = new JButton("Done");
		doneButton.addActionListener(new doneListener());
		donePanel.add(doneButton);
	}
	
	private class doneListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			finishedMap = groceryListPanel.getAllElements();
			profile.remove("groceryPurchase:");
			profile.put("groceryPurchase:", new ArrayList<String>());
			for(Map.Entry<String, String> entry : finishedMap.entrySet()) {
				profile.get("groceryPurchase:").add(entry.getKey() + ":" + entry.getValue());
			}
			
			if(caller != null){
				caller.refreshGroceries();
				dispose();
			}
		}
	}
}


