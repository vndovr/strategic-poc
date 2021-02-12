package com.github.vndovr.col.holiday;

import java.time.LocalDate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "RO objects with information about public holiday")
public class PublicHolidayRO {

  @Schema(description = "public holiday's name")
  private String name;

  @Schema(description = "public holiday's date")
  private LocalDate date;

  @Schema(description = "public holiday's country")
  private String country;

}
