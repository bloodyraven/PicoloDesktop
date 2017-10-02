package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EntryListPanel extends JPanel {

	JPanel buttonWrapper = new JPanel();
	JPanel entriesWrapper = new JPanel();
	JButton add = new JButton("Nouveau joueur");
	JButton start = new JButton("Commencer");
	JFrame f;

	public EntryListPanel(JFrame f) {
		this.f=f;
		this.setLayout(new BorderLayout());
		buttonWrapper.setLayout(new FlowLayout());
		buttonWrapper.add(add);
		buttonWrapper.add(start);
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEntry();
			}
		});
		this.add(buttonWrapper, BorderLayout.SOUTH);
		this.add(entriesWrapper, BorderLayout.CENTER);
	}
	
	void addEntry() {
		entriesWrapper.add(new EntryPanel(this));
		f.repaint();
		f.revalidate();
	}
	
	void removeEntry(EntryPanel ep) {
		entriesWrapper.remove(ep);
		f.repaint();
		f.revalidate();
	}
	
}
