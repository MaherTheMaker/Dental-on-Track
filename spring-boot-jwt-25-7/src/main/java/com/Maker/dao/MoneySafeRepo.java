package com.Maker.dao;


import com.Maker.model.MoneySafe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MoneySafeRepo extends JpaRepository<MoneySafe, Integer> {

    MoneySafe findByName(String name);

}
