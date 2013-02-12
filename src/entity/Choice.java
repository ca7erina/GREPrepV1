package entity;

import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Choice {
	private Integer id;
	private String question;
	private Map<Character,String> choice = new HashMap<Character, String>();
	private List<Character> answer= new ArrayList<Character>();
	private String answerInfo;
	private Date historyDate;
	private Integer frequence;
	private Boolean taken;

	
	public Choice(){
		
	}
	
	public Choice(String question, Map<Character, String> choice,
			List<Character> answer, String answerInfo, Date historyDate) {
		super();
		this.question = question;
		this.choice = choice;
		this.answer = answer;
		this.answerInfo = answerInfo;
		this.historyDate = historyDate;
	}

	public Choice(Integer id, String question, Map<Character, String> choice,
			List<Character> answer, String answerInfo, Date historyDate,
			Integer frequence,Boolean taken) {
		super();
		this.id = id;
		this.question = question;
		this.choice = choice;
		this.answer = answer;
		this.answerInfo = answerInfo;
		this.historyDate = historyDate;
		this.taken = taken;
		this.frequence = frequence;
	}

	@Override
	public String toString() {
		return "Choice [id=" + id + ", historyDate=" + historyDate
				+ ", question=" + question + ", choice=" + choice + ", answer="
				+ answer + ", answerInfo=" + answerInfo + ", frequence="
				+ frequence + ", taken=" + taken + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result
				+ ((answerInfo == null) ? 0 : answerInfo.hashCode());
		result = prime * result + ((choice == null) ? 0 : choice.hashCode());
		result = prime * result
				+ ((frequence == null) ? 0 : frequence.hashCode());
		result = prime * result
				+ ((historyDate == null) ? 0 : historyDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((taken == null) ? 0 : taken.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Choice other = (Choice) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answerInfo == null) {
			if (other.answerInfo != null)
				return false;
		} else if (!answerInfo.equals(other.answerInfo))
			return false;
		if (choice == null) {
			if (other.choice != null)
				return false;
		} else if (!choice.equals(other.choice))
			return false;
		if (frequence == null) {
			if (other.frequence != null)
				return false;
		} else if (!frequence.equals(other.frequence))
			return false;
		if (historyDate == null) {
			if (other.historyDate != null)
				return false;
		} else if (!historyDate.equals(other.historyDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (taken == null) {
			if (other.taken != null)
				return false;
		} else if (!taken.equals(other.taken))
			return false;
		return true;
	}
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
	public String getAnswerInfo() {
		return answerInfo;
	}
	public void setAnswerInfo(String answerInfo) {
		this.answerInfo = answerInfo;
	}
	public Date getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}
	public Boolean getTaken() {
		return taken;
	}
	public void setTaken(Boolean taken) {
		this.taken = taken;
	}
	public Integer getFrequence() {
		return frequence;
	}
	public void setFrequence(Integer frequence) {
		this.frequence = frequence;
	}
	
	
	
}
