package ui;

import javax.swing.JPanel;

import bean.Question;

@SuppressWarnings(value = "serial")
public class AbstractDisplayPanel extends JPanel {
	
	private Question question;

	public AbstractDisplayPanel(Question question) {
		this.setQuestion(question);
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
