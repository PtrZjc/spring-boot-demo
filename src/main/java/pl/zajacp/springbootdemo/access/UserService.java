package pl.zajacp.springbootdemo.access;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.GroupManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDetailsManager userDao;
    private final GroupManager groupDao;
    private final PasswordEncoder passwordEncoder;

    public Optional<UserDetails> findByUserName(String username) {
        try {
            return Optional.of(userDao.loadUserByUsername(username));
        } catch (UsernameNotFoundException e) {
            return Optional.empty();
        }
    }

    public void saveRegularUser(User user) {
        var encodedPassword = passwordEncoder.encode(user.getPassword());
        var springUser = new org.springframework.security.core.userdetails.User(
                user.getUsername(), encodedPassword, List.of(Role.USER.getAuthority()));
        userDao.createUser(springUser);
    }
}
