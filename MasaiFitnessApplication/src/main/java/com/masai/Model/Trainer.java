package com.masai.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trainerId;
	private String name;
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private Integer personalTrainingFee;
	
	private Integer salary;
	
	private LocalDateTime joinedOn;
	
	@Enumerated(EnumType.STRING)
	private TrainerType trainerType;
	

	@OneToMany(cascade = CascadeType.ALL)
	List<Member> ListOfmembers=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "trainer")
	List<Slot> ListOfSlots=new ArrayList<>();
	
	 
		@Column(unique = true)
		@Email(message = "email format is incorrect")
		private String email;
	
	
	
}
