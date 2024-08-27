package api.Users.model.mappers;

import api.Users.model.dtos.UserDto;
import api.Users.model.entities.User;

public class UserMapper {
    public UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());  // Considera si quieres usar el ID o dejarlo como null para nuevos registros
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return user;
    }

}
