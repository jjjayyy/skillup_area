package com.mih.board.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mih.board.board.dao.BoardMapper;
import com.mih.board.board.vo.BoardVO;
import com.mih.board.board.vo.CategoryVO;
import com.mih.board.board.vo.ExcelVO;
import com.mih.board.board.vo.FileVO;
import com.mih.board.board.vo.ReplyVO;
import com.mih.board.util.ExcelRead;
import com.mih.board.util.ExcelReadOption;

@Controller
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardMapper boardDao;

	// 게시글 작성 폼
	@RequestMapping(value = "/writeForm", method = RequestMethod.GET)
	public String writeForm(HttpSession session, HttpServletRequest req) throws Exception {
		if (session.getAttribute("userId") == null) {
			return "error";
		}
		;
		List<CategoryVO> ctMajorList = boardDao.getCtMajor();
		List<CategoryVO> ctMinorList = boardDao.getCtMinor();

		req.setAttribute("ctMajorList", ctMajorList);
		req.setAttribute("ctMinorList", ctMinorList);

		return "writeForm";
	}

	// 게시글 저장
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO board, HttpSession session, List<MultipartFile> files, Model model) throws Exception {
		if (session.getAttribute("userId") == null) {
			return "error";
		}
		;

		int userNo = (Integer) session.getAttribute("userNo");
		board.setUserNo(userNo);
		boardDao.insertBoard(board);

		FileVO fvo = new FileVO();

		for (MultipartFile file : files) {
			if (file.getSize() != 0) {
				
				/*
				 * logger.info("originalName: " + file.getOriginalFilename());
				 * logger.info("size: " + file.getSize()); logger.info("contentType: " +
				 * file.getContentType());
				 */

				String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());

				fvo.setFileSize(file.getSize());
				fvo.setOriginalFileNm(file.getOriginalFilename());
				fvo.setSavedFileNm(savedName);
				boardDao.addFile(fvo);
			}
		}

		return "forward:/boardMain";
	}

	/*
	 * // 파일 다운로드
	 * 
	 * @RequestMapping(value = "/downloadFile") public void downloadFile(FileVO
	 * file, HttpServletResponse response) throws Exception { List<FileVO>
	 * fileInfoList = boardDao.getDownFile(file.getFileNo()); String storedFileName
	 * = ""; String originalFileName = ""; for (FileVO fileInfo : fileInfoList) {
	 * storedFileName = fileInfo.getSavedFileNm(); originalFileName =
	 * fileInfo.getOriginalFileNm(); } String filePath =
	 * "C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\uploadFolder\\";
	 * 
	 * byte fileByte[] = FileUtils.readFileToByteArray( new File(
	 * "C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\uploadFolder\\" +
	 * storedFileName));
	 * 
	 * response.setContentType("application/octet-stream");
	 * response.setContentLength(fileByte.length);
	 * response.setHeader("Content-Disposition", "attachment; fileName=\"\";");
	 * response.setHeader("Content-Transfer-Encoding", "binary");
	 * response.getOutputStream().write(fileByte);
	 * 
	 * response.getOutputStream().flush(); response.getOutputStream().close();
	 * 
	 * 
	 * return new HandlerFile(response, filePath, storedFileName,
	 * originalFileName).getDownloadFileByte();
	 * 
	 * }
	 */

	// 파일 다운로드(책 버전)
	@ResponseBody
	@RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(FileVO file) throws Exception {
		List<FileVO> fileInfoList = boardDao.getDownFile(file.getFileNo());
		String storedFileName = "";
		String originalFileName = "";
		for (FileVO fileInfo : fileInfoList) {
			storedFileName = fileInfo.getSavedFileNm();
			originalFileName = fileInfo.getOriginalFileNm();
		}

		FileInputStream in = null;
		ResponseEntity<byte[]> entity = null;

		logger.info("FILE NAME : " + originalFileName);

		try {
			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(
					"C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\uploadFolder\\" + storedFileName);

			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",
					"attachment; filename=\"" + new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	// 게시판 메인화면
	@RequestMapping(value = "/boardMain", method = { RequestMethod.POST, RequestMethod.GET })
	public String boardMain(HttpSession session, HttpServletRequest req,
			@RequestParam(value = "category", required = false) Integer category) throws Exception {
		if (session.getAttribute("userId") != null) {
			List<BoardVO> boardList = boardDao.getBoard();
			List<CategoryVO> ctMajorList = boardDao.getCtMajor();
			List<CategoryVO> ctMinorList = boardDao.getCtMinor();

			if (category == null && boardList != null) {
				req.setAttribute("boardList", boardList);
			} else {
				List<BoardVO> boardListCat = boardDao.getBoardListCat(category);
				req.setAttribute("boardList", boardListCat);
				req.setAttribute("ctNoMinor", category);
			}

			req.setAttribute("ctMajorList", ctMajorList);
			req.setAttribute("ctMinorList", ctMinorList);

			return "tables";
		}
		;
		return "error";
	}

	// 카테고리 등록
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCtMinor(CategoryVO category, HttpSession session) throws Exception {
		int userNo = (Integer) session.getAttribute("userNo");
		category.setUserNo(userNo);

		if (category.getCtNoMajor() == 0) {
			if (category.getCtNmMajor() != null) {
				boardDao.insertCtMajor(category);
			}
		} else {
			if (category.getCtNmMinor() != null) {
				boardDao.insertCtMinor(category);
			}
		}
		return "forward:/boardMain";
	}

	// 게시글
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(HttpSession session, @RequestParam int boardNo, Model model) throws Exception {
		if (session.getAttribute("userId") == null) {
			return "error";
		}
		;

		boardDao.updateHits(boardNo);

		List<CategoryVO> ctMajorList = boardDao.getCtMajor();
		List<CategoryVO> ctMinorList = boardDao.getCtMinor();

		model.addAttribute("ctMajorList", ctMajorList);
		model.addAttribute("ctMinorList", ctMinorList);

		List<BoardVO> boardDetail = boardDao.getBoardDetail(boardNo);
		model.addAttribute("boardDetail", boardDetail);
		model.addAttribute("boardNo", boardNo);

		List<FileVO> fileList = boardDao.getFile(boardNo);
		model.addAttribute("fileList", fileList);

		return "boardDetail";
	}

	// 게시글 수정 폼
	@RequestMapping(value = "/editForm", method = RequestMethod.GET)
	public String editForm(HttpSession session, HttpServletRequest req, @RequestParam int boardNo) throws Exception {
		if (session.getAttribute("userId") == null) {
			return "error";
		}
		;
		List<CategoryVO> ctMajorList = boardDao.getCtMajor();
		List<CategoryVO> ctMinorList = boardDao.getCtMinor();

		req.setAttribute("ctMajorList", ctMajorList);
		req.setAttribute("ctMinorList", ctMinorList);

		List<BoardVO> boardDetail = boardDao.getBoardDetail(boardNo);
		req.setAttribute("boardDetail", boardDetail);

		return "editForm";
	}

	// 게시글 수정
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(BoardVO board) {
		boardDao.editArticle(board);
		return "redirect:/boardMain";
	}

	// 게시글 삭제
	@RequestMapping(value = "/deleteArticle", method = RequestMethod.GET)
	public String deleteArticle(@RequestParam int boardNo) {
		File file = new File(null);
		
		boardDao.deleteArticle(boardNo);
		return "redirect:/boardMain";
	}

	// 댓글 입력
	@RequestMapping(value = "/addReply", method = RequestMethod.POST)
	public @ResponseBody void addReply(ReplyVO reply, HttpSession session) {
		int userNo = (Integer) session.getAttribute("userNo");
		String userNm = (String) session.getAttribute("userNm");
		reply.setUserNo(userNo);
		reply.setUserNm(userNm);

		int depth = reply.getDepth();
		int parentNo = reply.getReNo();
		if (reply.getReNo() != 0) {
			reply.setDepth(depth + 1);
			reply.setParentReNo(parentNo);
		}
		boardDao.insertReply(reply);

	}

	// 댓글 수정
	@RequestMapping(value = "/editReply", method = RequestMethod.GET)
	public @ResponseBody void editReply(ReplyVO reply) {
		boardDao.editReply(reply);
	}

	// 댓글 삭제
	@RequestMapping(value = "/deleteReply", method = RequestMethod.GET)
	public @ResponseBody void deleteReply(@RequestParam int reNo) {
		boardDao.deleteReply(reNo);
	}

	// 댓글 불러오기
	@RequestMapping(value = "/replyList", method = RequestMethod.GET)
	public @ResponseBody List<ReplyVO> replyList(@RequestParam int boardNo) {
		List<ReplyVO> replyList = boardDao.getReply(boardNo);
		return replyList;
	}

// 파일 업로드
private String uploadFile(String originalName, byte[] fileData) throws Exception {
	/*
	 * 고유한 랜덤 값 생성해서 같은 이름의 파일 입력 방지
	 */
	UUID uid = UUID.randomUUID();

	Calendar cal = Calendar.getInstance();

	String savedName = uid.toString() + "_" + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH)
			+ cal.get(Calendar.DATE) + "_" + originalName;
	File target = new File("C:\\Users\\user\\Documents\\workspace-sts-3.9.5.RELEASE\\uploadFolder", savedName);
	/*
	 * FileCopyUtils -> 스프링에서 제공하는 util(?)
	 */
	FileCopyUtils.copy(fileData, target);

	ExcelReadOption excelReadOption = new ExcelReadOption();
	
	String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
	
	if(formatName.equalsIgnoreCase("xls") || formatName.equalsIgnoreCase("xlsx")) {
        /*
         * cell 이름은 사실상 cell넘버를 String으로 바꿔서 A B C D... 로 지정됨
         * setOutputColumns.contain()을 통해서 불러올 cell 이름에 있는지 확인
         * 있으면 Map.put 없으면 건너뜀.
         * 
         */
		ExcelVO excelData = new ExcelVO();
		SimpleDateFormat transFormat = new SimpleDateFormat();
		
		List<String> outputColumns = new ArrayList();
		
		for(char column = 'A'; column <= 'Z'; column++) {
			outputColumns.add(String.valueOf(column));
		}
		
        excelReadOption.setFilePath(target.getAbsolutePath());
        excelReadOption.setOutputColumns(outputColumns);
        excelReadOption.setStartRow(2);
        
        List<Map<String, String>>excelContent =ExcelRead.read(excelReadOption);
        
        for(Map<String, String> info : excelContent){

        	excelData.setRowId((int)Double.parseDouble(info.get("A")));
        	excelData.setOrderId(info.get("B"));
        	Date orderDate = transFormat.parse(info.get("C"));
        	excelData.setOrderDate(orderDate);
        	Date shipDate = transFormat.parse(info.get("D"));
        	excelData.setShipDate(shipDate);
        	excelData.setShipMode(info.get("E"));
        	excelData.setCustomerId(info.get("F"));
        	excelData.setCustomerName(info.get("G"));
        	excelData.setSegment(info.get("H"));
        	excelData.setCountry(info.get("I"));
        	excelData.setCity(info.get("J"));
        	excelData.setState(info.get("K"));
        	excelData.setPostalCode((int)Double.parseDouble(info.get("L")));
        	excelData.setRegion(info.get("M"));
        	excelData.setProductId(info.get("N"));
        	excelData.setCategory(info.get("O"));
        	excelData.setSubCategory(info.get("P"));
        	excelData.setProductName(info.get("Q"));
        	excelData.setSales(Double.parseDouble(info.get("R")));
        	excelData.setQuantity((int)Double.parseDouble(info.get("S")));
        	excelData.setDiscount(Double.parseDouble(info.get("T")));
        	excelData.setProfit(Double.parseDouble(info.get("U")));

        	boardDao.insertExcel(excelData);
        }
	}
	return savedName;
}
}
