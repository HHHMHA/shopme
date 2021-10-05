package org.thekiddos.admin.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.thekiddos.shopmecommon.models.Role;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createRole() {
        Role admin = new Role( "Admin", "abh" );
        var savedAdmin = roleRepository.save( admin );
        assertThat( savedAdmin.getId() ).isGreaterThan( 0 );
        assertThat( savedAdmin.getName() ).isEqualTo( admin.getName() );
    }
}
