package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    Role admin = new Role(1, "admin","");
    @Test
    void getRoleInfoTest() {
        assertEquals("1, admin, ", admin.getRoleInfo());
    }

    @Test
    void setDescriptionTest(){
        String description = "You can do what you want!";
        admin.setDescription(description);
        assertEquals("You can do what you want!", admin.getDescription());
    }

}