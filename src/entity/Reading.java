package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reading {
	private Integer id;
	private Integer frequence;
	private String passage;
	private String catagory;
	private Date historyDate;
	List <ReadingVerbal> readingverbals= new ArrayList<ReadingVerbal>();
	
	public Reading(){
		
	}
	public Reading(Integer frequence, String passage, String catagory,
			Date historyDate, List<ReadingVerbal> readingverbals) {
		super();
		this.frequence = frequence;
		this.passage = passage;
		this.catagory = catagory;
		this.historyDate = historyDate;
		this.readingverbals = readingverbals;
	}
	

	public Reading(Integer id, Integer frequence, String passage,
			String catagory, Date historyDate) {
		super();
		this.id = id;
		this.frequence = frequence;
		this.passage = passage;
		this.catagory = catagory;
		this.historyDate = historyDate;
	}
	public Reading(Integer id, Integer frequence, String passage,
			String catagory, Date historyDate,
			List<ReadingVerbal> readingverbals) {
		super();
		this.id = id;
		this.frequence = frequence;
		this.passage = passage;
		this.catagory = catagory;
		this.historyDate = historyDate;
		this.readingverbals = readingverbals;
	}
	
	@Override
	public String toString() {
		return "Reading [id=" + id + ", frequence=" + frequence
				+ ", historyDate=" + historyDate + ", passage=" + passage
				+ ", catagory=" + catagory + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result
				+ ((frequence == null) ? 0 : frequence.hashCode());
		result = prime * result
				+ ((historyDate == null) ? 0 : historyDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((passage == null) ? 0 : passage.hashCode());
		result = prime * result
				+ ((readingverbals == null) ? 0 : readingverbals.hashCode());
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
		Reading other = (Reading) obj;
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
		if (passage == null) {
			if (other.passage != null)
				return false;
		} else if (!passage.equals(other.passage))
			return false;
		if (readingverbals == null) {
			if (other.readingverbals != null)
				return false;
		} else if (!readingverbals.equals(other.readingverbals))
			return false;
		return true;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public List<ReadingVerbal> getReadingverbals() {
		return readingverbals;
	}
	public void setReadingverbals(List<ReadingVerbal> readingverbals) {
		this.readingverbals = readingverbals;
	}
	
}
