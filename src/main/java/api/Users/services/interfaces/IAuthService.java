package api.Users.services.interfaces;

import api.Users.controllers.auth.AuthResponse;
import api.Users.controllers.auth.LoginRequest;
import api.Users.controllers.auth.RegisterRequest;

public interface IAuthService {
    public AuthResponse login(LoginRequest loginRequest);
    public AuthResponse register(RegisterRequest registerRequest);
}
    