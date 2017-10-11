package ui.game;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.Question;
import controller.FrameController;

@SuppressWarnings("serial")
public class JeuPanel extends AbstractDisplayPanel {

	private Question question;

	public JeuPanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		JLabel jl = new JLabel("Jeu !");
		JPanel jp = labelAndPanelInit(jl);
		this.add(jp, BorderLayout.NORTH);
	}
	
	public String toString() {
		return "JeuPanel : "+question.getName();
	}

}
