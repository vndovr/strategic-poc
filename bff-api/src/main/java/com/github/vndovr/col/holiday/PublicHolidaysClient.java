package com.github.vndovr.col.holiday;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "holidays", url = "${services.col.holidays}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface PublicHolidaysClient {

  @GET
  public PublicHolidayRO[] getPublicHolidays();
}
