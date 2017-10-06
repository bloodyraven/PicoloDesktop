package ui;

import bean.Question;

@SuppressWarnings("serial")
public class BlankPanel extends AbstractDisplayPanel {
	
	private Question question;

	public BlankPanel(Question question) {
		super(question);
		this.question=question;
	}
	
	public String toString() {
		return "BlankPanel : "+question.getName();
	}

}
