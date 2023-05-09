package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {

	// 회원가입용 메소드
	int insertMember(Member m);
	
	// 로그인용 메소드
	Member loginMember(Member m);
	
	
}
