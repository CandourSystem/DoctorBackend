package org.cs.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.cs.jwt.auditing.Auditable;

@Entity
@Table(name = "m_menu")
public class Menu extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_menuseq_gen")
    @SequenceGenerator(name = "m_menuseq_gen", sequenceName = "m_menu_seq",allocationSize = 1)
    Integer menuid;
    
    
    @Column(unique = true)
    String menuname;
    String menuurl;
    String validflag = "Yes";
    String remarks = "-";
    Integer parentmenuId;
    String iconassociated;
    String isleafnode;
    String parentmenuname;
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
