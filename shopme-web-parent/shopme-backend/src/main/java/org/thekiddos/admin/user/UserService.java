package org.thekiddos.admin.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thekiddos.shopmecommon.models.Role;
import org.thekiddos.shopmecommon.models.User;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService( UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }

    public List<Role> listRoles() {
        return (List<Role>) roleRepository.findAll();
    }

    public void save( User user ) {
        encodePassword( user );
        userRepository.save( user );
    }

    private void encodePassword( User user ) {
        user.setPassword( passwordEncoder.encode( user.getPassword() ) );
    }
}
