package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {
    private String firstName;
    private String lastName;
    private static final String companyDomainName = "@company.com";
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getInitials() {
        return firstName.charAt(0) + "." + lastName.charAt(0) + ".";
    }

    public String getEmail() {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + companyDomainName;
    }
}
