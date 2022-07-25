package com.Maker.service;

import com.Maker.dao.FireBaseTokenRepo;
import com.Maker.model.FireBaseToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FireBaseTokenServiceImp implements FireBaseTokenService {

    @Autowired
    private FireBaseTokenRepo tokenRepo;
    @Override
    public FireBaseToken addSToken(FireBaseToken fireBaseToken) {
        return tokenRepo.save(fireBaseToken);
    }

    @Override
    public FireBaseToken getSToken(String username) {
        return tokenRepo.findByUsername(username);
    }


}
