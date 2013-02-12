package entity;

import java.util.Date;

public class Math extends Entry {
	private Integer id;
	private Integer frequence;
	private String picture;
	private String question;	
	private String answere;
	private String answereInfo;
	private String catagory;
	private Date historyDate;
	private Boolean taken;
	
	public Math(){
		
	}

	public Math(Integer id, Integer frequence, String picture, String question,
			String answere, String answereInfo, String catagory,
			Date historyDate, Boolean taken) {
		super();
		this.id = id;
		this.frequence = frequence;
		this.picture = picture;
		this.question = question;
		this.answere = answere;
		this.answereInfo = answereInfo;
		this.catagory = catagory;
		this.historyDate = historyDate;
		this.taken = taken;
	}

	public Math(Integer frequence, String picture, String question,
			String answere, String answereInfo, String catagory,
			Date historyDate) {
		super();
		this.frequence = frequence;
		this.picture = picture;
		this.question = question;
		this.answere = answere;
		this.answereInfo = answereInfo;
		this.catagory = catagory;
		this.historyDate = historyDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((answere == null) ? 0 : answere.hashCode());
		result = prime * result
				+ ((answereInfo == null) ? 0 : answereInfo.hashCode());
		result = prime * result
				+ ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result
				+ ((frequence == null) ? 0 : frequence.hashCode());
		result = prime * result
				+ ((historyDate == null) ? 0 : historyDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((picture == null) ? 0 : picture.hashCode());
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((taken == null) ? 0 : taken.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Math other = (Math) obj;
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
		if (picture == null) {
			if (other.picture != null)
				return false;
		} else if (!picture.equals(other.picture))
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
