package com.jobportal.DTOS;

import com.jobportal.Entities.User;
import com.jobportal.Utility.ROLE;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDTO {
    private Long id;
    @NotBlank(message = "{user.name.blank}")
    private String name;
    @NotBlank(message= "{user.password.blank}")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "{user.password.pattern}"
    )
    private String password;
    @NotBlank(message = "{user.email.blank}")
    @Pattern( regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "{user.email.pattern}")
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

    public UserDTO(Long id, String name, String password, String email, ROLE role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public UserDTO() {}
    public User toUser() {
        return new User(id, name, password, email, role);
    }
}
