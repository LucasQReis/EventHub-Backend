package com.api.EventHub.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long userId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "level_acess", nullable = false)
    private String levelAcess;

    @Column(name = "date_create_acount", nullable = false)
    private Date dateCreateAcount;

    @Column(name = "ie_status", nullable = false)
    private Boolean ieStatus;

    // Getters e Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevelAcess() {
        return levelAcess;
    }

    public void setLevelAcess(String levelAcess) {
        this.levelAcess = levelAcess;
    }

    public Date getDateCreateAcount() {
        return dateCreateAcount;
    }

    public void setDateCreateAcount(Date dateCreateAcount) {
        this.dateCreateAcount = dateCreateAcount;
    }

    public Boolean getIeStatus() {
        return ieStatus;
    }

    public void setIeStatus(Boolean ieStatus) {
        this.ieStatus = ieStatus;
    }
}
