package com.mih.board.board.vo;

public class FileVO {
	private int fileNo;
	private String originalFileNm;
	private String savedFileNm;
	private double fileSize;
	private int boardNo;
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getOriginalFileNm() {
		return originalFileNm;
	}
	public void setOriginalFileNm(String originalFileNm) {
		this.originalFileNm = originalFileNm;
	}
	public String getSavedFileNm() {
		return savedFileNm;
	}
	public void setSavedFileNm(String savedFileNm) {
		this.savedFileNm = savedFileNm;
	}

	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
}
