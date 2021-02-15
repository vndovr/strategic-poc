package com.github.vndovr.col.auth;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "RO that represents token refresh request", required = true)
public class RefreshTokenRO {

  @Schema(description = "Refresh token used to get new pair of access and refresh tokens",
      required = true)
  @NotBlank
  private String token;
}
