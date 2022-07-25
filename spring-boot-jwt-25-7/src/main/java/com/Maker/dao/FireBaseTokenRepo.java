package com.Maker.dao;

import com.Maker.model.FireBaseToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireBaseTokenRepo extends JpaRepository<FireBaseToken,Integer> {

    FireBaseToken findByUsername(String username);
}
