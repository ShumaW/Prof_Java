package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDatabaseTest {
    @BeforeEach
    void setUp() {
        UserDatabase.users.clear();
        UserDatabase.users.add(new User(1,
                "Sem",
                "321654",
                true,
                "sem@cxz.net"));
    }

    @Test
    void getUserByIdTest() {
        String expected = "Sem";
        int id = 1;
        UserDatabase.getUserById(id);
        assertEquals(expected,UserDatabase.users.get(0).getUserName());
    }

    @Test
    void getUserByIdExceptionTest() {
        int id = 10;
        assertThrows(NullPointerException.class, () -> UserDatabase.getUserById(id));
    }

    @Test
    void getUserByUsernameTest() {
        String expected = "sem@cxz.net";
        String name = "Sem";
        UserDatabase.getUserByUsername(name);
        assertEquals(expected,UserDatabase.users.get(0).getEmail());
    }

    @Test
    void getUserByUsernameExceptionTest() {
        String name = "Semm";
        assertThrows(IllegalArgumentException.class, () -> UserDatabase.getUserByUsername(name));
    }

    @Test
    void addUserTest() {
        User user2 = new User(2,"Ann", "325698", true, "ann@cnv.com");
        UserDatabase.addUser(user2);
        assertEquals(2, UserDatabase.users.size());
    }

    @Test
    void addUserExceptionTest(){
        User user3 = null;
        assertThrows(NullPointerException.class, () -> UserDatabase.addUser(user3));
    }
}