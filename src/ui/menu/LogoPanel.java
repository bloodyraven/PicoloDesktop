package ui.menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LogoPanel extends JPanel {
	
	private String text;

	public LogoPanel(String text) {
		this.setText(text);
		this.setPreferredSize(new Dimension(300, 60));
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 35));
		g.drawString(text, 75, 40);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
