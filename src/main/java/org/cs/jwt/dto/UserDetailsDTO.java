package org.cs.jwt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDetailsDTO{
    
    Integer userid;

    @NotBlank(message = "User Name is mandatory")
    @Size(min = 1, max = 50,message = "User Name size must be between 1 and 50")
    String username="";
   
    Integer usertype=0;

    @NotBlank(message = "Usertype is mandatory")
    String usertypename;

    @NotBlank(message = "Mobile No. is mandatory")
    String mobileno="";
    String emailid="";
    String country="";
    String state="";
    Integer ispartner;
    String validflag="Yes";
    String password="";
    String remarks="";  
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
   

}
