package com.example.tomcattest.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class UserAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "authority")
    private String authority;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    @Override
    public String getAuthority() {
        return authority;
    }
}
