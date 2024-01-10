package org.cs.jwt.dto;

import java.util.List;

public class ResponseDataDTO {
    String make;
    
    String uuid = null;
    String data = null;
    String cmd = null;
    String uid = null;
    String time;
    String v=null;
    String errorcode;
    List<ResponseDataInterfaceDTO> interface1=null;
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getCmd() {
        return cmd;
    }
    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getV() {
        return v;
    }
    public void setV(String v) {
        this.v = v;
    }
    public String getErrorcode() {
        return errorcode;
    }
    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
    public List<ResponseDataInterfaceDTO> getInterface1() {
        return interface1;
    }
    public void setInterface1(List<ResponseDataInterfaceDTO> interface1) {
        this.interface1 = interface1;
    }
  

   
   
    
}
