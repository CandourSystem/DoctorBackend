package org.cs.jwt.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DeviceTypeDTO {
    Integer devicetypeid;

    @NotBlank(message = "Device type name is mandatory")
    @Size(min=1, max=50,message = "Device type name size between 1 and 50")
    String devicetypename="";
    
    String validflag = "Yes";
    String remarks = "-";
   
    public Integer getDevicetypeid() {
        return devicetypeid;
    }
    public void setDevicetypeid(Integer devicetypeid) {
        this.devicetypeid = devicetypeid;
    }
    public String getDevicetypename() {
        return devicetypename;
    }
    public void setDevicetypename(String devicetypename) {
        this.devicetypename = devicetypename;
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
