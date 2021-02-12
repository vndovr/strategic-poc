package com.github.vndovr.beneficiary;

import java.util.List;
import java.util.Optional;
import javax.persistence.QueryHint;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;

public interface BeneficiaryRepository
    extends JpaRepository<Beneficiary, Long>, JpaSpecificationExecutor<Beneficiary> {

  @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
  Optional<Beneficiary> findById(Long id);

  @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
  List<Beneficiary> findAll(Specification<Beneficiary> specification, Sort sort);

}
