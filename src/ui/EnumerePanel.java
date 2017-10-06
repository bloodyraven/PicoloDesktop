package ui;

import bean.Question;

@SuppressWarnings("serial")
public class EnumerePanel extends AbstractDisplayPanel {

	private Question question;

	public EnumerePanel(Question question) {
		super(question);
		this.question=question;
	}
	
	public String toString() {
		return "EnumerePanel : "+question.getName();
	}

}
