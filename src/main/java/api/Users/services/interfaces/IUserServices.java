package api.Users.services.interfaces;

import api.Users.model.dtos.UserDto;

public interface IUserServices {
    UserDto findById(Long id);
}
