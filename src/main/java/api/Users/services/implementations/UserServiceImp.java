package api.Users.services.implementations;

import api.Users.model.dtos.UserDto;
import api.Users.model.entities.User;
import api.Users.model.mappers.UserMapper;
import api.Users.repositories.UserRepository;
import api.Users.services.interfaces.IUserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImp implements IUserServices {

    private final UserRepository userRepository;

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        assert user != null;
        return mapToDto(user);
    }

    private UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    private User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());  // Considera si quieres usar el ID o dejarlo como null para nuevos registros
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return user;
    }
}
