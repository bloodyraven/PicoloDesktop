package ui.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import bean.Question;
import controller.FrameController;

@SuppressWarnings(value = "serial")
public class AbstractDisplayPanel extends JPanel {
	
	private Question question;
	private JButton next;
	private FrameController fc;
	private JPanel top = new JPanel();
	private JPanel bottom = new JPanel();
	private JPanel left = new JPanel();
	private JPanel right = new JPanel();
	int topHeight;
	int bottomHeight;
	int leftHeight;
	int rightHeight;

	public AbstractDisplayPanel(Question question, FrameController fc) {
		this.setQuestion(question);
		this.setFc(fc);
		this.setLayout(new BorderLayout());
		
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
		
		JTextArea jl = new JTextArea(question.getName());
		jl.setEditable(false);
		jl.setOpaque(false);
		jl.setLineWrap(true);
		jl.setWrapStyleWord(true);
		this.add(jl, BorderLayout.CENTER);
		next = new JButton("Suivant");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fc.nextPanel();
			}
		});
		bottom.add(next);
	}
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public FrameController getFc() {
		return fc;
	}

	public void setFc(FrameController fc) {
		this.fc = fc;
	}
	
}
