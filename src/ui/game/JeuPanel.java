package ui.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.FrameController;
import bean.Question;

@SuppressWarnings("serial")
public class JeuPanel extends AbstractDisplayPanel {

	private Question question;

	public JeuPanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		JLabel jl = new JLabel("Jeu !");
		jl.setPreferredSize(new Dimension(200, topHeight));
		JPanel jp = new JPanel();
		jp.setLayout(new GridBagLayout());
		jp.add(jl);
		jp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add(jp, BorderLayout.NORTH);
	}
	
	public String toString() {
		return "JeuPanel : "+question.getName();
	}

}
