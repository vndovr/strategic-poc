package com.github.vndovr.common.utils;

import java.util.Objects;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class FeignSupplier<U> implements Supplier<U> {

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
}
