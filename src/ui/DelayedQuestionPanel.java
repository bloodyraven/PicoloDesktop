package ui;

@SuppressWarnings("serial")
public class DelayedQuestionPanel extends AbstractDisplayPanel {
	
	private String text;

	public DelayedQuestionPanel(String text) {
		super(null);
		this.setText(text);
	}
	
	public String toString() {
		return "DelayedQuestionPanel : "+text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
