package org.cs.jwt.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.cs.jwt.auditing.Auditable;
import org.cs.jwt.model.compositekey.RoleMenuId;

@Entity
@Table(name = "m_rolemenu")
@IdClass(RoleMenuId.class)
public class RoleMenuModel extends Auditable<String> {
    @Id
    Integer roleid;
    @Id
    Integer menuid;

    String rolename;
    String menuname;
    String menuurl;
    Integer parentid;
    String parentname;
    Integer isleafnode=0;
    String remarks;
    String validflag = "Yes";
    public Integer getRoleid() {
        return roleid;
    }
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    public Integer getMenuid() {
        return menuid;
    }
    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
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
        return parentname;
    }
    public void setParentname(String parentname) {
        this.parentname = parentname;
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
    public Integer getIsleafnode() {
        return isleafnode;
    }
    public void setIsleafnode(Integer isleafnode) {
        this.isleafnode = isleafnode;
    }





    
}
