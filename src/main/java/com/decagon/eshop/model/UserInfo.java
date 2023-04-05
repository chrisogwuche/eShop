package com.decagon.eshop.Model;

import com.decagon.eshop.enums.UserRole;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class UserInfo {

    /*
    * SequenceGenerator performs the auto increment in the database
    */
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    //    @Enumerated(EnumType.STRING) // how you want your enum to be represented in the database
    private UserRole userRole;
    private LocalDateTime createdAt;

    public UserInfo(String firstname, String lastname,String email, String password, UserRole userRole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.createdAt = LocalDateTime.now();
    }

}
