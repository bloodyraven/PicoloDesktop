package ui;

import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EntryPanel extends JPanel {
	
	JButton delete;
	EntryPanel ep = this;
	TextField tf;
	
	public EntryPanel(EntryListPanel elp) {
		tf = new TextField();
		tf.setPreferredSize(new Dimension(100, 30));
		delete = new JButton("X");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				elp.removeEntry(ep);
			}
		});
		this.add(tf);
		this.add(delete);
	}

}