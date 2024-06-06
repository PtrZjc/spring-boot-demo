package pl.zajacp.springbootdemo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Make sure new roles are added to the database when the application starts.
     * */
    @EventListener(ContextRefreshedEvent.class)
    void initializeRoles() {
        Set<Role> existingRoles = roleRepository.findAll()
                .stream()
                .map(RoleEntity::getName)
                .collect(Collectors.toSet());

        Arrays.stream(Role.values())
                .filter(role -> !existingRoles.contains(role))
                .map(RoleEntity::new)
                .forEach(roleRepository::save);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity userRole = roleRepository.findByName(Role.USER);
        user.setRoles(Set.of(userRole));
        userRepository.save(user);
    }
}
