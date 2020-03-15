package org.itstep.models;


import org.itstep.validators.PhoneUa;

import javax.validation.constraints.*;

public class User {

    private int id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String checkPassword;
    @Email
    @NotNull
    private String email;
    @PhoneUa
    private int phone;
    @NotBlank
    private String gender;

    public User() {
    }

    public User(int id, String login, String password, String email, int phone, String gender) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", gender='" + gender + '\'' +
                '}';
    }

}
