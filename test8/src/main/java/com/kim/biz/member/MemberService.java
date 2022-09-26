package com.kim.biz.member;

import java.util.List;

public interface MemberService {
	void insertMember(MemberVO vo);
	void deleteMember(MemberVO vo);
	void updateMember(MemberVO vo);
	MemberVO selectOneMember(MemberVO vo);
	List<MemberVO> selectAllMember(MemberVO vo);
}
