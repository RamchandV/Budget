import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class BillsEditWindow extends JFrame {
	private JPanel billsListPanel, donePanel;
	private JButton doneButton;
	private HashMap<String, String> billsMap;
	private File profile;
	
	public BillsEditWindow(File profile) {
		this.profile = profile;
		setTitle("Bills details:");
		setSize(350, 350);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		billsListPanel = billsList();
		donePanel = donePanel();
		add(billsListPanel);
		add(donePanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public JPanel billsList() {
		billsMap = BillsFunctions.getCurrentBills(profile);
		return new OutgoingList(billsMap);
	}
	
	public JPanel donePanel() {
		JPanel panel = new JPanel();
		doneButton = new JButton("Done");
		doneButton.addActionListener(new doneListener());
		panel.add(doneButton);
		return panel;
	}
	
	private class doneListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			BufferedReader reader;
			try {
				/**
				 * BufferedWriter writer;
			String newName = name.getText();
			String newAmount = amount.getText();
			if(newName.equals("") || newAmount.equals("")) {
				JLabel error = new JLabel("Please enter a bill name and amount:");
				add(error);
	    		repaint();
				setVisible(true);
			} else {
				try {
					FileWriter stream = new FileWriter(profile, true);
					writer = new BufferedWriter(stream);
					writer.write("monthlyBill:" + newName + ":" + newAmount + "\n");
					writer.flush();
					writer.close();
					name.setText("");
					amount.setText("");
				} catch (IOException ex) {
					System.out.println(ex);
				}
				//remove(billsList);
				//billsList = createBillsList();
				//windowPanel.add(billsList);
				//windowPanel.repaint();
				//setVisible(true);
			}
				 */
				reader = new BufferedReader(new FileReader(profile));
				String line;
				String[] strArry;
				while ((line = reader.readLine()) != null) {
					strArry = line.split(":");
					if(line.startsWith("monthlyBill:")){
						
					}
				}
			} catch (IOException ex) {
				System.out.println(ex);
			}
		}
	}
}


