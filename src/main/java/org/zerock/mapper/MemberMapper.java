package org.zerock.mapper;

import java.lang.reflect.Member;

import org.zerock.domain.MemberVO;

public interface MemberMapper {
	public MemberVO read(String userid);
}
