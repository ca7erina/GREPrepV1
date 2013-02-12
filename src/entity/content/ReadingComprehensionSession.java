package entity.content;
import java.util.ArrayList;
import java.util.List;
import entity.Choice;

public class ReadingComprehensionSession {
	private Integer index;
	String article;
	List<Choice> questions= new ArrayList<Choice>();
	
	public ReadingComprehensionSession(String article, List<Choice> questions) {
		super();
		this.article = article;
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "ReadingComprehensionSession [index=" + index + ", article="
				+ article + ", questions=" + questions + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result
				+ ((questions == null) ? 0 : questions.hashCode());
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
		ReadingComprehensionSession other = (ReadingComprehensionSession) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		return true;
	}

	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public List<Choice> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Choice> questions) {
		this.questions = questions;
	}
	
}
