package dao.jdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import util.DBUtil;
import util.JdbcUtil;
import dao.IssueDao;
import entity.Issue;



public class JdbcIssueDao implements IssueDao {
	private void ClearIssuePool(){
		String clear="delete from issue_pool";
		Connection cn=null;	
		Statement stmt=null;
		ResultSet rs1=null;
		try{
			cn= JdbcUtil.getConnection();	
			 stmt=cn.createStatement();
			stmt.execute(clear);
			System.out.println(rs1);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(cn);
		}
		
		
	}
	
	public Integer UpdateDBIssuePool(List<Issue> issues){
		ClearIssuePool();
		int rs2[] = null;
		String insert="insert into issue_pool(passage,question,pool_date) values(?,?,?)";
		Connection cnn=null;
		
		try{
		cnn= JdbcUtil.getConnection();
		cnn.setAutoCommit(false);
		PreparedStatement  pstm=null;
		
		int index=0;
		System.out.println("issue size"+issues.size());
		for (Issue e:issues){
			index++;

			//System.out.println(e);
		 pstm=cnn.prepareStatement(insert);
		 pstm.setString(1,e.getPassage());
		 pstm.setString(2,e.getQuestion());
		 pstm.setDate(3, new Date (System.currentTimeMillis()));
		 pstm.addBatch();

		 if(index%1==0){
			 pstm.executeBatch();
			 cnn.commit();
			 pstm.clearBatch();
			 System.out.println(index+"   ");
			}
	
		}
		pstm.executeBatch();
		 pstm.clearBatch();
			 cnn.commit();
			   cnn.setAutoCommit(true);  
			   System.out.println("done   ");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			JdbcUtil.close(cnn);
		}
		return 0;
	}
	public Integer AddIssue(Issue issue) {
		String sql="insert into issue(id_in_pool,frequence,passage,question,answer,answer_info,catagory,history_date)"+"values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstm=null;
		int rs=100;
		try {
			pstm = DBUtil.getConnection().prepareStatement(sql);
			int index=1;
			pstm.setInt(index++,issue.getIdInPool());
			pstm.setInt(index++,issue.getFrequence());
			pstm.setString(index++,issue.getPassage());
			pstm.setString(index++, issue.getQuestion());
			pstm.setString(index++, issue.getAnswere());
			pstm.setString(index++, issue.getAnswereInfo());
			pstm.setString(index++, issue.getCatagory());
			pstm.setString(index++,issue.getHistoryDate().toString());
			 rs=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	

	public List<Issue> findIssueById(int id)  {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Issue> findAllIssue() {
	List<Issue> issues = new ArrayList<Issue>();
		
		PreparedStatement pstm;
		try {
			pstm = DBUtil.getConnection().prepareStatement("select * from issue");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){

				Issue a= new Issue(rs.getInt("id"),rs.getInt("id_in_pool"), rs.getInt("frequence"),rs.getString("passage"), rs.getString("question"), rs.getString("answer"), rs.getString("answer_info"), rs.getString("catagory"), rs.getDate("history_date"),rs.getInt("taken")==0? false:true);	
				issues.add(a);
			}
			System.out.println("find All book/n"+issues);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return issues;
	}




}
