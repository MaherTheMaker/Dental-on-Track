package com.Maker.dao;

import com.Maker.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PlansRepo extends JpaRepository<Plan, Integer> {

   Plan findByPName(String name);
   Plan findById(int id);
}
