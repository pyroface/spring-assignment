package com.example.projectarbetecomplexjavaspring.security;

import com.example.projectarbetecomplexjavaspring.entity.UserEntity;
import com.example.projectarbetecomplexjavaspring.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SchoolUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SchoolUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Can't find user with username: " + "username");
        }
        return new UserPrincipal(userEntity);
    }
}
