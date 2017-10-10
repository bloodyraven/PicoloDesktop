package ui.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NewGamePanel extends JPanel {
	
	private JFrame f;
	private LogoPanel logoPanel;
	private EntryListPanel entryListPanel;
	private JPanel top = new JPanel();
	private JPanel bottom = new JPanel();
	private JPanel left = new JPanel();
	private JPanel right = new JPanel();

	public NewGamePanel(JFrame f) {
		this.f=f;
		logoPanel = new LogoPanel("Picolo Reborn");
		entryListPanel = new EntryListPanel(f);
		this.setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(logoPanel, BorderLayout.NORTH);
		centerPanel.add(entryListPanel, BorderLayout.CENTER);
		this.add(centerPanel, BorderLayout.CENTER);
		
		// OFFSETS ; N S : 10% ; E W : 20%.
		top.setPreferredSize(new Dimension(50, (int)(f.getHeight()*0.1)));
		bottom.setPreferredSize(new Dimension(50, (int)(f.getHeight()*0.1)));
		left.setPreferredSize(new Dimension((int)(f.getWidth()*0.2), 50));
		right.setPreferredSize(new Dimension((int)(f.getWidth()*0.2), 50));
//		top.setBackground(Color.blue);
//		bottom.setBackground(Color.yellow);
//		left.setBackground(Color.green);
//		right.setBackground(Color.red);
		this.add(top, BorderLayout.NORTH);
		this.add(bottom, BorderLayout.SOUTH);
		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
	}
	
	@Override
	public void repaint() {
		super.repaint();
		if(top!=null && bottom!=null && left!=null && right!=null) {
			top.setPreferredSize(new Dimension(50, (int)(f.getHeight()*0.1)));
			bottom.setPreferredSize(new Dimension(50, (int)(f.getHeight()*0.1)));
			left.setPreferredSize(new Dimension((int)(f.getWidth()*0.2), 50));
			right.setPreferredSize(new Dimension((int)(f.getWidth()*0.2), 50));
		}
	}

	public JPanel getTop() {
		return top;
	}

	public void setTop(JPanel top) {
		this.top = top;
	}

	public JPanel getBottom() {
		return bottom;
	}

	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}

	public JPanel getLeft() {
		return left;
	}

	public void setLeft(JPanel left) {
		this.left = left;
	}

	public JPanel getRight() {
		return right;
	}

	public void setRight(JPanel right) {
		this.right = right;
	}

	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public LogoPanel getLogoPanel() {
		return logoPanel;
	}

	public void setLogoPanel(LogoPanel logoPanel) {
		this.logoPanel = logoPanel;
	}

	public EntryListPanel getEntryListPanel() {
		return entryListPanel;
	}

	public void setEntryListPanel(EntryListPanel entryListPanel) {
		this.entryListPanel = entryListPanel;
	}
	
}
