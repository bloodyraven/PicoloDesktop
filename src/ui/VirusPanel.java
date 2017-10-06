package ui;

import bean.Question;

@SuppressWarnings("serial")
public class VirusPanel extends AbstractDisplayPanel {

	private Question question;

	public VirusPanel(Question question) {
		super(question);
		this.question=question;
	}
	
	public String toString() {
		return "VirusPanel : "+question.getName();
	}

}
