package jpaproject.jpabank.repository;

import jpaproject.jpabank.domain.dto.DepositPrefInterDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrefInterRateDtoRepository extends JpaRepository<DepositPrefInterDto,Long> {
}
