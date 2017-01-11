import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class BillsEditWindow extends JFrame {
	private JPanel donePanel;
	private JButton doneButton;
	private HashMap<String,String> billsMap, finishedMap;
	private ProfileContents profile;
	private OutgoingList billsListPanel;
	private BillsPanel caller;
	
	public BillsEditWindow(ProfileContents profile, BillsPanel caller) {
		this.profile = profile;
		this.caller = caller;
		setTitle("Bills details:");
		setSize(350, 350);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		billsList();
		donePanel();
		add(billsListPanel);
		add(donePanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void billsList() {
		billsMap = BillsFunctions.getCurrentBills(profile);
		billsListPanel = new OutgoingList(billsMap);
	}
	
	public void donePanel() {
		donePanel = new JPanel();
		doneButton = new JButton("Done");
		doneButton.addActionListener(new doneListener());
		donePanel.add(doneButton);
	}
	
	private class doneListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			finishedMap = billsListPanel.getAllElements();
			profile.remove("monthlyBill:");
			profile.put("monthlyBill:", new ArrayList<String>());
			for(Map.Entry<String, String> entry : finishedMap.entrySet()) {
				profile.get("monthlyBill:").add(entry.getKey() + ":" + entry.getValue());
			}
			
			if(caller != null){
				caller.refreshBills();
				dispose();
			}
		}
	}
}


