package ui;

import javax.swing.JPanel;

@SuppressWarnings(value = "serial")
public class AbstractDisplayPanel extends JPanel {
	
	private String text;

	public AbstractDisplayPanel(String text) {
		this.setText(text);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
