package org.cs.jwt.auditing;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    // return null;
    // Can use Spring Security to return currently logged in user
    return Optional.of(SecurityContextHolder.getContext().getAuthentication().getName());
  }
}
