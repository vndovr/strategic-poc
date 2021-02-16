package com.github.vndovr.col.auth;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "authentication", url = "${services.col.authentication}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface AuthenticationClient {
  @Path("/login")
  @POST
  public LoginResponseRO login(LoginRequestRO dto);

  @Path("/logout")
  @POST
  public void logout(RefreshTokenRO dto);

  @Path("/refresh")
  @POST
  public LoginResponseRO refresh(@Valid RefreshTokenRO dto);

  @Path("/self")
  @GET
  public SelfRO self();
}
