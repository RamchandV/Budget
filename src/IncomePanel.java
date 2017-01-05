import java.awt.*;
import java.io.*;
import javax.swing.*;

public class IncomePanel extends JPanel {
	private JLabel[] labelArray = new JLabel[6];
	private JTextField[] textArray = new JTextField[6];
	private String[] labels = {"Yearly gross income: ", "Yearly taxed income: ", "Monthly taxed income: ", "Weekly taxed income: ", "Hourly gross income: ", "Hourly taxed income: "};
	
	public IncomePanel(File profile) {
		buildArrays(profile);
		setLayout(new GridLayout(6,2));
		for(int i = 0; i < 6; i++) {
			add(labelArray[i]);
			add(textArray[i]);
		}
	}
	
	private void buildArrays(File profile) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(profile));
			String line;
			String[] strArry;
			while ((line = reader.readLine()) != null) {
				strArry = line.split(":");
				switch(strArry[0]) { 
				case "yearlyGross":
					textArray[0] = new JTextField(strArry[1]);
					break;
				case "yearlyIncome":
					textArray[1] = new JTextField(strArry[1]);
					break;
				case "monthlyIncome":
					textArray[2] = new JTextField(strArry[1]);
					break;
				case "weeklyIncome":
					textArray[3] = new JTextField(strArry[1]);
					break;
				case "hourlyGross":
					textArray[4] = new JTextField(strArry[1]);
					break;
				case "hourlyIncome":
					textArray[5] = new JTextField(strArry[1]);
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		for(int i = 0; i < 6; i++) {
			labelArray[i] = new JLabel(labels[i]);
		}
		for(int i = 0; i < 6; i++) {
			textArray[i].setEditable(false);
		}
	}
}
