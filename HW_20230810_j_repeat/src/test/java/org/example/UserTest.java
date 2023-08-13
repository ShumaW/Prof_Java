package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    Role role;

    User user1;

    @BeforeEach
    void setUp() {
        user1 = new User(1,
                "Ann",
                "123456789",
                true,
                "ann@gmail.com");
    }

    @Test
    void getUserInfoTest() {
        String expected = "1 Ann ann@gmail.com [] " + true + "\n";
        assertEquals(expected, user1.getUserInfo());
    }

    @Test
    void addRoleExceptionTest() {
        role = null;
        assertThrows(NullPointerException.class, () -> user1.addRole(role));
    }

    @Test
    void addRoleTest() {
        role = new Role(1, "admin", "");
        user1.addRole(role);
        assertEquals(1, user1.getRoles().size());
    }

    @Test
    void removeRoleTest() {
        role = new Role(1, "admin", "");
        user1.removeRole(role);
        assertEquals(0, user1.getRoles().size());
    }
}