package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import bean.Question;
import constants.Constants;
import controller.FrameController;

@SuppressWarnings(value = "serial")
public class AbstractDisplayPanel extends JPanel {
	
	private Question question;
	private JButton next, exit;
	private FrameController fc;
	private JPanel top = new JPanel();
	private JPanel bottom = new JPanel();
	private JPanel left = new JPanel();
	private JPanel right = new JPanel();

	public AbstractDisplayPanel(Question question, FrameController fc) {
		this.setQuestion(question);
		this.setFc(fc);
		this.setLayout(new BorderLayout());
		
		// OFFSETS ; N S E W : 20%.
		top.setPreferredSize(new Dimension(50, (int)(fc.getF().getHeight()*0.2)));
		bottom.setPreferredSize(new Dimension(50, (int)(fc.getF().getHeight()*0.2)));
		left.setPreferredSize(new Dimension((int)(fc.getF().getWidth()*0.2), 50));
		right.setPreferredSize(new Dimension((int)(fc.getF().getWidth()*0.2), 50));
		this.add(top, BorderLayout.NORTH);
		this.add(bottom, BorderLayout.SOUTH);
		this.add(left, BorderLayout.WEST);
		this.add(right, BorderLayout.EAST);
		
		if(question!=null) {
			this.add(createJTextArea(question.getName()), BorderLayout.CENTER);
			next = new JButton("Suivant");
			next.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					fc.nextPanel();
				}
			});
			bottom.add(next);
		} else {
			this.add(createJTextArea(Constants.END_MSG), BorderLayout.CENTER);
			exit = new JButton("Quitter");
			exit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			bottom.add(exit);
		}
	}
	
	private JTextArea createJTextArea(String s) {
		JTextArea jl = new JTextArea();
		jl.setEditable(false);
		jl.setOpaque(false);
		jl.setLineWrap(true);
		jl.setWrapStyleWord(true);
		return jl;
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
