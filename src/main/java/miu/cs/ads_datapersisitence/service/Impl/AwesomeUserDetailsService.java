package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AwesomeUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public AwesomeUserDetailsService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(username);
        var userDetails = new AwesomeUserDetails(user);
        return userDetails;
    }
}
