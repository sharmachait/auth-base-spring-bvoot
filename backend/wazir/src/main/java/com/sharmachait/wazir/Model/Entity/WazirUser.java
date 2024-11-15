package com.sharmachait.wazir.Model.Entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class WazirUser {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String fullName;
    @Column(unique = true)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// to make JPA ignore it when reading from the database
    private String password;
    private String mobile;
    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;
    @Embedded// to indicate to JPA that the properties of the class TwoFactorAuthService should be considered part of this table
    private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();

    @OneToOne(mappedBy = "user")
    private TwoFactorOtp twoFactorOtp;
}
