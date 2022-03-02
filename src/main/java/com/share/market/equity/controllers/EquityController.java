package com.share.market.equity.controllers;

import com.share.market.equity.entities.Equity;
import com.share.market.equity.services.EquitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class EquityController {

    @Autowired
    EquitiesService equitiesService;

    @PostMapping("/equities")
    public ResponseEntity<List<Equity>> saveEquityDetails(@RequestBody List<Equity> equityDetails){
        List<Equity> equities = equitiesService.saveEquityDetails(equityDetails);
        return new ResponseEntity<>(equities, HttpStatus.OK);
    }

    @GetMapping("/equities")
    public ResponseEntity<List<Equity>> getEquityDetails(){
       List<Equity> equities = equitiesService.getEquityDetails();
       return new ResponseEntity<>(equities,HttpStatus.OK);
    }

    @GetMapping("/equities/{id}")
    public ResponseEntity<Object> getEquityDetailById(@PathVariable(name="id") Long id){
        Object equity = equitiesService.getEquityDetailById(id);
        return new ResponseEntity<>(equity, HttpStatus.OK);
    }

    @GetMapping("equities/equityname")
    public ResponseEntity<Equity> getEquityDetailByName(@RequestParam(name="equityname")  String equityname){
        Equity equity = equitiesService.getEquityDetailByName(equityname);
        return new ResponseEntity<>(equity, HttpStatus.OK);
    }

}
