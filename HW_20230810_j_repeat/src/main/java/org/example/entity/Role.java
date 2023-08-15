package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Role {
    private int id;
    private String roleName;
    private String description;

    @Override
    public String toString() {
        return "\n" + "Role: " + id +
                ", roleName: " + roleName +
                ", description: " + description + "\n";
    }

    public String getRoleInfo(){
        return id + ", " + roleName + ", " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}