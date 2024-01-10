
package org.cs.jwt;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.cs.jwt.db.QMSUser;
import org.cs.jwt.db.QMSUserRepository;
import org.cs.jwt.security.jwt.TokenProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

  @Autowired
  QMSUserRepository qmsUserRepository;

  private final TokenProvider tokenProvider;


  private final AuthenticationManager authenticationManager;

  public AuthController(final PasswordEncoder passwordEncoder, final TokenProvider tokenProvider,
      final AuthenticationManager authenticationManager) {
    this.tokenProvider = tokenProvider;
    this.authenticationManager = authenticationManager;

  }

  @GetMapping("/authenticate")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void authenticate() {
    // we don't have to do anything here
    // this is just a secure endpoint and the JWTFilter
    // validates the token
    // this service is called at startup of the app to check
    // if the jwt token is still valid
  }

  @PostMapping("/login")
  public String authorize(@Valid @RequestBody final QMSUser loginUser, final HttpServletResponse response) {
    Application.logger.info("Actual Password ");

    final UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        loginUser.getUsername(), "");

    String returnString = null;
    try {
      this.authenticationManager.authenticate(authenticationToken);
      returnString = this.tokenProvider.createToken(loginUser.getUsername());
    } catch (AuthenticationException e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      Application.logger.info("Security  exception {}", e.getMessage());

    }

    return returnString;
  }

 
 @GetMapping("/getNewToken/{userid}")
  public String getNewToken(@PathVariable(required = true, name = "userid") final String userid, final HttpServletResponse response) {
    Application.logger.info("sessionid {}", userid);

    // fetch the userName and Password for the user from sesserver and create
    // validated Token checking with the sessionIDg
     QMSUser user = qmsUserRepository.findByUsername(userid);;

    String returnString = null;
    try {

      returnString = this.tokenProvider.createToken(user.getUserid().toString());
    } catch (AuthenticationException e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      Application.logger.info("Security  exception {}", e.getMessage());

    }

    return returnString;
  }

 
  
  @PostMapping("/initiatelogin")
  public String initiatelogin(@Valid @RequestBody final QMSUser loginUser, final HttpServletResponse response) {
    Application.logger.info("Actual Password ");
    final QMSUser user = qmsUserRepository.findByUsername(loginUser.getUsername());
    if (user != null) {
      return "EXISTS";
    }

    return "NOT-EXISTS";
  }

}
