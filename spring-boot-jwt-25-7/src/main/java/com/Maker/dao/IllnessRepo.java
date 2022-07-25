package com.Maker.dao;

import com.Maker.model.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepo extends JpaRepository<Illness, Integer> {

     Illness findByName(String name);
}
