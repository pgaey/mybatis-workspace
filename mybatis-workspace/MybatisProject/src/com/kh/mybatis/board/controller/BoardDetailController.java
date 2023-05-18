package com.kh.mybatis.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		// 다형성을 적용
		BoardService boardService = new BoardServiceImpl(); // impl의 부모자료형인 service가 받아주고 있음 -> 다형성기술 적용
		
		// 1. 조회수를 증가시킴 (UPDATE)
		if(boardService.increaseCount(boardNo) > 0) {
			// 2. 해당 게시글을 조회해야함 (SELECT)
			request.setAttribute("b", boardService.selectBoard(boardNo));
			
			// 3. 해당 게시글에 달린 댓글들을 조회해야함 (SELECT)
			request.setAttribute("list", boardService.selectReplyList(boardNo));
			request.getRequestDispatcher("WEB-INF/views/board/boardDetailView.jsp").forward(request, response);;
		} else {
			request.setAttribute("errorMsg", "조회 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
