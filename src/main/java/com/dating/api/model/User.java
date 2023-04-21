package com.dating.api.model;

import com.dating.api.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //TODO REVIEW IF THERE'S MORE FIELDS THAT WILL BE NEEDED

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String email;

    @NotNull
    @JsonIgnore // ADD SECURITY
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    private String bio;

    @NotNull
    private LocalDateTime lastLogin;

    @NotNull
    private Integer loginAttempts = 0;

    @NotNull
    private Boolean isBlocked = false;

    @NotNull
    private LocalDateTime createAt = LocalDateTime.now();

    @NotNull
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    private void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
