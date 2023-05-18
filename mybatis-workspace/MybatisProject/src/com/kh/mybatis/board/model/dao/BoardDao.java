package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi){
//		return sqlSession.selectList("boardMapper.selectListCount");
		
		// 마이바티스에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공한다.
		
		// * offset : 몇 개의 게시글을 건너뛰고 조회할건지에 대한 값
		/*
		 * ex) boardLimit이 5일 경우
		 * 									offset(건너뛸숫자)
		 * currentPage : 1 -> 1 ~ 5				0
		 * currentPage : 2 -> 6 ~ 10			5
		 * currentPage : 3 -> 11 ~ 15			10
		 * 
		 */
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		// RowBounds객체를 넘겨야 할 경우
		// selectList메소드의 오버로딩 된 형태 중 매개변수가 3개인 메소드를 꼭꼭 반드시 꼭 사용해야함
		// 딱히 두 번째 매개변수 자리에 넘길값이 없다면 null값을 넘기면 됨
		
		// RowBounds : offset만큼 건너뛰기 위해 전체 데이터를 조회한 후 건너뜀 -> 데이터 양이 많아질 수록 성능이 저하
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	
	public int increaseCount(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseCount", boardNo);
	}
	
	public Board selectBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession, int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession, 
			                                 HashMap<String, String> map, 
			                                 PageInfo pi){
		return (ArrayList)sqlSession
				.selectList("boardMapper.selectSearchList", 
						    map, 
						    new RowBounds((pi.getCurrentPage() - 1) * pi.getBoardLimit(), pi.getBoardLimit()));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
