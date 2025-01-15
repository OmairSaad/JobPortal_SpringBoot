package com.jobportal.Entities;
import com.jobportal.DTOS.LoginDTO;
import com.jobportal.DTOS.UserDTO;
import com.jobportal.Utility.ROLE;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @Column (unique = true, nullable = false)
    private String email;
    private ROLE role = ROLE.NORMAL;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ROLE getRole() {
        return role;
    }

    public void setRole(ROLE role) {
        this.role = role;
    }

    public User(Long id, String name, String password, String email, ROLE role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User() {
    }

    public UserDTO toDTO() {
        return new UserDTO(id, name, password, email, role);
    }

    public LoginDTO toLoginDTO() {
        return new LoginDTO(email,password);
    }
}
