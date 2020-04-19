package org.itstep.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AcademyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private final AcademyUserDetailsService academyUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    public AcademyAuthenticationProvider(AcademyUserDetailsService academyUserDetailsService) {
        this.academyUserDetailsService = academyUserDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        log.info("authenticate user {} by password {}", username, password);
        UserDetails userDetails = null;
        try {
            userDetails = academyUserDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("Not valid password");
            }
            log.info("su");
        } catch (Exception ex) {
            log.error("User not found");
            throw new BadCredentialsException("User not found ", ex);
        }
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
