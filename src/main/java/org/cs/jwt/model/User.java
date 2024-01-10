package org.cs.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "m_userlogin")
public class User {
    
    @Id
    private Long userid;

    
    @Column(unique = true)
    private String username;

    private String password;

    @Transient
    private String passwordConfirm;

   // @ManyToMany
   // private Set<Userrole> roles;

    public Long getUserid() {
        return userid;
    }

    public void setUserId(Long id) {
        this.userid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

  /*public Set<Userrole> getRoles() {
        return roles;
    }

    public void setRoles(Set<Userrole> roles) {
        this.roles = roles;
    }*/
}
