package ui.addToPool;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class QuestionAddMainFrame extends JFrame {
	private UIController controller;
	private ReadingAddFrame readingAddFrame;
    private IssueAddFrame issueAddFrame;
    private ArgumentAddFrame argumentAddFrame;
    private MathAddFrame mathAddFrame;
    private VerbalAddFrame verbalAddFrame;

    
	public QuestionAddMainFrame() {
		init();
	}
	
	public UIController getController() {
		return controller;
	}

	public void setController(UIController controller) {
		this.controller = controller;
	}

	public ReadingAddFrame getReadingAddFrame() {
		return readingAddFrame;
	}

	public void setReadingAddFrame(ReadingAddFrame readingAddFrame) {
		this.readingAddFrame = readingAddFrame;
	}

	public IssueAddFrame getIssueAddFrame() {
		return issueAddFrame;
	}

	public void setIssueAddFrame(IssueAddFrame issueAddFrame) {
		this.issueAddFrame = issueAddFrame;
	}

	public ArgumentAddFrame getArgumentAddFrame() {
		return argumentAddFrame;
	}

	public void setArgumentAddFrame(ArgumentAddFrame argumentAddFrame) {
		this.argumentAddFrame = argumentAddFrame;
	}

	public MathAddFrame getMathAddFrame() {
		return mathAddFrame;
	}

	public void setMathAddFrame(MathAddFrame mathAddFrame) {
		this.mathAddFrame = mathAddFrame;
	}

	public VerbalAddFrame getVerbalAddFrame() {
		return verbalAddFrame;
	}

	public void setVerbalAddFrame(VerbalAddFrame verbalAddFrame) {
		this.verbalAddFrame = verbalAddFrame;
	}

	private void init() {
		setTitle("");
		setSize(320, 500);
		setLocationRelativeTo(null);
		setContentPane(createContentPane());
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				exit(QuestionAddMainFrame.this);
//			}
//
//		});
	}

	public JPanel createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(8, 4, 0, 4));
		panel.add(BorderLayout.NORTH, createLogoPanel());
		panel.add(BorderLayout.CENTER, createCenterPanel());

		return panel;

	}

	public JPanel createLogoPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(15, 0, 0, 0));
		URL url = this.getClass().getResource("gre_header_logo_105x72.jpg");
	//	System.out.println(url);
		ImageIcon logo = new ImageIcon(url);
		JLabel label = new JLabel(logo);
		panel.add(label);
		return panel;
	}

	public JPanel createCenterPanel() {
		JPanel panel = new JPanel(new GridLayout(8, 1, 0, 0));// GridLayout(row,col,pixel
																// between cols)
		JLabel label = new JLabel(" Chose a type to add :");
		panel.add(label);
	
		JButton argument = creatImgBtn("argument.png", "argument");
		argument.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			QuestionAddMainFrame.this.setVisible(false);
				controller.open(argumentAddFrame);
				
			}
			
			
		});
		JButton issue = creatImgBtn("issue.png", "issue");
		issue.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				QuestionAddMainFrame.this.setVisible(false);
				controller.open(issueAddFrame);
				
			}
			
		});
		
		JButton verbal = creatImgBtn("verbal.png", "verbal");	
		verbal.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				QuestionAddMainFrame.this.setVisible(false);
				controller.open(verbalAddFrame);
				
			}
			
		});
		JButton reading = creatImgBtn("reading.png", "reading");
		reading.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				QuestionAddMainFrame.this.setVisible(false);
				controller.open(readingAddFrame);
				
			}
			
		});
		JButton math = creatImgBtn("math.png", "math");
		math.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				QuestionAddMainFrame.this.setVisible(false);
				controller.open(mathAddFrame);
				
			}
			
		});
		panel.add(argument);
		panel.add(issue);
		panel.add(verbal);
		panel.add(reading);
		panel.add(math);
		
		return panel;
	}



	private JButton creatImgBtn(String imgUrl, String txt) {
		URL url = QuestionAddMainFrame.class.getResource(imgUrl);
		ImageIcon icon = new ImageIcon(url);
		JButton button = new JButton(txt, icon);
		button.setVerticalTextPosition(JButton.CENTER);
	//	button.setHorizontalTextPosition(JButton.RIGHT);
		

		return button;
	}

	public void exit(JFrame frame) {
		int userReact = JOptionPane.showConfirmDialog(frame,
				"Do u wanna exit now?");
		if (userReact == JOptionPane.YES_OPTION) {
			frame.setVisible(false);
			System.exit(0);
		}
	}

	

	public void updateQuestionId() {

	}
}
