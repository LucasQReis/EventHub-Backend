package com.api.EventHub.model.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "NM_NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastname;

    @Column(name = "DS_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "DS_PASSWORD", nullable = false)
    private String password;

    @Column(name = "level_acess", nullable = false)
    private String levelAcess; // Alterado de 'char' para 'String'

    @Column(name = "date_create_acount", nullable = false)
    private Date dateCreateAcount; // Alterado de 'String' para 'LocalDateTime'

    @Column(name = "ie_status", nullable = false)
    private Boolean ieStatus; // Alterado de 'String' para 'Boolean'

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
