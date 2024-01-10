package org.cs.jwt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.cs.jwt.auditing.Auditable;

@Entity
@Table(name = "m_userdetails")
public class UserDetails extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_menuseq_gen")
    @SequenceGenerator(name = "m_menuseq_gen", sequenceName = "m_menu_seq",allocationSize = 1)
    Integer userid;
    String username;
    Integer usertype;
    String usertypename;
    String mobileno;
    String emailid;
    String country;
    String state;
    Integer ispartner;
    String validflag;
    String remarks;
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getUsertype() {
        return usertype;
    }
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }
    public String getUsertypename() {
        return usertypename;
    }
    public void setUsertypename(String usertypename) {
        this.usertypename = usertypename;
    }
    public String getMobileno() {
        return mobileno;
    }
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
    public String getEmailid() {
        return emailid;
    }
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Integer getIspartner() {
        return ispartner;
    }
    public void setIspartner(Integer ispartner) {
        this.ispartner = ispartner;
    }
    public String getValidflag() {
        return validflag;
    }
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
   

}
