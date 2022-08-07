package com.Maker.controller;

import com.Maker.dao.MyProcedureRepo;
import com.Maker.model.MyProcedure;
import com.Maker.service.ProceduresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Procedure")
public class ProceduresController {


    //TODO Some Validation
    @Autowired
    private ProceduresService proceduresService;

    @Autowired
    private MyProcedureRepo myProcedureRepo;

    //Todo Change to service
    @GetMapping("/AllProcedure")
    private ResponseEntity<List<MyProcedure>> showProcedures() {
        return ResponseEntity.ok().body(myProcedureRepo.findAll());
    }


    @PostMapping("/addProcedure")
    private ResponseEntity<MyProcedure> addProcedure(@RequestBody MyProcedure myProcedure){
        return ResponseEntity.ok().body(proceduresService.addProcedure(myProcedure));
    }

    @GetMapping("/getProcedure/{name}")
    private ResponseEntity<MyProcedure> getProcedure(@PathVariable String name){
        return ResponseEntity.ok().body(myProcedureRepo.findByPName(name));
    }


    @GetMapping("/editProcedure/{name}")
    private ResponseEntity<MyProcedure> editProcedure(@PathVariable String name , @RequestBody MyProcedure myProcedure){
        return ResponseEntity.ok().body(proceduresService.editProcedure(name , myProcedure));
    }


}
