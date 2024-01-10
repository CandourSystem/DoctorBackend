package org.cs.jwt.dto;




public class UserMenuDTO  {
  
    Integer userid;
 
    Integer menuid;

    String username;
    Integer usertype;
    String usertypename;

    String menuname;
    String menuurl;
    String validflag = "Yes";
    String remarks = "-";
    Integer parentmenuId;
    String iconassociated;
    String isleafnode;
    String parentmenuname;
    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public Integer getMenuid() {
        return menuid;
    }
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getUsertype() {
        return usertype;
    }
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }
    public String getUsertypename() {
        return usertypename;
    }
    public void setUsertypename(String usertypename) {
        this.usertypename = usertypename;
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
    public Integer getParentmenuId() {
        return parentmenuId;
    }
    public void setParentmenuId(Integer parentmenuId) {
        this.parentmenuId = parentmenuId;
    }
    public String getIconassociated() {
        return iconassociated;
    }
    public void setIconassociated(String iconassociated) {
        this.iconassociated = iconassociated;
    }
    public String getIsleafnode() {
        return isleafnode;
    }
    public void setIsleafnode(String isleafnode) {
        this.isleafnode = isleafnode;
    }
    public String getParentmenuname() {
        return parentmenuname;
    }
    public void setParentmenuname(String parentmenuname) {
        this.parentmenuname = parentmenuname;
    }

}
