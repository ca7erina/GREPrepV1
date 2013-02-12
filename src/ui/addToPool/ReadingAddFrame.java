package ui.addToPool;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;

import java.util.GregorianCalendar;

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



import dao.ReadingDao;

import dao.jdbc.JdbcReadingDao;
import entity.Reading;
import entity.ReadingVerbal;



public class ReadingAddFrame extends JFrame{
	private UIController controller;
	
	private JLabel id = new JLabel();
	private JLabel message=new JLabel();
	

	private JTextField frequenceField;
	private JTextArea passageArea;
	private JTextField catagoryField;
	private JTextField historyDateField;


	Reading a= new Reading();


	JScrollPane areaScrollPane;
	ReadingDao dao=new JdbcReadingDao();
	
	public UIController getController() {
		return controller;
	}

	public void setController(UIController controller) {
		this.controller = controller;
	}

//	public ReadingVerbalAddFrame getReadingVerbalAddFrame() {
//		return readingVerbalAddFrame;
//	}
//
//	public void setReadingVerbalAddFrame(ReadingVerbalAddFrame readingVerbalAddFrame) {
//		this.readingVerbalAddFrame = readingVerbalAddFrame;
//	}

	public ReadingAddFrame() {
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
				exit(ReadingAddFrame.this);
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
	//	System.out.println("after parse:" +examdate);
	//	System.out.println("after parse:" +examdate.getTime());
		return examdate;
		
	}
	public JPanel createBottomPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 0, 5, 0));
		JButton  submit = new JButton("Continue to add questions to this passage") ;
		submit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				try {
					if (checkField()==false){
						
						a.setFrequence(Integer.parseInt(frequenceField.getText()));
						a.setPassage(passageArea.getText());
						a.setCatagory(catagoryField.getText());
						a.setHistoryDate( parseInputToDate(historyDateField.getText()));				
			//			System.out.println(a);
						a.setId(dao.AddReading(a));
				//		System.out.println(a);
						ReadingVerbalAddFrame readingVerbalAddFrame= new ReadingVerbalAddFrame();
						readingVerbalAddFrame.setReading(a);
						
						ReadingAddFrame.this.setVisible(false);
						controller.open(readingVerbalAddFrame);
				//		System.out.println("after valued:"+readingVerbalAddFrame.getReading());
					}
						
					
					} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				
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
		if (frequenceField.getText().equals("")||passageArea.getText()==null||catagoryField.getText().equals("")||historyDateField.getText().equals("")){
			message.setText("Error!! Fill every item!!");
			return stop;
		}
		String a[]=historyDateField.getText().split("-");
		if (a.length!=3||(int)a[1].charAt(0)<49||(int)a[1].charAt(0)>57){
			message.setText("Error!! Date format is invalid... please use number!");
			return stop;
		}
		stop=false;
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
		JPanel panel = new JPanel(new GridLayout(5,1,10,5));// GridLayout(row,col,pixel between cols)
		JLabel label=new JLabel(" Add a new reading here:");
		panel.add(label);
		panel.add(createDetailPanel());
		panel.add(createPassagePanel());
		
		panel.add(createErMessagePanel());

		return panel;
	}

	public JPanel createDetailPanel() {
		
		JPanel panel = new JPanel(new GridLayout(2,2,5,5));
		panel.add(createFrequencePanel());
		panel.add(createCategoryPanel());
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
	
	public JPanel createCategoryPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel("Type:");
		catagoryField = new JTextField("null");
		panel.add(BorderLayout.WEST,label);
		panel.add(BorderLayout.CENTER,catagoryField);
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


	

	public JPanel createPassagePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel label=new JLabel("Passage:");
		passageArea = new JTextArea(1,20);
		passageArea.setLineWrap(true);
		passageArea.setWrapStyleWord(true);
		passageArea.setText("null");
		areaScrollPane = new JScrollPane(passageArea);
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
		ReadingAddFrame add = new ReadingAddFrame();
		add.setVisible(true);
	}
	
	
	 class ReadingVerbalAddFrame extends JFrame{
		private Reading reading =a;
		private JLabel message=new JLabel();

		private JTextArea questionArea;
		private JTextArea choiceArea;
		private JTextArea answerArea;
		private JTextArea answerInfoArea;
		JScrollPane areaScrollPane;
		ReadingDao dao=new JdbcReadingDao();
		
		public ReadingVerbalAddFrame() {
			
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
					exit(ReadingVerbalAddFrame.this);
				}
				
			});
			
			
		}
		
		public Reading getReading() {
			return reading;
		}

		public void setReading(Reading reading) {
			this.reading = reading;
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
//			System.out.println("after parse:" +historyDate);
//			System.out.println("after parse:" +historyDate.getTime());
			return examdate;
			
		}
		public JPanel createBottomPanel() {
			JPanel panel = new JPanel(new BorderLayout());
			panel.setBorder(new EmptyBorder(5, 0, 5, 0));
			JButton  submit = new JButton("Submit") ;
			submit.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					
					try {
						if (checkField()==false){
							ReadingVerbal rv= new ReadingVerbal();
							rv.setReadingId(getReading().getId());
							rv.setChoice(rv.parseChoice(choiceArea.getText()+";"));
							rv.setAnswer(rv.parseAnswer(answerArea.getText()+";"));
							rv.setAnswerInfo(answerInfoArea.getText());
							rv.setFrequence(getReading().getFrequence());
							rv.setQuestion(questionArea.getText());
							rv.setTaken(false);
							rv.setHistoryDate( getReading().getHistoryDate());
							//System.out.println("made a verbal:"+rv);

							dao.AddReadingVerbal(rv);
						}
							
						
						} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
					
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
//			System.out.println(idInPoolField.getText().equals("")? 1:0);
//			System.out.println(frequenceField.getText());
//			System.out.println(catagoryField.getText());
//			System.out.println(historyDate.getText());
//			System.out.println(questionArea.getText());
//			System.out.println(answerArea.getText());
//			System.out.println(answerInfoArea.getText());
//			System.out.println(answerInfoArea.getText());
			if (questionArea.getText()==null||answerArea.getText()==null||answerInfoArea.getText()==null){
				message.setText("Error!! Fill every item!!");
//				System.out.println(stop);
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
			JLabel label=new JLabel("Adding question to Reading : "+getReading().getId());
			panel.add(label);
			panel.add(createQuestionInfoPanel());
			panel.add(createChoicePanel());
			panel.add(createQuestionAnswerPanel());
			panel.add(createAnswerInfoPanel());
			panel.add(createErMessagePanel());
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
		public JPanel createQuestionAnswerPanel() {
			JPanel panel = new JPanel(new BorderLayout());
			JLabel label=new JLabel("Answers:");
			answerArea = new JTextArea(1,20);
			answerArea.setLineWrap(true);
			answerArea.setText("null");
			answerArea.setWrapStyleWord(true);
			areaScrollPane = new JScrollPane(answerArea);
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
		

	}

	

}
