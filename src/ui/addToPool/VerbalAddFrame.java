package ui.addToPool;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.IssueDao;
import dao.VerbalDao;
import dao.jdbc.JdbcIssueDao;
import dao.jdbc.JdbcVerbalDao;
import entity.Issue;
import entity.Verbal;



public class VerbalAddFrame extends JFrame{
	private JLabel id = new JLabel();
	private JLabel message=new JLabel();
	private JTextArea questionArea;
	private JTextArea answerArea;
	private JTextArea choiceArea;
	private JTextArea answerInfoArea;
	private JTextField frequenceField;
	private JTextField historyDateField;

	JScrollPane areaScrollPane;
	VerbalDao dao=new JdbcVerbalDao();
	
	public VerbalAddFrame() {
		init();
	}
	
	private void init() {
		setTitle("");
		setSize(320, 500);
		setLocationRelativeTo(null);
		setContentPane(createContentPane());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				exit(VerbalAddFrame.this);
			}
			
		});
	}

	public JPanel createContentPane() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(8, 4, 0, 4));
		panel.add(BorderLayout.NORTH, createLogoPanel());
		panel.add(BorderLayout.CENTER, createCenterPanel());
		panel.add(BorderLayout.SOUTH, createBottomPanel());
		return panel;

	}

	public Date parseInputToDate(String date){
		String[] d=date.split("-");
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(d[0]),Integer.parseInt(d[1])-1,Integer.parseInt(d[2]));
		Date examdate = new Date(c.getTimeInMillis());
//		System.out.println("after parse:" +historyDate);
//		System.out.println("after parse:" +historyDate.getTime());
		return examdate;
		
	}
