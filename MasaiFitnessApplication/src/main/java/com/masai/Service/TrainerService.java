package com.masai.Service;

import java.time.LocalTime;
import java.util.List;

import com.masai.Exception.MemberException;
import com.masai.Exception.SlotException;
import com.masai.Exception.TrainerException;
import com.masai.Model.Member;
import com.masai.Model.Slot;
import com.masai.Model.Trainer;

public interface TrainerService {

public Trainer newRegisterTrainer(Trainer trainer)throws TrainerException;
	
public List<Trainer> trainersAvailable(LocalTime startTime,Integer budget ) throws TrainerException;

public String userCanChooseTrainer(Integer memberId,Integer TrainerId,Integer slotId)throws SlotException,MemberException,TrainerException;

public List<Trainer>  findMostEarnTrainer()throws TrainerException;

public  List<Trainer> trainerPromotion() throws TrainerException;

List<Trainer> TrainerAvailable(LocalTime startTime, Integer budget) throws TrainerException;

}
