package org.cs.jwt.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.cs.jwt.auditing.Auditable;
import org.cs.jwt.model.compositekey.UserOSDParameterRangeId;

@Entity
@Table(name = "m_userosdparameterrange")
@IdClass(UserOSDParameterRangeId.class)
public class UserOSDParameterRange extends Auditable<String> {
    @Id
    Integer userid;
    @Id
    String osdpId;

    String username;
    Integer parametertypeid;
    String parametertypename;
    UUID deviceid;
    String devicename;
    UUID gatewayid;
    Integer devicetypeid;
    String devicetypename;
    Integer stationid;
    String stationname;
    Integer organizationid;
    String organizationname;
    Integer organizationtype;
    String organizationtypename;
    String emailid;
    String country;
    String state;
    String code;
    String zipcode;
    String unit;
    String validflag;
    String remarks = "-";
    Integer registerid;
    String companyname;
    Integer makeid;
    String makename;
    Integer modelid;
    String modelname;
    Integer warningmin;
    Integer warningmax;
    Integer dangermin;
    Integer dangermax;
    Integer rangemin;
    Integer rangemax;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOsdpId() {
        return osdpId;
    }

    public void setOsdpId(String osdpId) {
        this.osdpId = osdpId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public UUID getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(UUID deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public UUID getGatewayid() {
        return gatewayid;
    }

    public void setGatewayid(UUID gatewayid) {
        this.gatewayid = gatewayid;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValidflag() {
        return validflag;
    }

    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    public Integer getRegisterid() {
        return registerid;
    }

    public void setRegisterid(Integer registerid) {
        this.registerid = registerid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
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

    public Integer getWarningmin() {
        return warningmin;
    }

    public void setWarningmin(Integer warningmin) {
        this.warningmin = warningmin;
    }

    public Integer getWarningmax() {
        return warningmax;
    }

    public void setWarningmax(Integer warningmax) {
        this.warningmax = warningmax;
    }

    public Integer getDangermin() {
        return dangermin;
    }

    public void setDangermin(Integer dangermin) {
        this.dangermin = dangermin;
    }

    public Integer getDangermax() {
        return dangermax;
    }

    public void setDangermax(Integer dangermax) {
        this.dangermax = dangermax;
    }

    public Integer getRangemin() {
        return rangemin;
    }

    public void setRangemin(Integer rangemin) {
        this.rangemin = rangemin;
    }

    public Integer getRangemax() {
        return rangemax;
    }

    public void setRangemax(Integer rangemax) {
        this.rangemax = rangemax;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
