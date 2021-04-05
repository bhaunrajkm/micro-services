package com.bhanu.currecnyconversion.service;

import com.bhanu.currecnyconversion.entities.User;
import com.bhanu.currecnyconversion.repository.UserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        logger.info("UserDetailsServiceImpl.loadUserByUsername name: " + name);
        Optional<User> userByName = userRepo.getByName(name);
        if (userByName.isPresent()) {
            User user = userByName.get();
            List<SimpleGrantedAuthority> simpleGrantedAuthorities = user.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRole()))
                    .collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(name, user.getPassword(), simpleGrantedAuthorities);
        }
        throw new UsernameNotFoundException("Resource not found for name: " + name);
    }
}
