package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import ui.menu.NewGamePanel;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Picolo Reborn");
		f.setSize(new Dimension(700, 450));
		f.setContentPane(new NewGamePanel(f));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
