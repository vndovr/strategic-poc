package com.github.vndovr.common.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class RequestHeaders {

  private Map<String, String> headers = new HashMap<>();

  RequestHeaders(HttpServletRequest httpServletRequest) {
    log.info("Creation of request");
    for (Enumeration<String> e = httpServletRequest.getHeaderNames(); e.hasMoreElements();) {
      String key = e.nextElement();
      headers.put(key.toLowerCase(), httpServletRequest.getHeader(key));
    }
  }

  String getHeader(String header) {
    return StringUtils.defaultString(headers.get(header.toLowerCase()));
  }
}
