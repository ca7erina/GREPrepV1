package entity;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;
import java.util.Map;




public class ReadingVerbal extends Verbal {
	private Integer id;
	private Integer readingId;
	private String question;	
	private String answerInfo;
	private Boolean taken;
	private Map<Character,String> choice = new HashMap<Character, String>();
	private List<Character> answer= new ArrayList<Character>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerInfo() {
		return answerInfo;
	}

	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}

	public Boolean getTaken() {
		return taken;
	}

	public void setTaken(Boolean taken) {
		this.taken = taken;
	}

	public Map<Character, String> getChoice() {
		return choice;
	}

	public void setChoice(Map<Character, String> choice) {
		this.choice = choice;
	}

	public List<Character> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Character> answer) {
		this.answer = answer;
	}

	public ReadingVerbal(){
		
	}

	public ReadingVerbal(Integer id, Integer readingId, String question,
			String answerInfo, Boolean taken, Map<Character, String> choice,
			List<Character> answer) {
		super();
		this.id = id;
		this.readingId = readingId;
		this.question = question;
		this.answerInfo = answerInfo;
		this.taken = taken;
		this.choice = choice;
		this.answer = answer;
	}

	
	public ReadingVerbal(Integer readingId, String question, String answerInfo,
			Map<Character, String> choice, List<Character> answer) {
		super();
		this.readingId = readingId;
		this.question = question;
		this.answerInfo = answerInfo;
		this.choice = choice;
		this.answer = answer;
	}

	public Integer getReadingId() {
		return this.readingId;
	}
	public void setReadingId(Integer readingId) {
		this.readingId = readingId;
	}



	@Override
	public String toString() {
		return "ReadingVerbal [id=" + id + ", readingId=" + readingId
				+ ", question=" + question + ", choice=" + choice + ", answer="
				+ answer + ", answerInfo=" + answerInfo + ", taken=" + taken
				+ "]";
	}

	
	

	
}
