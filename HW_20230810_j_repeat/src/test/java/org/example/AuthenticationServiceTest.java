package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AuthenticationServiceTest {

    AuthenticationService authenticationService = new AuthenticationService();

    @BeforeEach
    void setUp() {
        UserDatabase.users.clear();
        UserDatabase.users.add(new User(1,
                "Sem",
                "321654",
                false,
                "sem@cxz.net"));
        UserDatabase.users.add(new User(2,
                "Ann",
                "987654",
                true,
                "ann@xzc.net"));
    }


    @Test
    void authenticateExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> authenticationService.authenticate(null, "123456"));
    }

    @Test
    void authenticateWrongPasswordTest() {
        assertThrows(AccessBlockedException.class, () -> authenticationService.authenticate("Sem", "415263"));
    }

    @Test
    void authenticateUserAccessBlockedTest(){
        assertThrows(AccessBlockedException.class, () -> authenticationService.authenticate("Sem", "321654"));
    }

    @Test
    void authenticateTest(){
        String expected = "Access is open!";
        assertEquals(expected, authenticationService.authenticate("Ann", "987654"));
    }

    @Test
    void grantAccessTest() {
        boolean expected = true;
        UserDatabase.users.get(0).setAccess(true);
        assertEquals(expected,UserDatabase.users.get(0).isAccess());
    }

    @Test
    void revokeAccessTest() {
        boolean expected = false;
        UserDatabase.users.get(1).setAccess(false);
        assertEquals(expected,UserDatabase.users.get(1).isAccess());
    }
}