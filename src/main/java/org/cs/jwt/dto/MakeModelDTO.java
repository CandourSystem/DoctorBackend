package org.cs.jwt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MakeModelDTO{
    
    Integer modelid;
   
    @NotBlank(message = "Model name is mandatory")
    @Size(min=1, max=50)
    String modelname="";
   
    Integer makeid;
    String makename="";
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
    public Integer getModelid() {
        return modelid;
    }
    public void setModelid(Integer modelid) {
        this.modelid = modelid;
    }
    public String getModelname() {
        return modelname;
    }
    public void setModelname(String modelname) {
        this.modelname = modelname;
    }
  
   
   
 
}
