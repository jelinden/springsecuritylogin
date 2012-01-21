package fi.springsecuritylogin.tools;

import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fi.springsecuritylogin.domain.User;

public class HashedPasswordWithSalt {
  public static String getHashedPassword(User user) {
    ReflectionSaltSource saltSource = new ReflectionSaltSource();
    saltSource.setUserPropertyToUse("username");
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(5);
    return passwordEncoder.encode(user.getPassword());
  }
}
