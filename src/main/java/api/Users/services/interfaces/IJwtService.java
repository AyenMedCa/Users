package api.Users.services.interfaces;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    public String getToken(UserDetails user);

    String getUsernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
