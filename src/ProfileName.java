import java.awt.*;
import java.io.File;
import javax.swing.*;

public class ProfileName extends JPanel {
	private String name;
	private JLabel profileLabel = new JLabel("Your Profile Name: ");
	public ProfileName(ProfileContents profile) {
		name = profile.getName();
		setLayout(new GridLayout(1,2));
		add(profileLabel);
		if(name == null) {
			JTextField profileNameEnter = new JTextField();
			add(profileNameEnter);
		} else {
			JLabel profileName = new JLabel(name);
			add(profileName);
		}
	}
}
