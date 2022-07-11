package com.example.clinicaOdontologica.login;

import com.example.clinicaOdontologica.entity.User;
import com.example.clinicaOdontologica.repository.impl.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private IUserRepository userRepository;

    @Autowired
    public DataLoader(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("password");
        String password2 = bCryptPasswordEncoder.encode("password2");
        userRepository.save(new User("Admin", "Admin", "admin@mail.com", password, UserRoles
                .ADMIN));
        userRepository.save(new User("User", "User", "user@mail.com", password2, UserRoles
                .USER));
    }
}
