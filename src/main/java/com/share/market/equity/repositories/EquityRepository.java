package com.share.market.equity.repositories;

import com.share.market.equity.entities.Equity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquityRepository extends JpaRepository<Equity, Long> {
    Optional<Equity> findByEquityName(String equityname);
}
