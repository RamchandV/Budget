import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

@SuppressWarnings("serial")
public class WishlistEditWindow extends JFrame {
	private JPanel donePanel;
	private JButton doneButton;
	private HashMap<String,String> wishlistMap, finishedMap;
	private ProfileContents profile;
	private OutgoingList wishlistListPanel;
	private WishlistPanel caller;
	
	public WishlistEditWindow(ProfileContents profile, WishlistPanel caller) {
		this.profile = profile;
		this.caller = caller;
		setTitle("Wishlist details:");
		setSize(350, 350);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		wishlistList();
		donePanel();
		add(wishlistListPanel);
		add(donePanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void wishlistList() {
		wishlistMap = Functions.getCurrentItems(profile, "wishlistItem:");
		wishlistListPanel = new OutgoingList(wishlistMap);
	}
	
	public void donePanel() {
		donePanel = new JPanel();
		doneButton = new JButton("Done");
		doneButton.addActionListener(new doneListener());
		donePanel.add(doneButton);
	}
	
	private class doneListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			finishedMap = wishlistListPanel.getAllElements();
			profile.remove("wishlistItem:");
			profile.put("wishlistItem:", new ArrayList<String>());
			for(Map.Entry<String, String> entry : finishedMap.entrySet()) {
				profile.get("wishlistItem:").add(entry.getKey() + ":" + entry.getValue());
			}
			
			if(caller != null){
				caller.refreshWishlist();
				dispose();
			}
		}
	}
}


