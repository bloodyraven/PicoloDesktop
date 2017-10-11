package ui.game;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.Question;
import controller.FrameController;

@SuppressWarnings("serial")
public class TuPreferesPanel extends AbstractDisplayPanel {

	private Question question;

	public TuPreferesPanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		JLabel jl = new JLabel("Tu préfères...");
		JPanel jp = labelAndPanelInit(jl);
		this.add(jp, BorderLayout.NORTH);
	}
	
	public String toString() {
		return "TuPreferePanel : "+question.getName();
	}
}
