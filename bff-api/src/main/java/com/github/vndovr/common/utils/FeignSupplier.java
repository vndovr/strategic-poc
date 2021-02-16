package com.github.vndovr.common.utils;

import java.util.Objects;
import java.util.function.Supplier;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class FeignSupplier<U> implements Supplier<U> {

  static ThreadLocal<RequestHeaders> holder = new ThreadLocal<>();;

  RequestHeaders httpHeaders;

  Supplier<U> supplier;

  @Override
  public U get() {
    try {
      holder.set(httpHeaders);
      return supplier.get();
    } finally {
      // cleanup hodler
      holder.set(null);
    }
  }

  static RequestHeaders headers() {
    return holder.get();
  }

  static boolean isAsync() {
    return !Objects.isNull(holder.get());
  }

  public static <U> Supplier<U> wrap(Supplier<U> supplier) {
    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
    if (requestAttributes instanceof ServletRequestAttributes) {
      HttpServletRequest httpServletRequest =
          ((ServletRequestAttributes) requestAttributes).getRequest();
      return new FeignSupplier<>(new RequestHeaders(httpServletRequest), supplier);
    } else {
      throw new RuntimeException("No access to HttpServletRequest object"); // NOSONAR
    }
  }
}
