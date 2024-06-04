package pl.zajacp.springbootdemo.access;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER,
    ADMIN;

    private final String AUTHORITY_PREFIX = "ROLE_";

    public GrantedAuthority getAuthority() {
        return new SimpleGrantedAuthority(AUTHORITY_PREFIX + this.name());
    }
}
