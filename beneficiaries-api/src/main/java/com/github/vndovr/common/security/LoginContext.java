package com.github.vndovr.common.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * Wraps and extracts information about current user
 * 
 * @author Vladimir Radchuk
 *
 */
@Component
public class LoginContext {

  /**
   * Returns the user id of logged in user
   * 
   * @return
   */
  public String getUserId() {
    return Optional.ofNullable(jwt()).map(jwt -> (String) jwt.getClaim("preferred_username"))
        .orElse("anonymouse");
  }

  /**
   * Returns the user email
   * 
   * @return
   */
  public String getUserEmail() {
    return Optional.ofNullable(jwt()).map(jwt -> (String) jwt.getClaim("email")).orElse("");
  }

  /**
   * Returns the username
   * 
   * @return
   */
  public String getFirstName() {
    return Optional.ofNullable(jwt()).map(jwt -> (String) jwt.getClaim("given_name")).orElse("");
  }

  /**
   * Returns the username
   * 
   * @return
   */
  public String getLastName() {
    return Optional.ofNullable(jwt()).map(jwt -> (String) jwt.getClaim("family_name")).orElse("");
  }


  /**
   * Returns the list of roles assigned to user
   * 
   * @return
   */
  public Set<String> getRoles() {
    return Optional
        .ofNullable(authorities()).map(authorities -> authorities.stream()
            .map(GrantedAuthority::getAuthority).collect(Collectors.toSet()))
        .orElse(Collections.emptySet());
  }

  /**
   * Checks if user has specific role assigned
   * 
   * @param role
   * @return
   */
  public boolean hasRole(String... roles) {
    Set<String> userRoles = getRoles();
    for (String role : roles) {
      if (userRoles.contains(role)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Returns the keycloack security context if one exists
   * 
   * @return
   */
  private Jwt jwt() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication instanceof JwtAuthenticationToken
        ? ((JwtAuthenticationToken) authentication).getToken()
        : null;
  }

  /**
   * Returns the keycloack security context if one exists
   * 
   * @return
   */
  private Collection<GrantedAuthority> authorities() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication instanceof JwtAuthenticationToken
        ? ((JwtAuthenticationToken) authentication).getAuthorities()
        : null;
  }

}
