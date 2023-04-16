package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.SlotException;
import com.masai.Model.Member;
import com.masai.Model.Slot;
import com.masai.Model.Trainer;
import com.masai.Repository.MemberRepo;
import com.masai.Repository.SessionRepo;
import com.masai.Repository.SlotRepo;
import com.masai.Repository.TrainerRepo;

public class SlotServiceImpl implements SlotService{

	
	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private SessionRepo sessionRepo;
	
	@Autowired 
	private SlotRepo slotRepo;
	
	@Autowired
	private TrainerRepo trainerRepo;
	
	
	
	
	@Override
	public Slot deleteASlot(Integer slotId) throws SlotException {
		
	  Optional<Slot> optSlot=slotRepo.findById(slotId);
	 Slot slot=null;
       if(optSlot.isPresent()) {
    	   slot=optSlot.get();
    	   Optional<Member> isMemberPresent=memberRepo.findById(slot.getMember().getMemberId());
    	    Member member=isMemberPresent.get();
    	     Optional<Trainer> isTrainerPresent=trainerRepo.findById(slot.getTrainer().getTrainerId());
    	     Trainer trainer=isTrainerPresent.get();
    	    
    	     
    	     List<Slot> slots=trainer.getListOfSlots();
    	     
    	     for(Slot newSlot:slots) {
    	    	 
    	    	 if(newSlot.getSlotNo()==member.getSlot().getSlotNo()) {
    	    		 
    	    		 newSlot.setMember(null);
    	    		 
    	    	 }
    	    	 else {
    	    		 slots.add(newSlot);
    	    	 }
    	    	 
    	     }
    	     
    	     trainer.setListOfSlots(slots);
    	     member.setSlot(null);
    	     slot.setMember(null); 
    	     
       }
       else {
    	   
    	   throw new SlotException(" Slot id  is not match or invalid ");
    	   
       }
		
		
		
       return slot;
	}
  

}
