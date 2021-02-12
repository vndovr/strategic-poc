package com.github.vndovr.payment;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import com.github.vndovr.col.beneficiary.BeneficiariesClient;
import com.github.vndovr.col.beneficiary.BeneficiaryROShort;
import com.github.vndovr.col.holiday.PublicHolidayRO;
import com.github.vndovr.col.holiday.PublicHolidaysClient;
import com.github.vndovr.common.jaxrs.Descriptions;
import com.github.vndovr.user.SelfRO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Controller
@Path("/payments")
@Tag(name = "Paymenst API", description = "API for payments management")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class PaymentResource {

  private BeneficiariesClient beneficiariesClient;

  private PublicHolidaysClient publicHolidaysClient;

  @Path("/requisites")
  @GET
  @Operation(summary = "Returns the information beneficiaries and public holidays",
      security = @SecurityRequirement(name = "bearer"),
      responses = {
          @ApiResponse(responseCode = "200", description = Descriptions.D200,
              content = @Content(mediaType = javax.ws.rs.core.MediaType.APPLICATION_JSON,
                  schema = @Schema(implementation = SelfRO.class))),
          @ApiResponse(responseCode = "400", description = Descriptions.D400),
          @ApiResponse(responseCode = "401", description = Descriptions.D401),
          @ApiResponse(responseCode = "403", description = Descriptions.D403),
          @ApiResponse(responseCode = "500", description = Descriptions.D500)})
  public Response getRequisites() {
    BeneficiaryROShort[] beneficiaries = beneficiariesClient.getBeneficiaries();
    PublicHolidayRO[] publicHolidays = publicHolidaysClient.getPublicHolidays();
    return Response.ok(new RequisiteRO(beneficiaries, publicHolidays)).build();
  }
}