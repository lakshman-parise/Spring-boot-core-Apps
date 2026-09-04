package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Tourist;
import com.nit.service.ITouristService;

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationsController {
	@Autowired
    private ITouristService  tourService;
	
	@PostMapping("/save")
	public  ResponseEntity<String>  registerTourist(@RequestBody Tourist tourist){
		try {
			//use Service
			String  msg = tourService.registerTourist(tourist);
			return  new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/report")
	public  ResponseEntity<Object>  showAllTourists(){
		try {
			//use service
			List<Tourist> list = tourService.showAllTourists();
			return new ResponseEntity<Object>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/find/{tid}")
	public ResponseEntity<Object>  showTouristById(@PathVariable("tid") Integer tid){
		try {
			//use service
			Tourist tourist = tourService.showTouristById(tid);
			return new ResponseEntity<Object>(tourist,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update")
	public  ResponseEntity<String>  updateTourist(@RequestBody Tourist tour){
		try {
			//use service
			String msg = tourService.updateTourist(tour);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/update/{id}/{percentage}")
	public  ResponseEntity<String>  updateTouristBudgetById(@PathVariable("id") Integer id,
			                                                                                                           @PathVariable("percentage") Float percentage){
			
		try {
			//use service
			String msg = tourService.updateTouristBudgetById(id, percentage);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>  removeTouristById(@PathVariable("id") Integer id){
		try {
			//use service
			String msg = tourService.deleteTouristById(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
