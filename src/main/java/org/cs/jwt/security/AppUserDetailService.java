package org.cs.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

import org.cs.jwt.QMSUserPrincipal;
import org.cs.jwt.db.QMSUser;
import org.cs.jwt.db.QMSUserRepository;
import org.cs.jwt.db.UserService;

@Component
public class AppUserDetailService implements UserDetailsService {

  @Autowired
  private QMSUserRepository userRepository;

  public AppUserDetailService(UserService userService) {
  }

  @Override
  public final UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println("username::" + username);
    final QMSUser user;

    user = userRepository.findByUserid(new BigInteger(username));

    if (user == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");

    }

    return new QMSUserPrincipal(user);
  }

}