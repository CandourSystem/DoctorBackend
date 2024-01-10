package org.cs.jwt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DataSourceDTO {
    Integer datasourcetypeid;
   
    @NotBlank(message = "Datasource type name is mandatory")
    @Size(min=2, max=50)
    String datasourcetypename="";
   
    String validflag = "Yes";
    String remarks = "-";
    public Integer getDatasourcetypeid() {
        return datasourcetypeid;
    }
    public void setDatasourcetypeid(Integer datasourcetypeid) {
        this.datasourcetypeid = datasourcetypeid;
    }
    public String getDatasourcetypename() {
        return datasourcetypename;
    }
    public void setDatasourcetypename(String datasourcetypename) {
        this.datasourcetypename = datasourcetypename;
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
