package pl.zajacp.springbootdemo.access;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.zajacp.springbootdemo.user.UserRepository;

@Service
@RequiredArgsConstructor
class SpringUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(UserForAccess::fromEntity)
                .orElseThrow(() -> new UsernameNotFoundException("Username %s not found".formatted(username)));
    }
}
