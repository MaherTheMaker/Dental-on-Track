package com.Maker.controller;



import com.Maker.model.MoneySafe;
import com.Maker.model.MyProcedure;
import com.Maker.model.Receipt;
import com.Maker.service.MoneySafeService;
import com.Maker.service.ReceiptService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Test")
public class TestController {
    @Autowired
    private MoneySafeService moneySafeService;

    @Autowired
    private ReceiptService receiptService;


    @PostMapping("/AddSafe/{uID}")
    private ResponseEntity<MoneySafe> AddSafe(@PathVariable int uID, @RequestBody MoneySafe moneySafe){
        return ResponseEntity.ok().body(moneySafeService.addMoneySafe(moneySafe,uID));
    }

    @GetMapping("/AllSafes")
    private ResponseEntity<List<MoneySafe>> GetSafes() {
        return ResponseEntity.ok().body(moneySafeService.getAllMoneySafe());
    }

    @GetMapping("/getSafeName/{name}")
    private ResponseEntity<MoneySafe> getSafe(@PathVariable String name){
        System.out.printf("name");
        return ResponseEntity.ok().body(moneySafeService.getMoneySafe(name));
    }

    @GetMapping("/getSafeID/{id}")
    private ResponseEntity<MoneySafe> getSafe(@PathVariable int id){
        return ResponseEntity.ok().body(moneySafeService.getMoneySafe(id));
    }

    @PostMapping("/editSafe/{id}")
    private ResponseEntity<MoneySafe> editProcedure(@PathVariable int id , @RequestBody MoneySafe moneySafe){
        return ResponseEntity.ok().body(moneySafeService.editMoneySafe(id , moneySafe));

    }


    @PostMapping("{pId}/Receipt/add")
    private ResponseEntity<Receipt> addReceipt(@PathVariable int pId,@RequestBody ReceiptForm receipt){


        return ResponseEntity.accepted().body(receiptService.add(pId, receipt));

    }


    @PostMapping("/Receipt/{id}/edit")
    private  ResponseEntity<Receipt> editReceipt(@PathVariable int id, @RequestBody Receipt receipt){
        return ResponseEntity.accepted().body(receiptService.editReceipt(id,receipt));
    }



    @GetMapping("/Receipt/{id}/getReceipt")
    private ResponseEntity<Receipt> getReceipt(@PathVariable int id ){
        return ResponseEntity.ok().body(receiptService.getReceipt(id));
    }


    @GetMapping("/Receipt/getByDate")
    private ResponseEntity<List<Receipt>> getAllReceiptByDate(@RequestBody Date date){

        return ResponseEntity.ok().body(receiptService.getAllReceipt(date));

    }

    @GetMapping("/Receipt/getAllReceipt")
    private ResponseEntity<List<Receipt>> getAll (){
        return ResponseEntity.ok().body(receiptService.getAllReceipt());
    }



}


