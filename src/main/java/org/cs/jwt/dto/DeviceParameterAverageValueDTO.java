package org.cs.jwt.dto;

public class DeviceParameterAverageValueDTO {
    String parametertypeid;
    
    
    String parametertypename;

    String value;
    public String getParametertypeid() {
        return parametertypeid;
    }
    public void setParametertypeid(String parametertypeid) {
        this.parametertypeid = parametertypeid;
    }
    public String getParametertypename() {
        return parametertypename;
    }
    public void setParametertypename(String parametertypename) {
        this.parametertypename = parametertypename;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
}
