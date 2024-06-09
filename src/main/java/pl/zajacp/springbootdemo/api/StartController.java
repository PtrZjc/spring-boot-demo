package pl.zajacp.springbootdemo.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.zajacp.springbootdemo.MyPropertiesConfiguration;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StartController {

    @Value("${my-properties.string}")
    private String string;

    @Value("${my-properties.number}")
    private String number;

    @Value("${my-properties.long-property-name}")
    private String longProperty;

    private final MyPropertiesConfiguration myPropertiesConfiguration;

    @GetMapping("/")
    public String start() {
        log.error("1. Easy way of injecting properties: {} {} {}", string, number, longProperty);
        log.error("1. Recommended way of injecting properties: {} {} {}",
                myPropertiesConfiguration.string(),
                myPropertiesConfiguration.number(),
                myPropertiesConfiguration.longPropertyName()
        );
        return "home";
    }
}
