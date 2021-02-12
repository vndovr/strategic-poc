package com.github.vndovr.beneficiary;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import com.github.vndovr.common.jaxrs.Descriptions;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@Path("beneficiaries")
@Tag(name = "Beneficiaries API", description = "API for managing information about beneficiaries")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BeneficiaryResource {

  private BeneficiaryService beneficiaryService;

  @GET
  @Operation(summary = "Returns the list with short information about beneficiaries",
      security = @SecurityRequirement(name = "bearer"),
      responses = {
          @ApiResponse(responseCode = "200", description = Descriptions.D200,
              content = @Content(mediaType = javax.ws.rs.core.MediaType.APPLICATION_JSON,
                  array = @ArraySchema(
                      schema = @Schema(implementation = BeneficiaryROShort.class)))),
          @ApiResponse(responseCode = "400", description = Descriptions.D400),
          @ApiResponse(responseCode = "401", description = Descriptions.D401),
          @ApiResponse(responseCode = "403", description = Descriptions.D403),
          @ApiResponse(responseCode = "500", description = Descriptions.D500)})
  public Response getBeneficiaries() {
    return Response.ok(beneficiaryService.getBeneficiaries()).build();
  }

  @Path("/{id}")
  @GET
  @Operation(summary = "Returns the full information about beneficiary",
      security = @SecurityRequirement(name = "bearer"),
      responses = {
          @ApiResponse(responseCode = "200", description = Descriptions.D200,
              content = @Content(mediaType = javax.ws.rs.core.MediaType.APPLICATION_JSON,
                  schema = @Schema(implementation = BeneficiaryROFull.class))),
          @ApiResponse(responseCode = "400", description = Descriptions.D400),
          @ApiResponse(responseCode = "401", description = Descriptions.D401),
          @ApiResponse(responseCode = "403", description = Descriptions.D403),
          @ApiResponse(responseCode = "500", description = Descriptions.D500)})
  public Response getBeneficiary(@PathParam("id") long id) {
    return Response.ok(beneficiaryService.getBeneficiary(id)).build();
  }


  @Path("/{id}")
  @DELETE
  @Operation(summary = "Removes the beneficiary from the database identified by id",
      security = @SecurityRequirement(name = "bearer"),
      responses = {@ApiResponse(responseCode = "204", description = Descriptions.D200),
          @ApiResponse(responseCode = "400", description = Descriptions.D400),
          @ApiResponse(responseCode = "401", description = Descriptions.D401),
          @ApiResponse(responseCode = "403", description = Descriptions.D403),
          @ApiResponse(responseCode = "500", description = Descriptions.D500)})
  public Response deleteBeneficiary(@PathParam("id") long id) {
    beneficiaryService.deleteBeneficiary(id);
    return Response.noContent().build();
  }

  @POST
  @Operation(summary = "Creates new beneficiary", security = @SecurityRequirement(name = "bearer"),
      responses = {
          @ApiResponse(responseCode = "200", description = Descriptions.D200,
              content = @Content(mediaType = javax.ws.rs.core.MediaType.APPLICATION_JSON,
                  schema = @Schema(implementation = BeneficiaryROFull.class))),
          @ApiResponse(responseCode = "400", description = Descriptions.D400),
          @ApiResponse(responseCode = "401", description = Descriptions.D401),
          @ApiResponse(responseCode = "403", description = Descriptions.D403),
          @ApiResponse(responseCode = "500", description = Descriptions.D500)})
  public Response createBeneficiary(@Valid BeneficiaryROFull ro) {
    return Response.ok(beneficiaryService.createBeneficiary(ro)).build();
  }

  @Path("/{id}")
  @PUT
  @Operation(summary = "Updates the information about beneficiary identified by {id}",
      security = @SecurityRequirement(name = "bearer"),
      responses = {
          @ApiResponse(responseCode = "200", description = Descriptions.D200,
              content = @Content(mediaType = javax.ws.rs.core.MediaType.APPLICATION_JSON,
                  schema = @Schema(implementation = BeneficiaryROFull.class))),
          @ApiResponse(responseCode = "400", description = Descriptions.D400),
          @ApiResponse(responseCode = "401", description = Descriptions.D401),
          @ApiResponse(responseCode = "403", description = Descriptions.D403),
          @ApiResponse(responseCode = "500", description = Descriptions.D500)})
  public Response updateBeneficiary(@PathParam("id") long id, @Valid BeneficiaryROFull ro) {
    return Response.ok(beneficiaryService.updateBeneficiary(id, ro)).build();
  }
}
