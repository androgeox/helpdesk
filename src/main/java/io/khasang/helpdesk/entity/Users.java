package io.khasang.helpdesk.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String login;
    private String password;
    private String email;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users")
    private Set<Status>  statuses = new HashSet<Status>();


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
