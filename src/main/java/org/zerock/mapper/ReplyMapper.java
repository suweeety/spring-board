package org.zerock.mapper;

import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	//xml과 연동해서 sql 처리
	
	public int insert(ReplyVO vo); //vo객체를 받아 insert 처리용 인스턴스 생성
}
