package dao;


import java.util.List;

import entity.Issue;

public interface IssueDao {
	public Integer AddIssue(Issue issue) throws Exception;
	public Integer UpdateDBIssuePool(List<Issue> issues);

	public List<Issue> findIssueById(int id) throws Exception;

	public List<Issue> findAllIssue() throws Exception;
}
