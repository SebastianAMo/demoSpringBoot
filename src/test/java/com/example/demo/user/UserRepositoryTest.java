package com.example.demo.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFindUser() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setAge(30);
        user.setCity("New York");

        userRepository.save(user);

        User foundUser = userRepository.findById(user.getId()).orElse(null);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo("John Doe");
    }
}
