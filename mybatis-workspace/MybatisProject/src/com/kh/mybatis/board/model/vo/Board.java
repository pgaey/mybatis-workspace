package com.kh.mybatis.board.model.vo;

import java.sql.Date;

public class Board {

	private int boardNo; //BOARD_NO	NUMBER
	private String boardTitle; //BOARD_TITLE	VARCHAR2(100 BYTE)
	private String boardContent; // BOARD_CONTENT	VARCHAR2(4000 BYTE)
	private String boardWriter; // BOARD_WRITER	NUMBER
	private int count; // COUNT	NUMBER
	private Date createDate; //CREATE_DATE	DATE
	private String Status; // STATUS	VARCHAR2(1 BYTE)
	
	public Board() {
		super();
	}
	
	public Board(int boardNo, String boardTitle, String boardContent, String boardWriter, int count, Date createDate,
			String status) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.count = count;
		this.createDate = createDate;
		Status = status;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", count=" + count + ", createDate=" + createDate + ", Status="
				+ Status + "]";
	}
	
	
}
