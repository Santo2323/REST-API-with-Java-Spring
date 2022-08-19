package com.example.informatorio.PruebaNoticias.DTO;

import java.time.LocalDateTime;

public class AuthorDTO {

    private Long id;
    private String firstname;

    private String lastname;

    private String fullname;

    private LocalDateTime createdAt;

    public AuthorDTO(Long id, String firstname, String lastname, String fullname, LocalDateTime createdAt) {
        this.id  = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = fullname;
        this.createdAt = createdAt;
    }

    public AuthorDTO() {

    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
