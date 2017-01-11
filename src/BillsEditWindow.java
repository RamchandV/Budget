import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class BillsEditWindow extends JFrame {
	private JPanel donePanel, caller;
	private JButton doneButton;
	private HashMap<String, String> billsMap, finishedMap;
	private File profile;
	private OutgoingList billsListPanel;
	
	public BillsEditWindow(File profile, JPanel caller) {
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
			String profilePath = profile.getAbsolutePath();
			File tempProfile = new File(profilePath + ".tmp");
			finishedMap = billsListPanel.getAllElements();			
			BufferedReader reader;
			BufferedWriter writer;
			try {
				reader = new BufferedReader(new FileReader(profile));
				writer = new BufferedWriter(new FileWriter(tempProfile));
				String line;
				while ((line = reader.readLine()) != null) {
					if(line.startsWith("monthlyBill:")){
						continue;
					} else {
						writer.write(line + "\n");
					}
				}
				for(Map.Entry<String, String> entry : finishedMap.entrySet()) {
					writer.write("monthlyBill:" + entry.getKey() + ":" + entry.getValue() + "\n");
				}
				reader.close();
				writer.flush();
				writer.close();
			} catch (IOException ex) {
				System.out.println(ex);
			}
			if(caller != null){
				caller.reloadFile(profile);
				dispose();
			}
		}
	}
}


