package com.masai.Service;

import com.masai.Exception.MemberException;
import com.masai.Model.LoginDTO;
import com.masai.Model.Member;

public interface MemberService {

public Member newRegisterMember(Member member)throws MemberException;

public Member loginMember(LoginDTO loginDTO)throws MemberException;




}
