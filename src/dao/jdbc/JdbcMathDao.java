package dao.jdbc;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import dao.MathDao;

import util.DBUtil;



import entity.Math;



public class JdbcMathDao implements MathDao {

	
	public Integer AddMath(Math math) throws Exception {
		String sql="insert into math(frequence,picture,question,answer,answer_info,catagory,history_date)"+"values(?,?,?,?,?,?,?)";
		PreparedStatement pstm= DBUtil.getConnection().prepareStatement(sql);
		int index=1;
		pstm.setInt(index++,math.getFrequence());
		pstm.setString(index++,math.getPicture());
		pstm.setString(index++, math.getQuestion());
		pstm.setString(index++, math.getAnswere());
		pstm.setString(index++, math.getAnswereInfo());
		pstm.setString(index++, math.getCatagory());
		pstm.setString(index++,math.getHistoryDate().toString());
		
		int rs=pstm.executeUpdate();
		return rs;
	}

	

	public List<Math> findMathById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Math> findAllMath() throws Exception {
	List<Math> maths = new ArrayList<Math>();
		
		PreparedStatement pstm= DBUtil.getConnection().prepareStatement("select * from math");
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){

			Math a= new Math(rs.getInt("id"),rs.getInt("frequence"),rs.getString("picture"), rs.getString("question"), rs.getString("answer"), rs.getString("answer_info"), rs.getString("catagory"), rs.getDate("history_date"),rs.getInt("taken")==0? false:true);	
			maths.add(a);
		}
		System.out.println("find All book/n"+maths);
		return maths;
	}




}
