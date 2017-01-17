import java.awt.*;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;

public class IncomePanel extends JPanel {
	private JLabel[] loadLabelArray = new JLabel[6];
	private JTextField[] loadTextArray = new JTextField[6];
	private JLabel[] newLabelArray = new JLabel[2];
	private JTextField[] newTextArray = new JTextField[2];
	private String[] loadLabels = {"Yearly gross income: ", "Yearly taxed income: ", "Monthly taxed income: ", "Weekly taxed income: ", "Hourly gross income: ", "Hourly taxed income: "};
	private String[] newLabels = {"Yearly gross income: ", "Hourly Taxed Income: "};
	
	public IncomePanel(ProfileContents profile) {
		if(profile.size() < 2) {
			buildArrays();
			setLayout(new GridLayout(newLabels.length,2));
			for(int i = 0;i < newLabels.length; i++) {
				add(newLabelArray[i]);
				add(newTextArray[i]);
			}
		} else {
			buildArrays(profile);
			setLayout(new GridLayout(loadLabels.length,2));
			for(int i = 0; i < loadLabels.length; i++) {
				add(loadLabelArray[i]);
				add(loadTextArray[i]);
			}
		}
	}
	
	private void buildArrays() {
		for(int i = 0; i < newLabels.length; i++) {
			newLabelArray[i] = new JLabel(newLabels[i]);
		}
		for(int i = 0; i < newLabels.length; i++) {
			newTextArray[i] = new JTextField("");
		}
	}
	
	private void buildArrays(ProfileContents profile) {
		for(HashMap.Entry<String,List<String>> element : profile.entrySet()) {
			switch(element.getKey()) { 
			case "yearlyGross:":
				loadTextArray[0] = new JTextField(element.getValue().get(0));
				break;
			case "yearlyIncome:":
				loadTextArray[1] = new JTextField(element.getValue().get(0));
				break;
			case "monthlyIncome:":
				loadTextArray[2] = new JTextField(element.getValue().get(0));
				break;
			case "weeklyIncome:":
				loadTextArray[3] = new JTextField(element.getValue().get(0));
				break;
			case "hourlyGross:":
				loadTextArray[4] = new JTextField(element.getValue().get(0));
				break;
			case "hourlyIncome:":
				loadTextArray[5] = new JTextField(element.getValue().get(0));
				break;
			}
		}
		for(int i = 0; i < loadLabels.length; i++) {
			loadLabelArray[i] = new JLabel(loadLabels[i]);
		}
		for(int i = 0; i < loadLabels.length; i++) {
			loadTextArray[i].setEditable(false);
		}
	}
}
