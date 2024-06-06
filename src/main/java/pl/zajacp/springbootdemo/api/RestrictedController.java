package pl.zajacp.springbootdemo.api;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/restricted")
public class RestrictedController {

    @Secured("ROLE_USER")
    @GetMapping("/user")
    public String getUserRestricted(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("User {} accessed restricted page", userDetails.getUsername());
        return "restricted";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String getAdminRestricted(@AuthenticationPrincipal UserDetails userDetails) {
        log.info("Admin {} accessed restricted page", userDetails.getUsername());
        return "restricted";
    }
}
