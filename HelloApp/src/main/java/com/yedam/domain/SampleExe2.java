package com.yedam.domain;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.notice.domain.NoticeVO;
import com.yedam.notice.mapper.NoticeMapper;

public class SampleExe2 {
public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
//			Employee emp2 = new Employee();
//			emp2.setLastName("Hoffsdadfg");
//			emp2.setEmail("oddafdsfd@eamil");
//			emp2.setJobId("IT_PROG");
//			mapper.addEmp(emp2);
//			//session.commit();//try(....Session(true))같은 의미
//			Employee getEmp = mapper.getEmp(238);
//			System.out.println(getEmp);
//			  
//			List<Employee> list =mapper.empList();
//			for (Employee emp :list) {
//				System.out.println(emp);
//			}
			NoticeVO nvo = new NoticeVO();
//			nvo.setNoticeWriter("user00");
//			nvo.setNoticeTitle("re:test");
//			nvo.setNoticeSubject("re:글내용입니다........");
//			nvo.setNoticeId(4);
//			mapper.updateNotice(nvo);
//			mapper.deleteNotice(4);
			nvo=mapper.searchNotice(5);
			System.out.println(nvo);
			System.out.println();
			for (NoticeVO vo :mapper.noticeList()) {
				System.out.println(vo);
			}
			
			
			
		}
		
		
		
		
		
		
		
	}
}

