package pl.zajacp.springbootdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static pl.zajacp.springbootdemo.MyPropertiesConfiguration.PREFIX;

@ConfigurationProperties(PREFIX)
public record MyPropertiesConfiguration(
        String number,
        String string,
        String longPropertyName
) {
    static final String PREFIX = "my-properties";
}
