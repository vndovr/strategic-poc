package com.github.vndovr.holiday;

import java.util.List;
import javax.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;

public interface PublicHolidayRepository
    extends JpaRepository<PublicHoliday, Long>, JpaSpecificationExecutor<PublicHoliday> {

  @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
  List<PublicHoliday> findAll();

}
