package com.github.vndovr.col.beneficiary;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "beneficiaries", url = "${services.col.beneficiaries}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface BeneficiariesClient {

  @GET
  public BeneficiaryROShort[] getBeneficiaries();

  @Path("/{id}")
  @GET
  public BeneficiaryROFull getBeneficiary(@PathParam("id") long id);

  @Path("/{id}")
  @DELETE
  public void deleteBeneficiary(@PathParam("id") long id);

  @POST
  public BeneficiaryROFull createBeneficiary(BeneficiaryROFull ro);

  @Path("/{id}")
  @PUT
  public BeneficiaryROFull updateBeneficiary(@PathParam("id") long id, BeneficiaryROFull ro);
}
