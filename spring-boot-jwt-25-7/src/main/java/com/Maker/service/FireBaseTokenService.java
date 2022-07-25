package com.Maker.service;

import com.Maker.model.FireBaseToken;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface FireBaseTokenService {

    FireBaseToken addSToken(FireBaseToken fireBaseToken);
    FireBaseToken getSToken(String username);



}
