package org.cs.jwt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MakeDTO {
    Integer makeid;

    
    @NotBlank(message = "Make name is mandatory")
    @Size(min=1, max=50)
    String makename="";

    @NotBlank(message = "Company name is mandatory")
    @Size(min=1, max=50)
    String companyname="";
    String validflag = "Yes";
    String remarks = "-";
    public Integer getMakeid() {
        return makeid;
    }
    public void setMakeid(Integer makeid) {
        this.makeid = makeid;
    }
    public String getMakename() {
        return makename;
    }
    public void setMakename(String makename) {
        this.makename = makename;
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
    public String getCompanyname() {
        return companyname;
    }
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
  
}
