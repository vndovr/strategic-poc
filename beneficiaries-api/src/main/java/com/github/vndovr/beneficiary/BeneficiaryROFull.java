package com.github.vndovr.beneficiary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "RO objects with full information about beneficiary")
public class BeneficiaryROFull {

  @Schema(description = "beneficiary's id")
  private Long id;

  @Schema(description = "beneficiary's name")
  private String name;

  @Schema(description = "beneficiary's CDI number")
  private String cdiNumber;

  @Schema(description = "beneficiary's account number")
  private String account;

  @Schema(description = "beneficiarie's record version in database")
  private long version;
}
