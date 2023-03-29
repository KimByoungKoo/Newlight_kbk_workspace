package com.newlight.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.newlight.app.dto.CreationsDTO;
import com.newlight.app.dto.CreationsVO;

public class CreationsDAO {
	public SqlSession sqlSession;
	
	public CreationsDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public int select(CreationsDTO creationDTO) {
		return sqlSession.selectOne("creations.select");
	}
	
	public void delete(int memberNumber) {
		sqlSession.delete("creations.delete", memberNumber);
	}
	
	public CreationsVO select(int creationNumber) {
		return sqlSession.selectOne("creation.select", creationNumber);
	}
	
	public void insert(CreationsDTO creationDTO) {
		sqlSession.insert("creations.insert", creationDTO);
	}
	
	public int getSequence() {
		return sqlSession.selectOne("creations.getSequence");
	}

	public List<CreationsVO> selectAll(Map<String, Integer> creationMap){
		return sqlSession.selectList("creation.selectAll", creationMap);
	}
}