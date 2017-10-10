package ui.game;

import controller.FrameController;
import bean.Question;

@SuppressWarnings("serial")
public class BlankPanel extends AbstractDisplayPanel {
	
	private Question question;

	public BlankPanel(Question question, FrameController fc) {
		super(question, fc);
		this.question=question;
	}
	
	public String toString() {
		return "BlankPanel : "+question.getName();
	}

}
