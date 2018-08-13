package com.example.auth.user.model;

import java.util.Collection; 
import javax.persistence.*; 
import lombok.*;

//@Data로 사용 가능
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class User {
  
    public User() {}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String username;
    private String email;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
 
    @ManyToMany
    @JoinTable( 
        name = "users_roles", 
        joinColumns = @JoinColumn(
          name = "user_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
}
