package dao;


import java.util.List;


import entity.Math;


public interface MathDao {
	public Integer AddMath(Math math) throws Exception;

	public List<Math> findMathById(int id) throws Exception;

	public List<Math> findAllMath() throws Exception;
}
