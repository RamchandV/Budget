import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Outgoing extends JPanel {
	private JPanel container;
	private JLabel name;
	private JTextField amount = new JTextField(4);
	private JButton removeButton;
	public Outgoing(String name, String amount, JPanel container) {
		setLayout(new GridLayout(1,3));
		this.name = new JLabel(name);
		this.amount.setText(amount);
		this.container = container;
		removeButton = new JButton("Remove");
		removeButton.addActionListener(new removeListener(this));
		add(this.name);
		add(this.amount);
		add(removeButton);
	}
	
	public String getInfo() {
		String name, amount;
		name = this.name.getText();
		amount = this.amount.getText();
		return (name + ":" + amount);
	}
	
	private class removeListener implements ActionListener {
		Outgoing component;
		public removeListener(Outgoing component) {
			this.component = component;
		}
		public void actionPerformed(ActionEvent e) {
			Dimension oldDim = container.getPreferredSize();
			container.setPreferredSize(new Dimension(350, (int) oldDim.getHeight()-31));
			container.remove(component);
			container.revalidate();
			container.repaint();
		}
	}
}
