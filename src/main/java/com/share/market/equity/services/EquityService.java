package com.share.market.equity.services;

import com.share.market.equity.entities.Equity;
import com.share.market.equity.repositories.EquityRepository;
import com.share.market.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquityService {

    private final EquityRepository equityRepository;

    public EquityService(EquityRepository equityRepository) {
        this.equityRepository = equityRepository;
    }

    public List<Equity> saveEquities(List<Equity> equityDetails) {
        return equityRepository.saveAll(equityDetails);
    }

    public List<Equity> getAllEquities() {
        return equityRepository.findAll();
    }

    public Equity getEquityById(Long id) {
        return equityRepository.findById(id)
                .orElseThrow(() -> new ValidationException("Equity not found with id: " + id));
    }

    public Equity getEquityByName(String equityName) {
        return equityRepository.findByEquityName(equityName)
                .orElseThrow(() -> new ValidationException(String.format("Equity with name '%s' does not exist", equityName)));
    }
}
