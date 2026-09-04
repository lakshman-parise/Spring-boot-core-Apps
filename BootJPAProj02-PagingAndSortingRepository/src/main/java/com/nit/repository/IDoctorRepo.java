package com.nit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nit.entity.Doctor;

public interface IDoctorRepo extends  CrudRepository<Doctor, Integer>,
                                PagingAndSortingRepository<Doctor, Integer>{
      //long  count();
}
