package jpaproject.jpabank.repository;

import jpaproject.jpabank.domain.dto.DepositInterRateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterRateDtoRepository extends JpaRepository<DepositInterRateDto,Long> {
}
