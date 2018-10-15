package com.gavrilov.model;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "user_role")
public class UserRole extends com.gavrilov.model.Entity {
    @NotNull
    @Column(name = "rolename", nullable = false)
    private String rolename;

    @OneToMany(mappedBy = "userRole", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<User> users;

    public UserRole() {
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return rolename;
    }
}
