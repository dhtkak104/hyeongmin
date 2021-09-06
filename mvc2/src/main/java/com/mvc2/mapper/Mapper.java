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
	/* SqlSessionTemplate 
	 * C(CREATE) : sqlSession.insert(쿼리경로, 파리미터);
	 * R(READ)	 : sqlSession.selectOne(쿼리경로, 파리미터); / sqlSession.selectList(쿼리경로, 파리미터); 
	 * U(UPDATE) : sqlSession.update(쿼리경로, 파리미터);
	 * D(DELETE) : sqlSession.delete(쿼리경로, 파리미터);
	 */ 
	
	public Map<String, Object> selectbbs(Map<String, Object> param) {
		return sqlSession.selectOne("mapper.bbsMapper.selectBbs", param);
	}
	
	public List<Map<String, Object>> selectbbsList(Map<String, Object> param) {
		return sqlSession.selectList("mapper.bbsMapper.selectBbsList", param);
	}
	
}
