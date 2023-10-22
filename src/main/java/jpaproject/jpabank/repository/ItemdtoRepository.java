package jpaproject.jpabank.repository;

import jpaproject.jpabank.domain.dto.DepositDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemdtoRepository extends JpaRepository<DepositDto,Long> {



}
