package org.cs.jwt.db;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "m_userlogin")
public class QMSUser {
    @Id
    private BigInteger userid;
    private String username;
    public BigInteger getUserid() {
        return userid;
    }
    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    

}