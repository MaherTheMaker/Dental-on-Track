package com.Maker.controller;

import com.Maker.model.FireBaseToken;
import com.Maker.service.FireBaseTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/firebase")
public class FireBaseTokenController {

    @Autowired
    private FireBaseTokenService fireBaseTokenService ;




    @PostMapping("/saveToken")
    private ResponseEntity<FireBaseToken> addFireBaseToken(@RequestBody FireBaseToken fireBaseToken){
            return ResponseEntity.ok().body(fireBaseTokenService.addSToken(fireBaseToken));
    }


    @GetMapping("/getToken/{username}")
    private ResponseEntity<FireBaseToken> getFireBasetoken(@PathVariable String username){
        return ResponseEntity.ok().body(fireBaseTokenService.getSToken(username));
    }



}
