package dao.jdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import dao.VerbalDao;

import util.DBUtil;



import entity.Verbal;



public class JdbcVerbalDao implements VerbalDao {

	
	public Integer AddVerbal(Verbal verbal) throws Exception {
		String sql="insert into verbal(question,choice,answer,answer_info,history_date,frequence) values(?,?,?,?,?,?)";
		PreparedStatement pstm= DBUtil.getConnection().prepareStatement(sql);
		int index=1;
		pstm.setString(index++,verbal.getQuestion());
		pstm.setString(index++,verbal.getChoicesToString());
		pstm.setString(index++, verbal.getAnswersToString());
		pstm.setString(index++, verbal.getAnswerInfo());
		pstm.setString(index++,verbal.getHistoryDate().toString());
		pstm.setInt(index++,verbal.getFrequence());
		int rs=pstm.executeUpdate();
		return rs;
	}

	

	public List<Verbal> findVerbalById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Verbal> findAllVerbal() throws Exception {
	List<Verbal> verbals = new ArrayList<Verbal>();
		
		PreparedStatement pstm= DBUtil.getConnection().prepareStatement("select * from verbal");
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			Verbal a= new Verbal();
			a.setId(rs.getInt("id"));
			a.setAnswer(a.parseAnswer(rs.getString("answer")));
			a.setAnswerInfo(rs.getString("answer_info"));
			a.setChoice(a.parseChoice(rs.getString("choice")));
			a.setQuestion(rs.getString("question"));
			a.setTaken(rs.getInt("taken")==0? false:true);
			a.setFrequence(rs.getInt("freguence"));
			a.setHistoryDate(rs.getDate("history_date"));
			verbals.add(a);
		}
		System.out.println("find All book/n"+verbals);
		return verbals;
	}




}
