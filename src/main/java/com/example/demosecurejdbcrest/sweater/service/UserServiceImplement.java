package com.example.demosecurejdbcrest.sweater.service;

import com.example.demosecurejdbcrest.sweater.entity.Role;
import com.example.demosecurejdbcrest.sweater.entity.User;
import com.example.demosecurejdbcrest.sweater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserServiceInterface {

    private final UserRepository userRepository;
    private final EmailSender emailSender;

    @Autowired
    public UserServiceImplement(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }
    @Value("${site.path}")
    private String sitePath;

    @Override
    public boolean saveUser(String username, User user, Map<String, String> form) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean addUser(User user) {
        User usernameFromDB = userRepository.findUserByUsername(user.getUsername());
        if (usernameFromDB != null) {
            return false;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());

        userRepository.save(user);

        if (!StringUtils.isEmpty(user.getMail())){
            String massage = String.format(
              "Hello, %s! \n " +
                      "Welcome to club body! Please visit next link: " + sitePath,
                    user.getUsername(),
                    user.getActivationCode()
            );
            emailSender.send(user.getMail(),"Activation code", massage);
        }

        return true;
    }


    @Override
    public Model findAll(Model model) {
        List<User> users = userRepository.findAll();
        return model.addAttribute("user", users);
    }

    @Override
    public boolean activateUser(String code) throws NullPointerException {
        User user = userRepository.findByActivationCode(code);
        if (user != null) {
            return false;
        }
        user.setActivationCode(null);
        userRepository.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
