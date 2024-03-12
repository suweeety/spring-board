package org.zerock.security.domain;

import java.text.Collator;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.MemberVO;

import lombok.Getter;

@Getter
public class CustomUser extends User {
// Spring Security 에서 사용자 인증 및 권한 부여를 지원하는 User 클래스를 확장하여 새로운 사용자 클래스인 CustomUser 를 정의하는 것 
	private static final long serialVersionUID = 1L;

	private MemberVO member; //빈 객체 생성 

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) { 
		//사용자 이름, 비밀번호, 권한을 인자로 받아 객체 생성
		super(username, password, authorities); 
	}

	public CustomUser(MemberVO vo) {
		//MemberVO 객체를 인자로 받아
		//사용자 아이디, 비밀번호, 권한정보를 추출
		super(vo.getUserid(), vo.getUserpw(), vo.getAuthList().stream()
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList())); 
		//AuthVO 인스턴스는 GrantedAuthority 객체로 변환해야 하므로 stream()과 map()을 이용해 처리
		this.member = vo;
	}
}
