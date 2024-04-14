package com.patika.kredinbizdeservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patika.kredinbizdeservice.model.constant.UserEntityColumnConstants;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = UserEntityColumnConstants.NAME, unique = false, nullable = false)
    private String name;

    @Column(name = UserEntityColumnConstants.SURNAME, unique = false, nullable = false)
    private String surname;

    @Column(name = UserEntityColumnConstants.BIRTH_DATE, nullable = true)
    private LocalDate birthDate;

    @Column(name = UserEntityColumnConstants.EMAIL, unique = true, nullable = false)
    private String email;

    @Column(name = UserEntityColumnConstants.PASSWORD, unique = false, nullable = false)
    private String password;
    
    @Transient
    private String password2;

    @Column(name = UserEntityColumnConstants.PHONE_NUMBER, unique = false, nullable = true)
    private String phoneNumber;

    @Column(name = UserEntityColumnConstants.IS_ACTIVE, unique = false, nullable = true)
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = UserEntityColumnConstants.ADDRESS, unique = false,  nullable = true)
    private Address address;
    
   /* @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LoanApplication> loanApplications;
    
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CardApplication> cardApplications;*/

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
