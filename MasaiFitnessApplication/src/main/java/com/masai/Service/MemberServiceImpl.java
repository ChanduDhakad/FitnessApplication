package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.MemberException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.LoginDTO;
import com.masai.Model.Member;
import com.masai.Model.Trainer;
import com.masai.Repository.MemberRepo;
import com.masai.Repository.SessionRepo;
import com.masai.Repository.SlotRepo;
import com.masai.Repository.TrainerRepo;

import net.bytebuddy.utility.RandomString;

public class MemberServiceImpl implements MemberService{

	
	
	@Autowired 
	private SlotRepo slotRepo;
	
	@Autowired
	private TrainerRepo trainerRepo;
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private SessionRepo sessionRepo;
	
	
	
	

	
	
	
	@Override
	public Member newRegisterMember(Member member) throws MemberException {
		
		Member isMemberPresent=memberRepo.findByEmail(member.getEmail());
	     if(isMemberPresent == null) {
	    	 Member newmember=memberRepo.save(member);	
		 		return newmember; 
		     }  
		    else 
		     { 
		    	 throw new MemberException("Member alredy registered  with Given email ID "+member.getEmail());
		     }
	}

	@Override
	public Member loginMember(LoginDTO loginDTO) throws MemberException {
	
		Member isMemberPresent=memberRepo.findByEmail(loginDTO.getEmail());
		if(isMemberPresent != null) {
		  if(loginDTO.getPassword().equals(isMemberPresent.getPassword())) {
			  String key=RandomString.make(6);
			  CurrentUserSession newLoginUser=new CurrentUserSession(isMemberPresent.getMemberId(),key ,LocalDateTime.now());
			   sessionRepo.save(newLoginUser);
		  }
		  else {
				throw new MemberException("Password is not Correct");
		  }	
		}
		else {
			throw new MemberException("Member name is not Correct");
			
		}
		return isMemberPresent;
	}

	

}
