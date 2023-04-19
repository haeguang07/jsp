package com.yedam.domain;

import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.service.NoticeServieImpl;

public class SampleExe3 {

	public static void main(String[] args) {
		NoticeService service = new NoticeServieImpl();
		for(NoticeVO vo:service.noticeList()) {
			System.out.println(vo);
		}
	}

}
