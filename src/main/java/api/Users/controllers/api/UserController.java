package api.Users.controllers.api;

import api.Users.model.dtos.UserDto;
import api.Users.services.implementations.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserServiceImp userServiceImp;

    @GetMapping()
    public String welcome() {
        return "Hello World!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable long id) {
        UserDto user = userServiceImp.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
}
