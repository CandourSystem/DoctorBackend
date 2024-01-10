package org.cs.jwt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParameterTypeDTO {
    Integer parametertypeid;

    @NotBlank(message = "Parameter type Name is mandatory")
    @Size(min=1, max=50)
    String parametertypename="";
    String validflag = "Yes";
    String remarks = "-";
    public Integer getParametertypeid() {
        return parametertypeid;
    }
    public void setParametertypeid(Integer parametertypeid) {
        this.parametertypeid = parametertypeid;
    }
    public String getParametertypename() {
        return parametertypename;
    }
    public void setParametertypename(String parametertypename) {
        this.parametertypename = parametertypename;
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
