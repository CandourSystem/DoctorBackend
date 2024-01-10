package org.cs.jwt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_responsedata")
public class Responsedata {
    @Id
    String pkey;//uuid+timestamp
    String uuid;
    String make;
    
    String data = null;
    String cmd = null;
    String uid = null;
    String time;
    String v=null;
    String errorcode;
    String validflag = "Y";
    Integer processed = 0;
    Integer processingtype= 1                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ;
    public String getPkey() {
        return pkey;
    }
    public void setPkey(String pkey) {
        this.pkey = pkey;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
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
    public String getValidflag() {
        return validflag;
    }
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }
    public Integer getProcessed() {
        return processed;
    }
    public void setProcessed(Integer processed) {
        this.processed = processed;
    }
    public Integer getProcessingtype() {
        return processingtype;
    }
    public void setProcessingtype(Integer processingtype) {
        this.processingtype = processingtype;
    }
    
   
   
 
}
