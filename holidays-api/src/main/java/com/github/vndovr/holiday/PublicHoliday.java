package com.github.vndovr.holiday;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PublicHoliday {
 
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

  private String name;
  
  private LocalDate date;

  private String country;

}
