package ui.game;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bean.Question;
import controller.FrameController;

@SuppressWarnings("serial")
public class EnumerePanel extends AbstractDisplayPanel {

	private Question question;

	public EnumerePanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
		JLabel jl = new JLabel("Enumère...");
		JPanel jp = labelAndPanelInit(jl);
		this.add(jp, BorderLayout.NORTH);
	}
	
	public String toString() {
		return "EnumerePanel : "+question.getName();
	}

}
