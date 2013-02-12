package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;



public class Verbal extends Choice {
	public Verbal(){
		
	}

	public Verbal(Integer id, String question, Map<Character, String> choice,
			List<Character> answer, String answerInfo, Date historyDate,
			Integer frequence, Boolean taken) {
		super(id, question, choice, answer, answerInfo, historyDate, frequence, taken);
		// TODO Auto-generated constructor stub
	}

	public String  getAnswersToString(){
		List<Character> answers= getAnswer();
		String answer="";
		for(Character a:answers){
			answer+=a+";";
		}
		return answer;
		
	}
	
	public String getChoicesToString(){
		Map<Character,String> choices= getChoice();
		String choice="";
		Set<Entry<Character,String>> entrySet=choices.entrySet();
		List<Entry<Character,String>> list=new ArrayList<Entry<Character,String>>(entrySet);

		for(Iterator<Entry<Character,String>> it = list.iterator();it.hasNext();){
			Entry<Character,String> entry = it.next();
		//	char ch = entry.getKey();
			choice+= entry.getValue()+";";
		//	System.out.println(choice);
		}
	
		return choice;
		
	}
	
	public  Map<Character,String> parseChoice(String choice){
		Map<Character,String> choices= new HashMap<Character,String>();
		choice=choice+";";
		String cs[]=choice.trim().split(";");
		Character key= 'a';
		for (int i=0;i<cs.length;i++){
			if(!cs[i].equals("")){
			char index=(char)(i+65);
		//	System.out.println(index+cs[i]);
			choices.put(index, cs[i]);
			}
		}
		return choices;
		
	}
	public List<Character> parseAnswer(String answer){
		List<Character> answers = new ArrayList<Character>();
		answer=answer+";";
		String temp[]=answer.trim().split(";");
		for (int i=0;i<temp.length;i++){
			if (!temp[i].equals("")){
	
			//char index=temp[i].toCharArray()[0];
			char index=temp[i].charAt(0);
		//	System.out.println(index);
			answers.add(index);
			}
		}
		
		return answers;
	}
}
