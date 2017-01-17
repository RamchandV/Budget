import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OutgoingAdd extends JPanel {
	private JTextField name = new JTextField(4);
	private JTextField amount = new JTextField(4);
	private JButton addButton;
	private JPanel container;
	public OutgoingAdd(JPanel container) {
		this.container = container;
		setLayout(new GridLayout(1,3));
		addButton = new JButton("Add");
		addButton.addActionListener(new addListener());
		add(name);
		add(amount);
		add(addButton);
	}
	
	private class addListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(name.getText().equals("") || amount.getText().equals("")){				
			} else {
				Outgoing newBill = new Outgoing(name.getText(), amount.getText(), container);
				Dimension oldDim = container.getPreferredSize();
				container.setPreferredSize(new Dimension(350, (int) oldDim.getHeight()+31));
				name.setText("");
				amount.setText("");
				container.add(newBill);
				container.revalidate();
				container.repaint();
			}
			
		}
	}
}
