package com.choa.notice;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import com.choa.util.PageMaker;

@Service
//NoticeService noticeService = new NoticeService();
public class NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	/*//Constructor
	public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	//setter
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}*/
	
	
	//view
	public NoticeDTO noticeView(int num) throws Exception{
		
		
		return noticeDAO.noticeView(num);
	}
	

	//list
	public List<NoticeDTO> noticeList(int curPage) throws Exception{
		int result = noticeDAO.noticeCount();
		PageMaker pageMaker = new PageMaker(curPage, result);
		
		
		return noticeDAO.noticeList(pageMaker.getRowMaker());
	}
	
	//write
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeWrite(noticeDTO);
	}
	
	//update
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	
	//delete
	public int noticeDelete(int num){
		return noticeDAO.noticeDelete(num);
	}
	

}
