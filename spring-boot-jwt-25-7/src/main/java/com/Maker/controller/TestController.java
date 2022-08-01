package com.Maker.controller;



import com.Maker.model.Expenses;
import com.Maker.model.MoneySafe;
import com.Maker.model.Receipt;
import com.Maker.model.ReceiptForm;
import com.Maker.service.ExpensesForm;
import com.Maker.service.ExpensesService;
import com.Maker.service.MoneySafeService;
import com.Maker.service.ReceiptService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Autowired
    private ExpensesService expensesService;


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
    private ResponseEntity<List<Receipt>> getAllReceiptByDate(@RequestBody date date1){
        System.out.printf(date1.date.toString());

        return ResponseEntity.ok().body(receiptService.getAllReceipt(date1.date));

    }

    @GetMapping("/Receipt/getAllReceipt")
    private ResponseEntity<List<Receipt>> getAll (){
        return ResponseEntity.ok().body(receiptService.getAllReceipt());
    }


    //Expenses
    @PostMapping("/expenses/add")
    private ResponseEntity<Expenses> addExpense(@RequestBody ExpensesForm expenses){

        return ResponseEntity.accepted().body(expensesService.add(expenses));

    }

    @GetMapping("/expense/{id}/getExpense")
    private ResponseEntity<Expenses> getExpense(@PathVariable int id ){
        return ResponseEntity.ok().body(expensesService.getExpense(id));
    }

    @GetMapping("/expense/getByDate")
    private ResponseEntity<List<Expenses>> getAllExpensesByDate(@RequestBody date date1){


        return ResponseEntity.ok().body(expensesService.getExpenses(date1.date));

    }

    @GetMapping("/expense/getBySafe/{name}")
    private ResponseEntity<List<Expenses>> getAllExpensesBySafe(@PathVariable String name){

        System.out.println( name);

        return ResponseEntity.ok().body(expensesService.getMoneySafeExpenses(name));

    }

    @GetMapping("/expense/getBySafeAndDate")
    private ResponseEntity<List<Expenses>> getMoneySafeExpensesInDate(@RequestBody DateAndSafeName dateAndSafeName){


        return ResponseEntity.ok().body(expensesService.getMoneySafeExpensesInDate(dateAndSafeName.safeName,dateAndSafeName.d));

    }


    //TRANSACTION






}

@Data
class date {
    Date date;
}


@Data
class DateAndSafeName{
    Date d;
    String safeName;
}


