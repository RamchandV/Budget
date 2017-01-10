import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class ViewBillsWindow extends JFrame {
	private JPanel windowPanel, addPanel, billsList;
	private JTextField newNameField, newAmountField;
	private JButton addBillButton, removeBillButton, doneButton;
	private HashMap<String, String> billsMap;
	private File profile; 
	
	public ViewBillsWindow(File profileIn) {
		profile = profileIn;
		setTitle("Bills details:");
		setSize(300, 350);
		setLocationRelativeTo(null);
		billsViewWindow();
		add(windowPanel);
		setVisible(true);
	}
		
	public void billsViewWindow() {
		billsList = createBillsList();
		//create components
		newNameField = new JTextField(8);
		newAmountField = new JTextField(8);
		addBillButton = new JButton("Add");
		doneButton = new JButton("Done");
		windowPanel = new JPanel();
		addPanel = new JPanel();
		addPanel.setLayout(new GridLayout(1,3));
		//create button listener links
		addBillButton.addActionListener(new addBillButtonListener(profile, newNameField, newAmountField));
		doneButton.addActionListener(new doneBillsButtonListener(profile));	
		//add components
		addPanel.add(newNameField);
		addPanel.add(newAmountField);
		addPanel.add(addBillButton);
		windowPanel.add(billsList);
		windowPanel.add(addPanel);
		windowPanel.add(doneButton);
	}
	
	public JPanel createBillsList() {
		billsMap = BillsFunctions.getCurrentBills(profile);
		JPanel list = new JPanel();
		list.setLayout(new GridLayout(billsMap.size(),3));
		for(Map.Entry<String, String> entry : billsMap.entrySet()) {
			removeBillButton = new JButton("Remove");
			removeBillButton.addActionListener(new removeBillButtonListener(profile));
			JLabel name = new JLabel(entry.getKey());
			list.add(name);
			JTextField amount = new JTextField(entry.getValue());
			list.add(amount);
			list.add(removeBillButton);
		}
		return list;
	}
	
	private class addBillButtonListener implements ActionListener {
		private File profile;
		private JTextField name, amount;
		public addBillButtonListener(File profileIn, JTextField nameIn, JTextField amountIn) {
			profile = profileIn;
			name = nameIn;
			amount = amountIn;
		}
		
		public void actionPerformed(ActionEvent e) {
			BufferedWriter writer;
			String newName = name.getText();
			String newAmount = amount.getText();
			if(newName.equals("") || newAmount.equals("")) {
				JLabel error = new JLabel("Please enter a bill name and amount:");
				windowPanel.add(error);
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
				windowPanel.remove(billsList);
				billsList = createBillsList();
				windowPanel.add(billsList);
				windowPanel.repaint();
				setVisible(true);
			}
		}
	}
	
	private class removeBillButtonListener implements ActionListener {
		private File profile;
		public removeBillButtonListener(File profileIn) {
			profile = profileIn;
		}
		
		public void actionPerformed(ActionEvent e) {
			File tempFile = new File("TempProfile.txt");
			BufferedReader reader;
			BufferedWriter writer;
			try {
				reader = new BufferedReader(new FileReader(profile));
				writer = new BufferedWriter(new FileWriter(tempFile));
				String currentLine;
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
	
	private class doneBillsButtonListener implements ActionListener {
		private File profile;
		public doneBillsButtonListener(File profileIn) {
			profile = profileIn;
		}
		
		public void actionPerformed(ActionEvent e) {
			BufferedReader reader;
			try {
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


