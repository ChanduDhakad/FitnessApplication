package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Member;


public interface MemberRepo extends JpaRepository<Member, Integer>{

	public Member findByEmail(String email);
	

}
