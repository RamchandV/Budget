import java.awt.*;
import java.io.File;
import javax.swing.*;

public class ProfileName extends JPanel {
	private JLabel profileLabel = new JLabel("Your Profile Name: ");
	public ProfileName(File profile) {
		setLayout(new GridLayout(1,2));
		add(profileLabel);
		if(profile == null) {
			JTextField profileNameEnter = new JTextField();
			add(profileNameEnter);
		} else {
			JLabel profileName = new JLabel(profile.getName().replaceAll(".profile", ""));
			add(profileName);
		}
	}
}
