import javax.swing.*;
import java.awt.event.*;

public class Budget extends JFrame {
	private JPanel panel;
	private JLabel messageLabel;
	private JTextField textField;
	private JButton button; 
	final int WINDOW_WIDTH = 600;
	final int WINDOW_HEIGHT = 400;
	
	public Budget() {
		setTitle("Dodongos' Budget Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);
	}
	
	public void buildPanel() {
		messageLabel = new JLabel("Enter your yearly salary");
		textField = new JTextField(10);
		button = new JButton("Enter");
		button.addActionListener(new buttonListener());
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(textField);
		panel.add(button);
	}
	
	private class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String input;
			double salary;
			
			input = textField.getText();
			salary = Double.parseDouble(input) / 1000;
			//insert to text file to store input
			JOptionPane.showMessageDialog(null, "Your Salary has been stored as $" + salary + "k per year");
		}
	}
}


