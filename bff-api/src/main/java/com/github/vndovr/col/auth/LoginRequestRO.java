package com.github.vndovr.col.auth;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "RO with information required for login", required = true)
public class LoginRequestRO {

  @Schema(description = "user's login", required = true)
  @NotBlank
  private String login;

  @Schema(description = "user's password", required = true)
  @NotBlank
  private String password;
}
