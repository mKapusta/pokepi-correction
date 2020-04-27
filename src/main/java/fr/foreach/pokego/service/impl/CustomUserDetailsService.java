package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.entity.Utilisateur;
import fr.foreach.pokego.respository.UtilisateurJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UtilisateurJpaRepository utilisateurJpaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        Utilisateur user = utilisateurJpaRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        User.UserBuilder builder = User.withUsername(username);
        builder.password(encoder.encode(user.getMdp()));
        builder.roles(user.getRole());
        return builder.build();
    }

}
