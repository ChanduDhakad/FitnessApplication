package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Trainer;


public interface TrainerRepo extends  JpaRepository<Trainer, Integer> {

    public Trainer findByEmail(String email);

}
