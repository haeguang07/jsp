package com.yedam.notice.contorl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServieImpl;

public class NoticeAddControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//db처리 /목록이동
		//멀티파트요청:요청정보req, 저장경로, 최대파일사이즈, 인코딩방식, 리네임정책인스턴스
		String saveDir=req.getServletContext().getRealPath("images");
		int maxSize = 5* 1024*1024;
		String encoding="UTF-8";
		DefaultFileRenamePolicy rn= new DefaultFileRenamePolicy();
		MultipartRequest multi= new MultipartRequest(req, saveDir,maxSize,encoding,rn);
		String writer = multi.getParameter("writer");
		String subject = multi.getParameter("subject");
		String title = multi.getParameter("title");
		String attach = multi.getFilesystemName("attach");
		
		NoticeVO vo =new NoticeVO();
		vo.setNoticeWriter(writer);
		vo.setNoticeSubject(subject);
		vo.setNoticeTitle(title);
		vo.setAttachFile(attach);
		NoticeService service = new NoticeServieImpl();
		//정상처리 -> 목록 이동.
		//아닐정우 메인페이지로
		if(service.addNotice(vo)) {
			return "noticeList.do";
		}else {
			return "main.do";
		}
	
	}

}
