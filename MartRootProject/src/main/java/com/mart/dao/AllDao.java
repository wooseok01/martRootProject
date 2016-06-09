package com.mart.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mart.mapper.AllDaoInterface;
import com.mart.model.BigCategory;
import com.mart.model.FloorData;
import com.mart.model.SecondCategory;
import com.mart.model.ThirdCategory;

public class AllDao {
	private JdbcTemplate template;
	private SqlSession sqlSession;
	
	public AllDao(){}
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {this.template = template;}
	public JdbcTemplate getTemplate() {return template;}

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {this.sqlSession = sqlSession;}
	public SqlSession getSqlSession() {return sqlSession;}

	public ArrayList<BigCategory> getBigCategory() {
		return sqlSession.getMapper(AllDaoInterface.class).getBigCategory();
	}

	public ArrayList<SecondCategory> getSecondCategory(int bId) {
		return sqlSession.getMapper(AllDaoInterface.class).getSecondCategory(bId);
	}

	public ArrayList<SecondCategory> getThirdCategory(int bId) {
		return sqlSession.getMapper(AllDaoInterface.class).getThirdCategory(bId);
	}

	public ArrayList<SecondCategory> getAllSecondCategory() {
		return sqlSession.getMapper(AllDaoInterface.class).getAllSecondCategory();
	}

	public ArrayList<ThirdCategory> getAllThirdCategory() {
		return sqlSession.getMapper(AllDaoInterface.class).getAllThirdCategory();
	}

	public ArrayList<FloorData> getThirdFloorData() {
		return sqlSession.getMapper(AllDaoInterface.class).getThirdFloorData();
	}

	public ArrayList<FloorData> getThirdFloorProductList(String selected) {
		return sqlSession.getMapper(AllDaoInterface.class).getThirdFloorProductList(selected);
	}

	public ArrayList<FloorData> getSecondFloorProductList(String selected) {
		return sqlSession.getMapper(AllDaoInterface.class).getSecondFloorProductList(selected);
	}

	public FloorData getEntrance(int floor) {
		return sqlSession.getMapper(AllDaoInterface.class).getEntrance(floor);
	}

	public ArrayList<FloorData> getSecondFloorData() {
		return sqlSession.getMapper(AllDaoInterface.class).getSecondFloorData();
	}
}
