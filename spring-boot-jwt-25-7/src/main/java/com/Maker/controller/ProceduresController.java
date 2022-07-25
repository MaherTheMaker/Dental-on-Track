package com.Maker.controller;

import com.Maker.dao.ProceduresRepo;
import com.Maker.model.Procedures;
import com.Maker.service.ProceduresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Procedure")
public class ProceduresController {

    @Autowired
    private ProceduresService proceduresService;

    @Autowired
    private ProceduresRepo procedureRepo;

    @GetMapping("/AllProcedure")
    private ResponseEntity<List<Procedures>> showProcedures() {
        return ResponseEntity.ok().body(procedureRepo.findAll());
    }


    @PostMapping("/addProcedure")
    private ResponseEntity<Procedures> addProcedure(@RequestBody Procedures procedure){
        return ResponseEntity.ok().body(proceduresService.addProcedure(procedure));
    }

    @GetMapping("/getProcedure/{name}")
    private ResponseEntity<Procedures> getProcedure(@PathVariable String name){
        return ResponseEntity.ok().body(procedureRepo.findByPName(name));
    }


    @GetMapping("/editProcedure/{name}")
    private ResponseEntity<Procedures> getProcedure(@PathVariable String name , @RequestBody Procedures procedure){
        return ResponseEntity.ok().body(proceduresService.editProcedure(name , procedure));
    }




}
