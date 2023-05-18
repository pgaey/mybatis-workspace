package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Template;

public class BoardServiceImpl implements BoardService {

	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.selectListCount(sqlSession);
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		sqlSession.close();
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.increaseCount(sqlSession, boardNo);
		if(result > 0) sqlSession.commit();
		sqlSession.close();
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Board b = boardDao.selectBoard(sqlSession, boardNo);
		sqlSession.close();
		return b;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Reply> list = boardDao.selectReplyList(sqlSession, boardNo);
		sqlSession.close();
		return list;
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = boardDao.selectSearchCount(sqlSession, map);
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Board> list = boardDao.selectSearchList(sqlSession, map, pi);
		sqlSession.close();
		return list;
	}

}
