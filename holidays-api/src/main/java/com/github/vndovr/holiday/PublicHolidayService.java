package com.github.vndovr.holiday;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PublicHolidayService {

  private ModelMapper modelMapper;

  private PublicHolidayRepository publicHolidayRepository;

  /**
   * Retrieves the list of public holidays
   * 
   * @return
   */
  public List<PublicHolidayRO> getPublicHolidays() {
    return publicHolidayRepository.findAll().stream()
        .map(obj -> modelMapper.map(obj, PublicHolidayRO.class)).collect(Collectors.toList());
  }

}
