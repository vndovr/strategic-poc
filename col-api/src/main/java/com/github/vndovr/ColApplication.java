package com.github.vndovr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ColApplication {

  /**
   * MAIN method of the application
   * 
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(ColApplication.class, args);
  }

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
        .route("beneficiaries_route", r -> r.path("/api/beneficiaries").uri("http://localhost:8082"))
        .route("holidays_route", r -> r.path("/api/holidays").uri("http://localhost:8083")).build();
  }

}
