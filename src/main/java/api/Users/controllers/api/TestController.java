package api.Users.controllers.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class TestController {

    @GetMapping("/public/hello")
    public String publicHello() {
        return "Hello, public!";
    }

    @GetMapping("/user/hello")
    @PreAuthorize("hasRole('USER')")
    public String userHello() {
        return "Hello, user!";
    }

    @GetMapping("/admin/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminHello() {
        return "Hello, admin!";
    }

}
