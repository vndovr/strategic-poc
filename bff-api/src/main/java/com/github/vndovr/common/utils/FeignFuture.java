package com.github.vndovr.common.utils;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FeignFuture {

  public static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier) {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    if (requestAttributes instanceof ServletRequestAttributes) {
      HttpServletRequest httpServletRequest =
          ((ServletRequestAttributes) requestAttributes).getRequest();
      return CompletableFuture
          .supplyAsync(new FeignSupplier<>(new RequestHeaders(httpServletRequest), supplier));
    } else {
      throw new RuntimeException("No access to Http Servlet Request object"); // NOSONAR
    }
  }
}
