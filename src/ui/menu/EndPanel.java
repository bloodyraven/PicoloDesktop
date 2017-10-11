package ui.menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import constants.Constants;
import controller.FrameController;

@SuppressWarnings("serial")
public class EndPanel extends JPanel {
	
	private JButton button;
	private FrameController fc;
	private JPanel top = new JPanel();
	private JPanel bottom = new JPanel();
	private JPanel left = new JPanel();
	private JPanel right = new JPanel();
	int topHeight;
	int bottomHeight;
	int leftHeight;
	int rightHeight;
	
	public EndPanel(FrameController fc) {
		this.setFc(fc);
		button = new JButton("Quitter");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		this.setLayout(new BorderLayout());
		JTextArea jl = new JTextArea(Constants.END_MSG);
		jl.setFont(new Font("Arial", Font.PLAIN, 32));
		jl.setEditable(false);
		jl.setOpaque(false);
		jl.setLineWrap(true);
		jl.setWrapStyleWord(true);
		jl.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(jl, BorderLayout.CENTER);
		
		// OFFSETS ; N S E W : 20%.
		this.topHeight = (int)(fc.getF().getHeight()*0.2);
		this.bottomHeight = (int)(fc.getF().getHeight()*0.2);
		this.leftHeight = (int)(fc.getF().getHeight()*0.2);
		this.rightHeight = (int)(fc.getF().getHeight()*0.2);
		top.setPreferredSize(new Dimension(50, topHeight));
		bottom.setPreferredSize(new Dimension(50, bottomHeight));
		left.setPreferredSize(new Dimension(leftHeight, 50));
		right.setPreferredSize(new Dimension(rightHeight, 50));
		this.add(top, BorderLayout.NORTH);
		this.add(bottom, BorderLayout.SOUTH);
		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
				
		bottom.add(button, BorderLayout.SOUTH);
	}

	public FrameController getFc() {
		return fc;
	}

	public void setFc(FrameController fc) {
		this.fc = fc;
	}

}
