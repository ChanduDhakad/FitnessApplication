package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.*;
import com.masai.Exception.MemberException;
import com.masai.Exception.SlotException;
import com.masai.Exception.TrainerException;
import com.masai.Model.LoginDTO;
import com.masai.Model.Member;
import com.masai.Model.Slot;
import com.masai.Model.Trainer;
import com.masai.Service.MemberService;
import com.masai.Service.SlotService;
import com.masai.Service.TrainerService;



@RestController
public class MasaifitnessController {

	

	@Autowired
	private MemberService  ms;
	
	@Autowired
	private SlotService ss;
	
	@Autowired 
	private TrainerService ts;
	

	
	
	@PostMapping("/masaifitness/register") 
	public ResponseEntity<Member> registerMember(@Valid @RequestBody Member member) throws MemberException{
		Member res = ms.newRegisterMember(member);
		return new ResponseEntity<Member>(res, HttpStatus.CREATED);
			
	}
	
	@PostMapping("/masaifitness/login")
	public ResponseEntity<Member> loginMember(@Valid @RequestBody LoginDTO credential) throws MemberException{
             Member res = ms.loginMember(credential);
		return new ResponseEntity<Member>(res, HttpStatus.OK);
			
	}
 
	@GetMapping("/masaifitness/slot")
	public  ResponseEntity<Slot> deleteASlot(@PathVariable("slotId") Integer slotId) throws SlotException{
		Slot res = ss.deleteASlot(slotId);
		return new ResponseEntity<Slot>(res, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/masaifitness/trainers/available") 
	public ResponseEntity<Trainer> newRegisterTrainer(@Valid @RequestBody Trainer member) throws MemberException, TrainerException{
		Trainer res = ts.newRegisterTrainer(member);
		return new ResponseEntity<Trainer>(res, HttpStatus.CREATED);
			
	}
	
	@PostMapping("/masaifitness/trainer")
	public ResponseEntity<List<Trainer>> findMostEarnTrainer() throws TrainerException {
             List<Trainer> res = ts.findMostEarnTrainer();
		return new ResponseEntity<List<Trainer>>(res, HttpStatus.OK);
			
	}
 
	@GetMapping("/masaifitness/slot")
	public  ResponseEntity< List<Trainer>> trainerPromotion() throws SlotException, TrainerException{
		 List<Trainer> res = ts.trainerPromotion();
		return new ResponseEntity< List<Trainer>>(res, HttpStatus.OK);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
