package org.cs.jwt.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserOrganizationDTO {

    Integer userid;

    Integer organizationid;

    String username;
    Integer usertype;
    String usertypename;

    String organizationname;
    Integer organizationtype;
    String organizationtypename;

    Integer status;
    String statusName;
    String validflag = "Yes";
    String partner;
    String emailid;
    String country;
    String state;
    String code;
    String addons;

    @JsonFormat(pattern = "dd/MM/yyyy")
    Date termenddate;

    String zipcode;
    String remarks;

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public Integer getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(Integer organizationtype) {
        this.organizationtype = organizationtype;
    }

    public String getOrganizationtypename() {
        return organizationtypename;
    }

    public void setOrganizationtypename(String organizationtypename) {
        this.organizationtypename = organizationtypename;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getValidflag() {
        return validflag;
    }

    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddons() {
        return addons;
    }

    public void setAddons(String addons) {
        this.addons = addons;
    }

    public Date getTermenddate() {
        return termenddate;
    }

    public void setTermenddate(Date termenddate) {
        this.termenddate = termenddate;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

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

}
