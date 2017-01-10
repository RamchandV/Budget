import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class OutgoingList extends JPanel {
	public OutgoingList(HashMap<String, String> list) {
		JPanel listPanel = new JPanel();
		setLayout(new BorderLayout());
		listPanel.setPreferredSize(new Dimension(350,0));
		for(Map.Entry<String, String> entry : list.entrySet()) {
			String name = new String(entry.getKey());
			String amount = new String(entry.getValue());
			Outgoing item = new Outgoing(name, amount, listPanel);
			listPanel.add(item);
			Dimension oldDim = listPanel.getPreferredSize();
			listPanel.setPreferredSize(new Dimension(350, (int) oldDim.getHeight()+31));
		}
		JScrollPane scroll = new JScrollPane(listPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//Add fields and button to add a bill to panel.
		OutgoingAdd add = new OutgoingAdd(listPanel);
		add(scroll);
		add(add, BorderLayout.SOUTH);
	}
}
