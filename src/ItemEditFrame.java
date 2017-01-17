import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ItemEditFrame extends JFrame {
	private JPanel donePanel;
	private JButton doneButton;
	private HashMap<String,String> itemMap, finishedMap;
	private ProfileContents profile;
	private OutgoingList itemListPanel;
	private ItemPanel caller;
	private String frameTitle, searchString;
	
	public ItemEditFrame(ProfileContents profile, ItemPanel caller) {
		this.profile = profile;
		this.caller = caller;
		this.frameTitle = caller.getTitle();
		this.searchString = caller.getSearchString();
		setSize(350, 350);
		setLayout(new BorderLayout());
		setTitle(frameTitle);
		setLocationRelativeTo(null);
		itemList();
		donePanel();
		add(itemListPanel);
		add(donePanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void itemList() {
		itemMap = Functions.getCurrentItems(profile, searchString);
		itemListPanel = new OutgoingList(itemMap);
	}
	
	public void donePanel() {
		donePanel = new JPanel();
		doneButton = new JButton("Done");
		doneButton.addActionListener(new doneListener());
		donePanel.add(doneButton);
	}
	
	private class doneListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			finishedMap = itemListPanel.getAllElements();
			profile.remove(searchString);
			profile.put(searchString, new ArrayList<String>());
			for(Map.Entry<String, String> entry : finishedMap.entrySet()) {
				profile.get(searchString).add(entry.getKey() + ":" + entry.getValue());
			}
			
			if(caller != null){
				caller.refreshlist();
				dispose();
			}
		}
	}
}


