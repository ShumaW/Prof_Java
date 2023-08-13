package org.example;

public class Main {
    public static void main(String[] args) {

        Role admin = new Role(1, "admin","");
        Role moderator = new Role(2, "moderator","You can moderate chat!");
        Role user = new Role(3, "user","You are user.");


        admin.setDescription("You can do what you want!");
        System.out.println(admin.getRoleInfo());
        System.out.println("-".repeat(50));

        User user1 = new User(1,
                "Jack",
                "123456789",
                true,
                "jack@gmail.com"
                );
        user1.addRole(user);
        user1.addRole(admin);

        User user2 = new User(2,
                "Sem",
                "023568",
                true,
                "sem@gmail.com");
        user2.addRole(moderator);

        User user3 = new User(3,
                "Ann",
                "258963",
                true,
                "ann@gmail.com");
        System.out.println(user3.getUserInfo());
        user3.addRole(admin);
        user3.addRole(moderator);
        user3.addRole(user);

        System.out.println(user3.getUserInfo());
        System.out.println("-".repeat(50));

        UserDatabase userDatabase = new UserDatabase();
        UserDatabase.addUser(user1);
        UserDatabase.addUser(user2);
        UserDatabase.addUser(user3);
        System.out.println(userDatabase);
        System.out.println("-".repeat(50));

        user1.removeRole(admin);
        System.out.println(userDatabase);
        System.out.println("-".repeat(50));

        System.out.println(UserDatabase.getUserById(2));
        System.out.println("-".repeat(50));
        System.out.println(user2.getPassword());

        AuthenticationService authenticationService = new AuthenticationService();

        System.out.println(authenticationService.authenticate("Sem", "023568"));
        System.out.println("-".repeat(50));

        authenticationService.revokeAccess(user1);
        System.out.println(user1.getUserInfo());
        System.out.println(authenticationService.authenticate("Jack", "123456789"));
        System.out.println("-".repeat(50));
        authenticationService.grantAccess(user1);
        System.out.println(user1.getUserInfo());
        System.out.println(authenticationService.authenticate("Jack", "123456789"));


    }
}