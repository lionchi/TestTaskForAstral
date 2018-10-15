package com.gavrilov.model.dto;

public class UserDTO {
    private String login;
    private String password;
    private String fio;
    private Integer enabled;

    public UserDTO() {
    }

    public UserDTO(String login, String password, String fio, Integer enabled) {
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.enabled = enabled;
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
}
