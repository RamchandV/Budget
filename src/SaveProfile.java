import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SaveProfile extends JPanel {
	private JButton saveButton = new JButton("Save");
	private File toWrite;
	private ProfileContents profile;
	private JFrame container;
	
	public SaveProfile(ProfileContents profile, JFrame container) {
		this.profile = profile;
		this.container = container;
		saveButton.addActionListener(new saveListener());
		add(saveButton);
	}
	
	private class saveListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Path filePath = Paths.get("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profile.getName() + ".profile");
			try {
				Files.deleteIfExists(filePath);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			toWrite = new File("C:\\Users\\Dodongos\\git\\Budget\\Profiles\\" + profile.getName() + ".profile");
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(toWrite));
				for(HashMap.Entry<String,List<String>> key : profile.entrySet()) {
					for(String value : key.getValue()){
						writer.write(key.getKey() + value.toString() + "\n");
					}
				}
				writer.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			JLabel doneLabel = new JLabel("Profile Saved");
			add(doneLabel, BorderLayout.SOUTH);
			container.revalidate();
			container.repaint();
		}
	}
}
