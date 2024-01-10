package org.cs.jwt.dto;

public class ModbusData {
    String registerID;
    String value;
    public String getRegisterID() {
        return registerID;
    }
    public void setRegisterID(String registerID) {
        this.registerID = registerID;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
