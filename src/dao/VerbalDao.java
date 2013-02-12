package dao;


import java.util.List;


import entity.Argument;
import entity.Verbal;


public interface VerbalDao {
	public Integer AddVerbal(Verbal verbal) throws Exception;

	public List<Verbal> findVerbalById(int id) throws Exception;

	public List<Verbal> findAllVerbal() throws Exception;
}
