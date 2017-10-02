package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LogoPanel extends JPanel {

	public LogoPanel() {
		this.setPreferredSize(new Dimension(300, 60));
		this.setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 35));
		g.drawString("Picolo Reborn", 75, 40);
	}
}
