package com.github.vndovr.common.jaxrs;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.github.vndovr.Profiles;
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
@Profile(Profiles.STAGING)
public class FeignRequestInterceptor implements RequestInterceptor {

  @Override
  @SneakyThrows
  public void apply(RequestTemplate template) {
    // if we don't have Authentication tokenString in headers
    if (!template.headers().containsKey("Authorization")) {
      // template.header("Authorization", "Bearer " + holder.get().getTokenString());
    }
  }

}