//	public  Map<Character,String> parseChoice(String choice){
//		Map<Character,String> choices= new HashMap<Character,String>();
//		String cs[]=choice.trim().split(";");
//		Character key= 'a';
//		for (int i=0;i<cs.length;i++){
//			if(!cs[i].equals("")){
//			char index=(char)(i+65);
//			System.out.println(index+cs[i]);
//			choices.put(index, cs[i]);
//			}
//		}
//		return choices;
//		
//	}
//	public List<Character> parseAnswer(String answer){
//		List<Character> answers = new ArrayList<Character>();
//		String temp[]=answer.trim().split(";");
//		for (int i=0;i<temp.length;i++){
//			if (!temp[i].equals("")){
//			char index=(char)Integer.parseInt(temp[i]);
//			System.out.println(index);
//			answers.add(index);
//			}
//		}
//		return answers;
//	}
	public JPanel createBottomPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 0, 5, 0));
		JButton  submit = new JButton("Submit") ;
		submit.addActionListener(new ActionListener(){

			
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (checkField()==false){
						
						Verbal a= new Verbal();
						a.setChoice(a.parseChoice(choiceArea.getText()+";"));
						a.setAnswer(a.parseAnswer(answerArea.getText()+";"));
						a.setAnswerInfo(answerInfoArea.getText());
						a.setFrequence(Integer.parseInt(frequenceField.getText()));
						a.setQuestion(questionArea.getText());
						a.setTaken(false);
						a.setHistoryDate( parseInputToDate(historyDateField.getText()));

						dao.AddVerbal(a);
					}
						
					
					} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
				
					e1.printStackTrace();
				}
				
			}

		
		});

		panel.add(BorderLayout.SOUTH, submit);
		panel.setBorder(new EmptyBorder(5,0,7,0));
		return panel;

	}

	private boolean checkField() {
		boolean stop=true;
//		System.out.println(idInPoolField.getText().equals("")? 1:0);
//		System.out.println(frequenceField.getText());
//		System.out.println(catagoryField.getText());
//		System.out.println(historyDateField.getText());
//		System.out.println(questionArea.getText());
//		System.out.println(answerArea.getText());
//		System.out.println(answerInfoArea.getText());
//		System.out.println(answerInfoArea.getText());
		if (frequenceField.getText().equals("")||questionArea.getText()==null||answerArea.getText()==null||answerInfoArea.getText()==null||historyDateField.getText().equals("")){
			message.setText("Error!! Fill every item!!");
		//	System.out.println(stop);
			return stop;
		}
		String a[]=historyDateField.getText().split("-");
		if (a.length!=3||(int)a[1].charAt(0)<49||(int)a[1].charAt(0)>57){
			message.setText("Error!! Date format is invalid... please use number!");
		//	System.out.println(stop);
			return stop;
		}
		stop=false;
	//	System.out.println(stop);
		return stop;
	}

	public JPanel createErMessagePanel() {
		JPanel panel=new JPanel();
		message = new JLabel("", JLabel.CENTER);
		message.setFont(new Font("sans",12, 9));
		panel.add(message);
		return panel;
	}


	public JPanel createCenterPanel() {
		JPanel panel = new JPanel(new GridLayout(7,1,10,5));// GridLayout(row,col,pixel between cols)
		JLabel label=new JLabel(" Add a new verbal here:");
		panel.add(label);
		panel.add(createDetailPanel());
		panel.add(createQuestionInfoPanel());
		panel.add(createChoicePanel());
		panel.add(createQuestionAnswerPanel());
		panel.add(createAnswerInfoPanel());
		
		panel.add(createErMessagePanel());

		return panel;
	}

	public JPanel createDetailPanel() {
		
		JPanel panel = new JPanel(new GridLayout(2,2,5,5));
		panel.add(createFrequencePanel());
		panel.add(createDatePanel());
		return panel;
	}

	public JPanel createDatePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel("Show Date:");
		historyDateField = new JTextField("xxxx-xx-xx");
		panel.add(BorderLayout.WEST,label);
		panel.add(BorderLayout.CENTER,historyDateField);
		return panel;
	}
	
	

	public JPanel createFrequencePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel("Frequence:");
		frequenceField = new JTextField("0");
		panel.add(BorderLayout.WEST,label);
		panel.add(BorderLayout.CENTER,frequenceField);
		return panel;
	}

	

	public JPanel createAnswerInfoPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel("Answer Info:");
		answerInfoArea = new JTextArea(1,20);
		answerInfoArea.setText("null");
		answerInfoArea.setLineWrap(true);
		answerInfoArea.setWrapStyleWord(true);
		areaScrollPane = new JScrollPane(answerInfoArea);
		areaScrollPane.setVerticalScrollBarPolicy(  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScrollPane.setPreferredSize(new Dimension(20,20));
		panel.add(BorderLayout.NORTH,label);
		panel.add(BorderLayout.CENTER,areaScrollPane);
		return panel;

	}

	public JPanel createQuestionInfoPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel(" Question:");
		questionArea = new JTextArea(1,10);
		questionArea.setLineWrap(true);
		questionArea.setText("null");
		questionArea.setWrapStyleWord(true);
		areaScrollPane = new JScrollPane(questionArea);
		areaScrollPane.setVerticalScrollBarPolicy(  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScrollPane.setPreferredSize(new Dimension(20,20));
		panel.add(BorderLayout.NORTH,label);
		panel.add(BorderLayout.CENTER,areaScrollPane);
		return panel;
	}

	public JPanel createQuestionAnswerPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel("Answers:");
		answerArea = new JTextArea(1,20);
		answerArea.setLineWrap(true);
		answerArea.setText("A;B");
		answerArea.setWrapStyleWord(true);
		areaScrollPane = new JScrollPane(answerArea);
		areaScrollPane.setVerticalScrollBarPolicy(  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScrollPane.setPreferredSize(new Dimension(20,20));
		panel.add(BorderLayout.NORTH,label);
		panel.add(BorderLayout.CENTER,areaScrollPane);
		return panel;
	}
	public JPanel createChoicePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel("Choice:( seperate by ',')");
		choiceArea = new JTextArea(1,20);
		choiceArea.setLineWrap(true);
		choiceArea.setText("null");
		choiceArea.setWrapStyleWord(true);
		areaScrollPane = new JScrollPane(choiceArea);
		areaScrollPane.setVerticalScrollBarPolicy(  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		areaScrollPane.setPreferredSize(new Dimension(20,20));
		panel.add(BorderLayout.NORTH,label);
		panel.add(BorderLayout.CENTER,areaScrollPane);
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


	public void exit(JFrame frame){
		int userReact = JOptionPane.showConfirmDialog(frame,"Do u wanna exit now?");
		if(userReact==JOptionPane.YES_OPTION){
			frame.setVisible(false);
			System.exit(0);
		}
	}
	public static void main(String[] args) {

		VerbalAddFrame add = new VerbalAddFrame();
		add.setVisible(true);

	}

}
