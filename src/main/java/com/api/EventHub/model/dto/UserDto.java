package com.api.EventHub.model.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date birthday;

    @JsonProperty("DS_EMAIL")
    @NotNull(message = "Email cannot be null")
    private String email;

    @JsonProperty("PHONE")
    private String phone;

    @JsonProperty("DS_PASSWORD")
    private String password;

    @JsonProperty("level_acess")
    private String levelAcess;

    @JsonProperty("date_create_acount")
    private Date dateCreateAcount;

    @JsonProperty("ie_status")
    private Boolean ieStatus;

    // Getters and Setters

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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