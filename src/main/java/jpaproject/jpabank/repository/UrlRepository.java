package jpaproject.jpabank.repository;

import jpaproject.jpabank.domain.dto.DepositUrlDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<DepositUrlDto, Long> {
}
