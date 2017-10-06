package ui;

import bean.Question;

@SuppressWarnings("serial")
public class JeuPanel extends AbstractDisplayPanel {

	private Question question;

	public JeuPanel(Question question) {
		super(question);
		this.question=question;
	}
	
	public String toString() {
		return "JeuPanel : "+question.getName();
	}

}
