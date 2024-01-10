package org.cs.jwt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleDTO {
    Integer roleid;

    @NotBlank(message = "Parameter type Name is mandatory")
    @Size(min=1, max=50)
    String rolename="";
    String validflag = "Yes";
    String remarks = "-";
    public Integer getRoleid() {
        return roleid;
    }
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
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
