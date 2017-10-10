package ui.menu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.Constants;

@SuppressWarnings("serial")
public class EndPanel extends JPanel {
	
	private JButton button;
	
	public EndPanel() {
		button = new JButton("Quitter");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		this.setLayout(new BorderLayout());
		this.add(new JLabel(Constants.END_MSG), BorderLayout.CENTER);
		this.add(button, BorderLayout.SOUTH);
	}

}
