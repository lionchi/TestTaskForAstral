package com.gavrilov.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "user")
public class User extends com.gavrilov.model.Entity {
    @NotEmpty
    @Column(name = "login", nullable = false)
    private String login;

    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "enabled", nullable = false)
    private Integer enabled;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Note> notes;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole userRole;


    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }


    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setTasks(List<Note> tasks) {
        this.notes = tasks;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return fio;
    }
}
