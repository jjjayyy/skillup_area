package com.mih.board.board.dao;

import java.util.List;

import com.mih.board.board.vo.BoardVO;
import com.mih.board.board.vo.CategoryVO;
import com.mih.board.board.vo.ExcelVO;
import com.mih.board.board.vo.FileVO;
import com.mih.board.board.vo.ReplyVO;

public interface BoardMapper {
	//게시글 등록
	public void insertBoard(BoardVO board) throws Exception;
	
	//게시글 리스트 불러오기
	public List<BoardVO> getBoard() throws Exception;
	
	//카테고리 등록(top)
	public void insertCtMajor(CategoryVO category) throws Exception;
	
	//카테고리 불러오기(top)
	public List<CategoryVO> getCtMajor() throws Exception;
	
	//카테고리 등록(bottom)
	public void insertCtMinor(CategoryVO category) throws Exception;
	
	//카테고리 불러오기(bottom)
	public List<CategoryVO> getCtMinor() throws Exception;
	
	//게시글 불러오기
	public List<BoardVO> getBoardDetail(int boardNo);
	
	//카테고리별 게시글 리스트 불러오기
	public List<BoardVO> getBoardListCat(int category);
	
	//조회수 올리기
	public int updateHits(int boardNo);
	
	//게시글 수정
	public void editArticle(BoardVO board);
	
	//글 삭제
	public void deleteArticle(int boardNo);
	
	//댓글 입력
	public void insertReply(ReplyVO reply);
	
	//댓글 출력
	public List<ReplyVO> getReply(int boardNo);
	
	//댓글 삭제
	public void deleteReply(int reNo);
	
	//댓글 수정
	public void editReply(ReplyVO reply);
	
	//댓글 갯수
	public int getReplyCnt(int boardNo);
	
	//첨부파일 저장
	public void addFile(FileVO file);
	
	//첨부파일 불러오기
	public List<FileVO> getFile(int boardNo);
	
	//첨부파일 다운로드
	public List<FileVO> getDownFile(int fileNo);
	
	//엑셀 data 저장
	public void insertExcel(ExcelVO excel);
}
