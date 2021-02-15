package com.github.vndovr.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.springframework.stereotype.Component;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

/**
 * Propagates the request header if it exists or get client credentials from keycloak
 * 
 * @author Vladimir Radchuk
 *
 */
@Component
@AllArgsConstructor
public class FeignRequestInterceptor implements RequestInterceptor {

  @Context
  private HttpServletRequest httpServletRequest;

  @Override
  @SneakyThrows
  public void apply(RequestTemplate template) {
    if (!template.headers().containsKey(HttpHeaders.AUTHORIZATION)) {
      if (FeignSupplier.isAsync()) {
        template.header(HttpHeaders.AUTHORIZATION,
            FeignSupplier.headers().getHeader(HttpHeaders.AUTHORIZATION));
      } else {
        template.header(HttpHeaders.AUTHORIZATION,
            httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION));
      }
    }
  }
}
