package pl.zajacp.springbootdemo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER,
    ADMIN;
}
