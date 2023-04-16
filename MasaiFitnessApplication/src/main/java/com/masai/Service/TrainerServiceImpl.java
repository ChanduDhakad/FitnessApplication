package com.masai.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.Exception.MemberException;
import com.masai.Exception.SlotException;
import com.masai.Exception.TrainerException;
import com.masai.Model.Member;
import com.masai.Model.Slot;
import com.masai.Model.Trainer;
import com.masai.Model.TrainerType;
import com.masai.Repository.MemberRepo;
import com.masai.Repository.SessionRepo;
import com.masai.Repository.SlotRepo;
import com.masai.Repository.TrainerRepo;

public class TrainerServiceImpl implements TrainerService {

	

	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private SessionRepo sessionRepo;
	
	@Autowired 
	private SlotRepo slotRepo;
	
	@Autowired
	private TrainerRepo trainerRepo;
	
	
	
	@Override
	public Trainer newRegisterTrainer(Trainer trainer) throws TrainerException {
		Trainer isTrainerPresent= trainerRepo.findByEmail(trainer.getEmail());
	     if(isTrainerPresent == null) {
	             	 
	    	 Trainer newTrainer=null;
	    	 if(trainer.getTrainerType().equals(TrainerType.PERSONAL)) {
	    		  
	    		 if(newTrainer.getListOfSlots().size()>=2) {
	    			 newTrainer=trainerRepo.save(trainer);
	    			 
	    		 }
	    		 else {
	    			 
	    			  throw new TrainerException("You Are The Personal Trainner Than you must have at least 2 slot) ");
	    		 }
	    		 
	    	 }
	    	 else if(trainer.getTrainerType().equals("General")) {
	    	   newTrainer=trainerRepo.save(trainer);	
	    	 }
	    
		 		return newTrainer; 
		     }  
		    else 
		     { 
		    	 throw new TrainerException("Trainer alredy registered with Given EmailD"+trainer.getEmail());
		     }
	}

	@Override
	public List<Trainer> trainersAvailable(LocalTime startTime, Integer budget) throws TrainerException {
			 
		List<Trainer> newTrainer=trainerRepo.findAll();
		
	     List<Trainer> availableTrainer=new ArrayList<>();
		
	     if(newTrainer.size()>0) {
		
		for(Trainer trainer:newTrainer) {
			
			List<Slot> listSlots=trainer.getListOfSlots();
			
			for(Slot slot:listSlots) {
				
			if(slot.getMember()==null) {
				
				if(trainer.getSalary()<=budget) {
			       
					if(slot.getStartTime().compareTo(startTime)==0) {
					
						availableTrainer.add(trainer);
					}
					 
					
				}
		    
			}
		  }
			
		}
		
		if(availableTrainer.size()==0) {
			 throw new TrainerException("Trainer are not present in  Availbe In Given Slot Time");
		}
		
	     }
	     else {
	    	 
	    	 throw new TrainerException("Trainer list Is Empty");
	    	 
	     }
		
		
		return availableTrainer;
	}

	@Override
	public String userCanChooseTrainer(Integer memberId, Integer TrainerId, Integer slotId)
			throws SlotException, MemberException, TrainerException {
		
		String result="Slot Is Not Alloted";
		
		Optional<Slot> optSlot=slotRepo.findById(slotId);
		Optional<Member> optmember=memberRepo.findById(memberId);
		Optional<Trainer> isTrainerPresent=trainerRepo.findById(memberId);
		
		if(optSlot.isPresent()) {
			Slot  slot=optSlot.get();
			
			if(optmember.isPresent()) {
				Member member=optmember.get();
				
				if(isTrainerPresent.isPresent()) {
				  Trainer trainer=isTrainerPresent.get();
				 
				   slot.setMember(member);
				   member.setSlot(slot);
				   trainer.getListOfSlots().add(slot);   	 
					trainer.getListOfmembers().add(member); 
					
					trainerRepo.save(trainer);
					memberRepo.save(member);
					result="Slot Is Add SuccessFully...";
					
				}
				else {
					
					throw new TrainerException("Invalid Trainer Id");
				}
			}
			else {
				throw new MemberException("Invalid Member Id");
				
			}
			
			
		}
		else {
			throw new SlotException("Invalid Slot Id");
		}
		
		return result;
	}

	@Override
	public List<Trainer> findMostEarnTrainer() throws TrainerException {
		 List<Trainer> list=new ArrayList<>();
	 List<Trainer> newTrainer=trainerRepo.findAll();
	 if(newTrainer.size()>0) {
		     Integer MaxSalary=0;
			 for(Trainer trainer:newTrainer) {
				 if(MaxSalary<=trainer.getSalary() ) {
					 MaxSalary=trainer.getSalary();
				 }
			 }
			 for(Trainer trainer:newTrainer) {
				 if(MaxSalary==trainer.getSalary() ) {
					 list.add(trainer);
				 }
			 }		  
	 }
	 else {
		 throw new TrainerException("Trainer Data Is Empty");
		 
	 }
		return list;
	}

	@Override
	public List<Trainer> trainerPromotion() throws TrainerException {
        List<Trainer> listOfTrainer=null;
        
         List<Trainer> newTrainer=trainerRepo.findAll();
         
          if(newTrainer.size()>0) {
        	  
        listOfTrainer=new ArrayList<>();	  
         for(Trainer trainerObj:newTrainer) {
        	 
        	 if(trainerObj.getTrainerType().equals(TrainerType.GENERAL)) {
        	
        		    long diff=ChronoUnit.MONTHS.between(trainerObj.getJoinedOn(),LocalDateTime.now());
        		  
        		     if(diff>=12) {
        		  
        		      trainerObj.setSalary(((trainerObj.getSalary()*15)/100));	 
        		      listOfTrainer.add(trainerObj);	 
        		  }
        	 }
           }
	     }
          else {
        	  
        	  throw new TrainerException("Trainer list is Empty");
          }
		
         return listOfTrainer;
	}

	@Override
	public List<Trainer> TrainerAvailable(LocalTime startTime, Integer budget) throws TrainerException {
		// TODO Auto-generated method stub
		return null;
	}

	



	

    

}
