package com.nit.service;

import java.util.List;

import com.nit.entity.Tourist;

public interface ITouristService {
    public String registerTourist(Tourist tourist);
    public List<Tourist>  showAllTourists();
    public  Tourist showTouristById(int tid);
    public String  updateTourist(Tourist tourist);
    public String  deleteTouristById(int id);
    public String  updateTouristBudgetById(int id, double hikePercentage);
}
