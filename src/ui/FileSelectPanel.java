package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bean.Joueur;

@SuppressWarnings("serial")
public class FileSelectPanel extends JPanel {

	private JFrame f;
	private LogoPanel logoPanel;
	private FileListPanel fileListPanel;
	private JPanel top = new JPanel();
	private JPanel bottom = new JPanel();
	private JPanel left = new JPanel();
	private JPanel right = new JPanel();

	public FileSelectPanel(JFrame f, ArrayList<Joueur> joueurList) {
		this.f=f;
		logoPanel = new LogoPanel("Picolo Reborn");
		fileListPanel = new FileListPanel(f, joueurList);
		this.setLayout(new BorderLayout());
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(logoPanel, BorderLayout.NORTH);
		centerPanel.add(fileListPanel, BorderLayout.CENTER);
		this.add(centerPanel, BorderLayout.CENTER);

		// OFFSETS ; N S : 10% ; E W : 20%.
		top.setPreferredSize(new Dimension(50, (int) (f.getHeight() * 0.1)));
		bottom.setPreferredSize(new Dimension(50, (int) (f.getHeight() * 0.1)));
		left.setPreferredSize(new Dimension((int) (f.getWidth() * 0.2), 50));
		right.setPreferredSize(new Dimension((int) (f.getWidth() * 0.2), 50));
		// top.setBackground(Color.blue);
		// bottom.setBackground(Color.yellow);
		// left.setBackground(Color.green);
		// right.setBackground(Color.red);
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

	public FileListPanel getFileListPanel() {
		return fileListPanel;
	}

	public void setFileListPanel(FileListPanel fileListPanel) {
		this.fileListPanel = fileListPanel;
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
	
}
