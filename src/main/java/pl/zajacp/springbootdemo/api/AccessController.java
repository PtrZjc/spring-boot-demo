package pl.zajacp.springbootdemo.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zajacp.springbootdemo.user.User;
import pl.zajacp.springbootdemo.user.UserService;

@Controller
@RequiredArgsConstructor
public class AccessController {

    private final UserService userService;

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("sign-up")
    public String createUser(User user, Model model) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "sign-up";
        }
        model.addAttribute("success", true);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login/fail")
    public String loginFailedPage() {
        return "login-failed";
    }

    @GetMapping("/403")
    public String unauthorized() {
        return "403";
    }
}
