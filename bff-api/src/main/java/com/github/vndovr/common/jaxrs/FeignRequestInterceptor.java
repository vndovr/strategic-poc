package com.github.vndovr.common.jaxrs;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.springframework.stereotype.Component;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * Propagates the request header if it exists or get client credentials from keycloak
 * 
 * @author Vladimir Radchuk
 *
 */
@Component
@AllArgsConstructor
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {


  @Context
  private HttpServletRequest servletRequest;

  @Override
  @SneakyThrows
  public void apply(RequestTemplate template) {

    // if we don't have Authentication tokenString in headers
    // for (Enumeration<String> e = servletRequest.getHeaderNames(); e.hasMoreElements();) {
    // String header = (String) e.nextElement();
    // log.info("Header name : {}", header);
    // log.info("Header value: {}", servletRequest.getHeader(header));
    // }
    //
    // log.info("Headers of another request:");
    // template.headers().forEach((name, value) -> {
    // log.info("Header name : {}", name);
    // log.info("Header value: {}", value);
    // });

    if (!template.headers().containsKey(HttpHeaders.AUTHORIZATION)) {
      template.header(HttpHeaders.AUTHORIZATION,
          servletRequest.getHeader(HttpHeaders.AUTHORIZATION));
    }
  }
}
