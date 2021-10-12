package org.thekiddos.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.thekiddos.shopmecommon.models.Role;
import org.thekiddos.shopmecommon.models.User;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole() {
        var role = entityManager.find( Role.class, 1 );
        User user = new User("test@test.com", "password", "first", "last");
        user.addRole( role );

        user = userRepository.save( user );
        assertThat( user.getId() ).isGreaterThan( 0 );
    }

    @Test
    public void testCreateUserWithTwoRole() {
        var role = entityManager.find( Role.class, 1 );
        var secondRole = new Role();
        secondRole.setId( 2 );
        User user = new User("test2@test.com", "password", "first", "last");
        user.addRole( role );
        user.addRole( secondRole );

        user = userRepository.save( user );
        assertThat( user.getId() ).isGreaterThan( 0 );
    }

    @Test
    public void testListAllUsers() {
        var users = userRepository.findAll();
        users.forEach( System.out::println );
    }

    @Test
    public void testGetUserById() {
        User user = userRepository.findById( 1 ).get();
        assertThat( user ).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        var user = userRepository.findById( 1 ).get();
        user.setEnabled( true );
        user.setEmail( "test2new@test.com" );
        user = userRepository.save( user );
        assertThat( user.getEmail() ).isEqualTo( "test2new@test.com" );
    }

    @Test
    public void testUpdateUserRoles() {
        var role = entityManager.find( Role.class, 1 );
        var user = userRepository.findById( 1 ).get();
        user.getRoles().remove( role );
        user = userRepository.save( user );
    }

    @Test
    public void testDeleteUser() {
        userRepository.deleteById( 1 );
    }
}
