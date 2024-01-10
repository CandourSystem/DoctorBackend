package org.cs.jwt.dto;

public class RoleMenuDTO {
    Integer roleid;
    Integer menuid;

    String rolename;
    String menuname;
    String menuurl;
    Integer parentid;
    String parentmame;
    Integer isleafnode=0;
    String remarks="";
    String validflag = "Yes";
    public Integer getRoleid() {
        return roleid;
    }
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public Integer getMenuid() {
        return menuid;
    }
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public String getMenuname() {
        return menuname;
    }
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }
    public String getMenuurl() {
        return menuurl;
    }
    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl;
    }
    public Integer getParentid() {
        return parentid;
    }
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
    public String getParentmame() {
        return parentmame;
    }
    public void setParentmame(String parentmame) {
        this.parentmame = parentmame;
    }
    public Integer getIsleafnode() {
        return isleafnode;
    }
    public void setIsleafnode(Integer isleafnode) {
        this.isleafnode = isleafnode;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getValidflag() {
        return validflag;
    }
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }
    }
