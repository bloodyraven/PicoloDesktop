package controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import ui.game.AbstractDisplayPanel;
import ui.menu.EndPanel;

public class FrameController {

	private JFrame f;
	private int cpt;
	private ArrayList<AbstractDisplayPanel> panels;
	
	public FrameController(JFrame f, ArrayList<AbstractDisplayPanel> panels) {
		this.setF(f);
		setCpt(0);
		this.setPanels(panels);
	}
	
	public void nextPanel() {
		if(cpt != panels.size()-1) {
			f.setContentPane(panels.get(cpt));
		} else {
			f.setContentPane(new EndPanel(this));
		}
		cpt++;
		f.repaint();
		f.revalidate();
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public int getCpt() {
		return cpt;
	}

	public void setCpt(int cpt) {
		this.cpt = cpt;
	}

	public ArrayList<AbstractDisplayPanel> getPanels() {
		return panels;
	}

	public void setPanels(ArrayList<AbstractDisplayPanel> panels) {
		this.panels = panels;
	}
	
}
