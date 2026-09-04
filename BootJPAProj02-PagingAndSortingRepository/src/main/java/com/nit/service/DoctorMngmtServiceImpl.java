package com.nit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nit.entity.Doctor;
import com.nit.repository.IDoctorRepo;

@Service("docService")
public class DoctorMngmtServiceImpl implements IDoctorService {
    @Autowired
	private IDoctorRepo docRepo;
   
	/* @Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("doc Id(before save: "+doctor.getDocId());
		//Doctor doc = docRepo.save(doctor);
		Doctor doc2 = docRepo.save(doctor);
		return "Doctor obj is saved with id vaue: "+doc2.getDocId();
	}
	@Override
	public Iterable<Doctor> showDoctorBySorting(boolean asc, String... props) {
		//prepare the sort object
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		//use repo
		Iterable<Doctor> it = docRepo.findAll(sort);
		return it;
	}
	@Override
	public Page<Doctor> showDoctorByPageNo(int pageNo, int pageSize,boolean asc, String... props) {
		//prepare the Sort object
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		//create Pageable<T> object
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		//get request Page<T> object
		Page<Doctor> page = docRepo.findAll(pageable);
		return page;
	}*/
	@Override
	public void showDataThroughPagination(int pageSize) {
		//decide the no.of pages
		long count =0;
		count = docRepo.count();
		long pagesCount = count/pageSize;
		if(count%pagesCount!=0)
			pagesCount++;
		
		for(int i=0; i<pagesCount;++i) {
			//create pageable object
			Pageable pageable = PageRequest.of(i, pageSize);
			//get each page records
			Page<Doctor> page = docRepo.findAll(pageable);
			System.out.println("page no: "+(page.getNumber()+1)+" records of: "+page.getTotalPages());
			page.getContent().forEach(System.out::println);
		}
		
	}
     
	
}	

