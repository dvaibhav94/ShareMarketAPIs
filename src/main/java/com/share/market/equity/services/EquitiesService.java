package com.share.market.equity.services;

import com.share.market.equity.entities.Equity;
import com.share.market.equity.repositories.EquityRepository;
import com.share.market.exceptionhandler.ExceptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquitiesService {

    @Autowired
    EquityRepository equityRepository;

    @Autowired
    ExceptionResponse exceptionResponse;

    public List<Equity> saveEquityDetails(List<Equity> equityDetails) {
        return equityRepository.saveAll(equityDetails);
    }

    public List<Equity> getEquityDetails() {
        return equityRepository.findAll();
    }

    public Object getEquityDetailById(Long id) {
        Optional<Equity> equity = equityRepository.findById(id);
        if(equity.isPresent()){
            return equity.get();
        }else{
            exceptionResponse.setErrorCode(500);
            exceptionResponse.setMessage("Requested id " +id+ " not found");
        }

        return exceptionResponse;
    }

    public Equity getEquityDetailByName(String equityname) {
        return equityRepository.findByEquityName(equityname);
    }
}
