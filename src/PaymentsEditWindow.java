import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

@SuppressWarnings("serial")
public class PaymentsEditWindow extends JFrame {
	private JPanel donePanel;
	private JButton doneButton;
	private HashMap<String,String> paymentsMap, finishedMap;
	private ProfileContents profile;
	private OutgoingList paymentsListPanel;
	private PaymentsPanel caller;
	
	public PaymentsEditWindow(ProfileContents profile, PaymentsPanel caller) {
		this.profile = profile;
		this.caller = caller;
		setTitle("Payments details:");
		setSize(350, 350);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		paymentsList();
		donePanel();
		add(paymentsListPanel);
		add(donePanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void paymentsList() {
		paymentsMap = Functions.getCurrentItems(profile, "requiredPayment:");
		paymentsListPanel = new OutgoingList(paymentsMap);
	}
	
	public void donePanel() {
		donePanel = new JPanel();
		doneButton = new JButton("Done");
		doneButton.addActionListener(new doneListener());
		donePanel.add(doneButton);
	}
	
	private class doneListener implements ActionListener {		
		public void actionPerformed(ActionEvent e) {
			finishedMap = paymentsListPanel.getAllElements();
			profile.remove("requiredPayment:");
			profile.put("requiredPayment:", new ArrayList<String>());
			for(Map.Entry<String, String> entry : finishedMap.entrySet()) {
				profile.get("requiredPayment:").add(entry.getKey() + ":" + entry.getValue());
			}
			
			if(caller != null){
				caller.refreshPayments();
				dispose();
			}
		}
	}
}


