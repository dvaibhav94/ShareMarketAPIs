package com.share.market.equity.controllers;

import com.share.market.dtos.ResponseDto;
import com.share.market.equity.entities.Equity;
import com.share.market.equity.services.EquityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/equities")
public class EquityController {

    private final EquityService equityService;

    public EquityController(EquityService equityService) {
        this.equityService = equityService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<List<Equity>>> saveEquities(@RequestBody List<Equity> equityDetails){
        List<Equity> equities = equityService.saveEquities(equityDetails);
        return ResponseEntity.ok(new ResponseDto<>("Success", 1, equities));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<Equity>>> getAllEquities(){
       List<Equity> equities = equityService.getAllEquities();
       return ResponseEntity.ok(new ResponseDto<>("Success", 1, equities));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<Equity>> getEquityById(@PathVariable(name="id") Long id){
        Equity equity = equityService.getEquityById(id);
        return ResponseEntity.ok(new ResponseDto<>("Success", 1, equity));
    }

    @GetMapping("/equityname")
    public ResponseEntity<ResponseDto<Equity>> getEquityByName(@RequestParam(name="equityname")  String equityName){
        Equity equity = equityService.getEquityByName(equityName);
        return ResponseEntity.ok(new ResponseDto<>("Success", 1, equity));
    }
}
