package entity;

import java.util.Date;

public class Argument extends Entry {
	public Argument(){
		
	}
	public Argument(Integer id, Integer idInPool, Integer frequence,
			String passage, String question, String answere,
			String answereInfo, String catagory, Date historyDate, Boolean taken) {
		super(id, idInPool, frequence, passage, question, answere, answereInfo,
				catagory, historyDate, taken);
		// TODO Auto-generated constructor stub
	}


	

}
