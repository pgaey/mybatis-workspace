package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		/*
		 * int result = 0;
		 * PreparedStatement pstmt = null;
		 * String sql = prop.getProperty("insertmember");
		 * 
		 * try{
		 * 	pstmt = conn.prepareStatement(sql);
		 * 	pstmt.setString(1, m.getUserId());
		 * 	...
		 * 
		 * 	result = pstmt.executeUpdate();
		 * 
		 * } catch(Exceqtion e)
		 * ...
		 * ...
		 * ...
		 * 
		 * return result; 
		 */
		
		/*
		 * sqlSession이 제공하는 메소드를 통해 sql문을 찾아서 실행하고 결과를 바로 받아볼 수 있음
		 * 
		 * sql.Session.sql문 종류에 맞는 메소드("매퍼파일의 namespace.해당sql문의 고유한 id");
		 * 
		 */
//		int result = sqlSession.insert("memberMapper.insertMember", m);
		return sqlSession.insert("memberMapper.insertMember", m);
		
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		
//		Member loginUser = sqlSession.selectOne("memberMapper.loginMember", m);
//		return loginUser;
		
		// selectOne() : 조회결과가 없다면 null 반환
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
