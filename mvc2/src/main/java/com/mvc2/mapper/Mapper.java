package com.mvc2.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Mapper {

	@Autowired
	protected SqlSessionTemplate sqlSession;
	
	public Map<String, Object> selectbbs(Map<String, Object> param) {
		return sqlSession.selectOne("mapper.bbsMapper.selectBbs", param);
	}
	
	public List<Map<String, Object>> selectbbsList(Map<String, Object> param) {
		return sqlSession.selectList("mapper.bbsMapper.selectBbsList", param);
	}
	
}
