package com.github.vndovr.col.beneficiary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "RO objects with short information about beneficiary")
public class BeneficiaryROShort {

  @Schema(description = "beneficiary's id")
  private Long id;

  @Schema(description = "beneficiary's name")
  private String name;

  @Schema(description = "beneficiary's cdi number")
  private String cdiNumber;
}
