package com.share.market.equity.repositories;

import com.share.market.equity.entities.Equity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquityRepository extends JpaRepository<Equity, Long> {
    Equity findByEquityName(String equityname);
}
