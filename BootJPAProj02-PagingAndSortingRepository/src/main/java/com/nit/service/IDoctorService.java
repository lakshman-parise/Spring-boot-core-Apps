//IDoctorService.java
package com.nit.service;

import org.springframework.data.domain.Page;

import com.nit.entity.Doctor;

public interface IDoctorService {
	//public String registerDoctor(Doctor doctor);
   //public Iterable<Doctor> showDoctorBySorting(boolean asc, String... props);
   //public Page<Doctor> showDoctorByPageNo(int pageNo, int pageSize,boolean asc, String... props);
   public void showDataThroughPagination(int pageSize);
}
