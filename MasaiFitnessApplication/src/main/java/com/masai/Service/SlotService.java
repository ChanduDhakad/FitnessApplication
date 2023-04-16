package com.masai.Service;

import com.masai.Exception.SlotException;
import com.masai.Exception.TrainerException;
import com.masai.Model.Slot;

public interface SlotService {

	public Slot deleteASlot(Integer slotID) throws SlotException ;

}
