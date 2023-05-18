package com.kh.mybatis.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {

	// 게시글 관련 서비스(페이징처리)
	// 1번 리스트조회

	int selectListCount();
	
	ArrayList<Board> selectList(PageInfo pi);
	
	
	// 2번 상세조회
	
	int increaseCount(int boardNo);
	
	Board selectBoard(int boardNo);
	
	ArrayList selectReplyList(int boardNo);
	
	
	
	
	
	// 게시글 검색
	
	int selectSearchCount(HashMap<String, String> map);
	
	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);
	
	
	
}