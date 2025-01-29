package com.api.EventHub.model.dto;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @JsonProperty("name")
    @NotNull(message = "Name cannot be null")
    private String name;

    @JsonProperty("lastname")
    @NotNull(message = "Lastname cannot be null")
    private String lastname;

    @JsonProperty("email")
    @NotNull(message = "Email cannot be null")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("password")
    @NotNull(message = "Password cannot be null")
    private String password;

    @JsonProperty("levelAcess")
    @NotNull(message = "Level acess cannot be null")
    private String levelAcess;

    @JsonProperty("dateCreated")
    private Date dateCreated;

    @JsonProperty("status")
    private Boolean status;

    // Getters and Setters

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}