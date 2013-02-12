package entity;


import java.util.Date;

public class Entry {
	private Integer id;
	private Integer idInPool;
	private Integer frequence;
	private String passage;
	private String question;	
	private String answere;
	private String answereInfo;
	private String catagory;
	private Date historyDate;
	private Boolean taken;
	
	public Entry(){
		
	}
	
	public Entry(Integer id, Integer idInPool, Integer frequence,
			String passage, String question, String answere,
			String answereInfo, String catagory, Date historyDate, Boolean taken) {
		super();
		this.id = id;
		this.idInPool = idInPool;
		this.frequence = frequence;
		this.passage = passage;
		this.question = question;
		this.answere = answere;
		this.answereInfo = answereInfo;
		this.catagory = catagory;
		this.historyDate = historyDate;
		this.taken = taken;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Entry [id=" + id + ", idInPool=" + idInPool + ", passage="
				+ passage + ", answere=" + answere + ", answereInfo="
				+ answereInfo + ", catagory=" + catagory + ", examdate="
				+ historyDate + ", frequence=" + frequence + ", question="
				+ question + ", taken=" + taken + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdInPool() {
		return idInPool;
	}
	public void setIdInPool(Integer idInPool) {
		this.idInPool = idInPool;
	}
	public Integer getFrequence() {
		return frequence;
	}
	public void setFrequence(Integer frequence) {
		this.frequence = frequence;
	}
	public String getPassage() {
		return passage;
	}
	public void setPassage(String passage) {
		this.passage = passage;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswere() {
		return answere;
	}
	public void setAnswere(String answere) {
		this.answere = answere;
	}
	public String getAnswereInfo() {
		return answereInfo;
	}
	public void setAnswereInfo(String answereInfo) {
		this.answereInfo = answereInfo;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answere == null) ? 0 : answere.hashCode());
		result = prime * result
				+ ((answereInfo == null) ? 0 : answereInfo.hashCode());
		result = prime * result
				+ ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result
				+ ((historyDate == null) ? 0 : historyDate.hashCode());
		result = prime * result
				+ ((frequence == null) ? 0 : frequence.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idInPool == null) ? 0 : idInPool.hashCode());
		result = prime * result + ((passage == null) ? 0 : passage.hashCode());
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
		Entry other = (Entry) obj;
		if (answere == null) {
			if (other.answere != null)
				return false;
		} else if (!answere.equals(other.answere))
			return false;
		if (answereInfo == null) {
			if (other.answereInfo != null)
				return false;
		} else if (!answereInfo.equals(other.answereInfo))
			return false;
		if (catagory == null) {
			if (other.catagory != null)
				return false;
		} else if (!catagory.equals(other.catagory))
			return false;
		if (historyDate == null) {
			if (other.historyDate != null)
				return false;
		} else if (!historyDate.equals(other.historyDate))
			return false;
		if (frequence == null) {
			if (other.frequence != null)
				return false;
		} else if (!frequence.equals(other.frequence))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idInPool == null) {
			if (other.idInPool != null)
				return false;
		} else if (!idInPool.equals(other.idInPool))
			return false;
		if (passage == null) {
			if (other.passage != null)
				return false;
		} else if (!passage.equals(other.passage))
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


	
}
