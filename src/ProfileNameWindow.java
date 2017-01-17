import java.awt.*;
import javax.swing.*;

public class ProfileNameWindow extends JPanel {
	private String name;
	private JLabel profileLabel = new JLabel("Your Profile Name: ");
	public ProfileNameWindow(ProfileContents profile) {
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
