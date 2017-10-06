package ui;

import bean.Question;

@SuppressWarnings("serial")
public class TuPreferesPanel extends AbstractDisplayPanel {

	private Question question;

	public TuPreferesPanel(Question question) {
		super(question);
		this.question=question;
	}
	
	public String toString() {
		return "TuPreferePanel : "+question.getName();
	}
}
