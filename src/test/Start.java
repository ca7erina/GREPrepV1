package test;

import ui.addToPool.ArgumentAddFrame;
import ui.addToPool.IssueAddFrame;
import ui.addToPool.MathAddFrame;
import ui.addToPool.QuestionAddMainFrame;
import ui.addToPool.ReadingAddFrame;
import ui.addToPool.UIController;
import ui.addToPool.VerbalAddFrame;

public class Start {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UIController ctrl= new UIController();
		QuestionAddMainFrame add = new QuestionAddMainFrame();
		ArgumentAddFrame argumentAddFrame= new ArgumentAddFrame();
		IssueAddFrame issueAddFrame= new IssueAddFrame();
		VerbalAddFrame verbalAddFrame=new VerbalAddFrame();
		MathAddFrame mathAddFrame= new MathAddFrame();
		ReadingAddFrame readingAddFrame= new ReadingAddFrame();

		readingAddFrame.setController(ctrl);
		
		
		add.setReadingAddFrame(readingAddFrame);
		add.setMathAddFrame(mathAddFrame);
		add.setVerbalAddFrame(verbalAddFrame);
		add.setArgumentAddFrame(argumentAddFrame);
		add.setIssueAddFrame(issueAddFrame);
		add.setController(ctrl);
		
//		ctrl.setReadingVerbalAddFrame(readingAddFrame.getReadingVerbalAddFrame());
//		ctrl.setReadingAddFrame(readingAddFrame);
//		ctrl.setMathAddFrame(mathAddFrame);
//		ctrl.setVerbalAddFrame(verbalAddFrame);
//		ctrl.setIssueAddFrame(issueAddFrame);
//		ctrl.setQuestionAddMainFrame(add);
//		ctrl.setArgumentAddFrame(argumentAddFrame);
		
		
		add.setVisible(true);

	}

}
