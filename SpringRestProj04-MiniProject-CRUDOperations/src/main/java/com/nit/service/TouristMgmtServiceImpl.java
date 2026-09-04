package com.nit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Tourist;
import com.nit.repository.ITouristRepository;

@Service
public class TouristMgmtServiceImpl implements ITouristService {
	@Autowired
     private  ITouristRepository  touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
        int idVal = touristRepo.save(tourist).getTid();
		return "Tourist is saved with id value"+idVal;
	}

	@Override
	public List<Tourist> showAllTourists() {
		return touristRepo.findAll();
	}

	@Override
	public Tourist showTouristById(int tid) {
		return touristRepo.findById(tid).orElseThrow(()-> new IllegalArgumentException("Invalid id"));
	}

	@Override
	public String updateTourist(Tourist tourist) {
		//load the obj
		Optional<Tourist> opt = touristRepo.findById(tourist.getTid());
		if(opt.isPresent()) {
			//update the objd
			touristRepo.save(tourist);
			return "Tourist details are updated";
		}
		return "Tourist details are not found for updation";
	}

	@Override
	public String deleteTouristById(int id) {
		//load the obj
		Optional<Tourist>  opt = touristRepo.findById(id);
		if(opt.isPresent()) {
			touristRepo.deleteById(id);
			return "Tourist details are deleted";
		}
		return "Tourist details are not found for deletion";
	}

	@Override
	public String updateTouristBudgetById(int id, double hikePercentage) {
		// load tourist
		Optional<Tourist>  opt = touristRepo.findById(id);
		if(opt.isPresent()) {
			//get entity obj
			Tourist tourist = opt.get();
			tourist.setBudget(tourist.getBudget()+(tourist.getBudget()*hikePercentage/100.0f));
			touristRepo.save(tourist);
			return id+ "Tourist budget is hiked "+tourist.getBudget() ;
	    }
		return id+ "Tourist budget not found for updation";
	}

}
