package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nit.entity.Doctor;
import com.nit.service.IDoctorService;

@Component
public class PagingAndSortingRepoTestRunner implements CommandLineRunner {
	@Autowired
    private IDoctorService docService;
	@Override
	public void run(String... args) throws Exception {
		
		/*  try { //create doctor class object 
		  Doctor doctor = new Doctor();
		  doctor.setDocName("Raja"); 
		  doctor.setSpecialization("MBBS-Neurologist");
		  doctor.setIncome(7065000.00d); //invoke the b.method 
		  String resultMsg = docService.registerDoctor(doctor); 
		  System.out.println(resultMsg);
		  }catch(Exception e) { 
		  e.printStackTrace(); 
		  }*/
		 
		//docService.showDoctorBySorting(false, "docName","income").forEach(System.out::println);
		
		/*Page<Doctor> page = docService.showDoctorByPageNo(1, 3,false,"docName");
		 System.out.println("PageNumber: "+page.getNumber());
		 System.out.println("Pages Count: "+page.getTotalPages());
		 System.out.println("Is it First page: "+page.isFirst());
		 System.out.println("Is it Last Page: "+page.isLast());
		 System.out.println("Page Elements count: "+page.getNumberOfElements());
		 
		 List<Doctor> list = page.getContent(); list.forEach(System.out::println);*/
		
		docService.showDataThroughPagination(2);
	}

}
