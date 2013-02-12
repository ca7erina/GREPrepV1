package ui.addToPool;



import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Provide the Controling of Logic Data flow to Client .
 * 
 * @author Cxx
 * 
 */
public class UIController {
//	public static final int NEXT_Q = 1;
//	public static final int PERV_Q = -1;
//
//    private QuestionAddMainFrame questionAddMainFrame;
//    private ReadingAddFrame readingAddFrame;
//    private IssueAddFrame issueAddFrame;
//    private ArgumentAddFrame argumentAddFrame;
//    private MathAddFrame mathAddFrame;
//    private VerbalAddFrame verbalAddFrame;
//    private ReadingVerbalAddFrame readingVerbalAddFrame;
//	private Timer timer;
//	
//	
//	
//	public QuestionAddMainFrame getQuestionAddMainFrame() {
//		return questionAddMainFrame;
//	}
//
//	public void setQuestionAddMainFrame(QuestionAddMainFrame questionAddMainFrame) {
//		this.questionAddMainFrame = questionAddMainFrame;
//	}
//
//	public ReadingVerbalAddFrame getReadingVerbalAddFrame() {
//		return readingVerbalAddFrame;
//	}
//
//	public void setReadingVerbalAddFrame(ReadingVerbalAddFrame readingVerbalAddFrame) {
//		this.readingVerbalAddFrame = readingVerbalAddFrame;
//	}
//
//	public ReadingAddFrame getReadingAddFrame() {
//		return readingAddFrame;
//	}
//
//	public void setReadingAddFrame(ReadingAddFrame readingAddFrame) {
//		this.readingAddFrame = readingAddFrame;
//	}
//
//	public IssueAddFrame getIssueAddFrame() {
//		return issueAddFrame;
//	}
//
//	public void setIssueAddFrame(IssueAddFrame issueAddFrame) {
//		this.issueAddFrame = issueAddFrame;
//	}
//
//	public ArgumentAddFrame getArgumentAddFrame() {
//		return argumentAddFrame;
//	}
//
//	public void setArgumentAddFrame(ArgumentAddFrame argumentAddFrame) {
//		this.argumentAddFrame = argumentAddFrame;
//	}
//
//	public MathAddFrame getMathAddFrame() {
//		return mathAddFrame;
//	}
//
//	public void setMathAddFrame(MathAddFrame mathAddFrame) {
//		this.mathAddFrame = mathAddFrame;
//	}
//
//	public VerbalAddFrame getVerbalAddFrame() {
//		return verbalAddFrame;
//	}
//
//	public void setVerbalAddFrame(VerbalAddFrame verbalAddFrame) {
//		this.verbalAddFrame = verbalAddFrame;
//	}

	public void close(JFrame frame) {
		frame.setVisible(false);
	}

	public void open(JFrame frame) {
		frame.setVisible(true);
	}
//	public void shiftQuestion(int dir){	
//		try {
//			logic.saveUserAnswers(currentQuestionIndex, examFrame.getUserAnswers());
//			logic.GradeQuestion(currentQuestionIndex);
//			System.out.println("index: "+currentQuestionIndex);
//			this.currentQuestionIndex =currentQuestionIndex+dir;
//			if (currentQuestionIndex== paper.size()-1){
//				
//				examFrame.updateView(currentQuestionIndex);
//    			examFrame.getNext().setEnabled(true);
//				examFrame.getNext().setText("submit");
//				
//			}else{	
//				
//				
//				examFrame.updateView(currentQuestionIndex);
//				examFrame.getNext().setText(">");
//			
//		}	
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


//
//	public void startTimer(){
//		int m = examinfo.getTimeLimit();
//		final long end = System.currentTimeMillis()+m*1000*60/2;
//		timer = new Timer();
//		timer.schedule(new TimerTask(){
//			private long show,h,m,s;
//					
//			@Override
//			public void run() {
//	
//				 show = end - System.currentTimeMillis();
//				 h= show/1000/60/60;
//				 m=show/1000/60%60;
//				 s=show/1000%60;
//				 examFrame.updateTimer((int)h, (int)m, (int)s);
//			}
//			
//		},0,200);
//		timer.schedule(new TimerTask(){
//
//			@Override
//			public void run() {
//				
//				
//				examFrame.submit(getPaper().size());
//				timer.cancel();
//				
//			}
//			
//		}, new Date(end));
//	}
	




	public void exit(JFrame frame){
		int userReact = JOptionPane.showConfirmDialog(frame,"Do u wanna exit now?");
		if(userReact==JOptionPane.YES_OPTION){
			frame.setVisible(false);
			System.exit(0);
		}
	}
	
	
}