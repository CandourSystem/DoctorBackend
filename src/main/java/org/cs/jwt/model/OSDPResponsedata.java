package org.cs.jwt.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.cs.jwt.auditing.Auditable;

@Entity
@Table(name = "m_osdpdata")
public class OSDPResponsedata extends Auditable<String> {
    @Id
    private String dataid;

    Integer parameterid;
    String parametername;
    String responsedata;
    String processeddata;

    UUID deviceid;

    String devicename;
    String datauploadmethod;
    String simid;
    String networkid;
    String datafrequency;
    Integer devicetypeid;
    String devicetypename;
    Integer isgateway;
    UUID gatewayid;
    String uMacId;

    //makedetails
    Integer makeid;
    String makename;
    String companyname;

    //modeldetails
    Integer modelid;
    String modelname;

    Integer stationid;
    Integer organizationid;

    String organizationname;
    Integer organizationtype;
    String organizationtypename;
    String stationname;
    Integer stationtypetype;
    String stationtypename;

    Integer status;//devicestatus
    Integer statusName;//devicestatus
    String validflag;
    
    String partner;
    String emailid;
    String country;
    String state;
    String code;
    String addons;




    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date termenddate; // stationtermenddate

    String zipcode;
    String remarks;

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    public String getOrganizationname() {
        return organizationname;
    }

    public void setOrganizationname(String organizationname) {
        this.organizationname = organizationname;
    }

    public Integer getOrganizationtype() {
        return organizationtype;
    }

    public void setOrganizationtype(Integer organizationtype) {
        this.organizationtype = organizationtype;
    }

    public String getOrganizationtypename() {
        return organizationtypename;
    }

    public void setOrganizationtypename(String organizationtypename) {
        this.organizationtypename = organizationtypename;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusName() {
        return statusName;
    }

    public void setStatusName(Integer statusName) {
        this.statusName = statusName;
    }

    public String getValidflag() {
        return validflag;
    }

    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddons() {
        return addons;
    }

    public void setAddons(String addons) {
        this.addons = addons;
    }

    public Date getTermenddate() {
        return termenddate;
    }

    public void setTermenddate(Date termenddate) {
        this.termenddate = termenddate;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

   
    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDatauploadmethod() {
        return datauploadmethod;
    }

    public void setDatauploadmethod(String datauploadmethod) {
        this.datauploadmethod = datauploadmethod;
    }

    public String getSimid() {
        return simid;
    }

    public void setSimid(String simid) {
        this.simid = simid;
    }

    public String getNetworkid() {
        return networkid;
    }

    public void setNetworkid(String networkid) {
        this.networkid = networkid;
    }

    public String getDatafrequency() {
        return datafrequency;
    }

    public void setDatafrequency(String datafrequency) {
        this.datafrequency = datafrequency;
    }

    
   
    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }

    public String getResponsedata() {
        return responsedata;
    }

    public void setResponsedata(String responsedata) {
        this.responsedata = responsedata;
    }

    public String getProcesseddata() {
        return processeddata;
    }

    public void setProcesseddata(String processeddata) {
        this.processeddata = processeddata;
    }

    public Integer getParameterid() {
        return parameterid;
    }

    public void setParameterid(Integer parameterid) {
        this.parameterid = parameterid;
    }

    public String getParametername() {
        return parametername;
    }

    public void setParametername(String parametername) {
        this.parametername = parametername;
    }

    public UUID getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(UUID deviceid) {
        this.deviceid = deviceid;
    }

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

    public Integer getIsgateway() {
        return isgateway;
    }

    public void setIsgateway(Integer isgateway) {
        this.isgateway = isgateway;
    }

    public UUID getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(UUID gatewayid) {
        this.gatewayid = gatewayid;
    }

    public String getuMacId() {
        return uMacId;
    }

    public void setuMacId(String uMacId) {
        this.uMacId = uMacId;
    }

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

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    public Integer getStationtypetype() {
        return stationtypetype;
    }

    public void setStationtypetype(Integer stationtypetype) {
        this.stationtypetype = stationtypetype;
    }

    public String getStationtypename() {
        return stationtypename;
    }

    public void setStationtypename(String stationtypename) {
        this.stationtypename = stationtypename;
    }

}
