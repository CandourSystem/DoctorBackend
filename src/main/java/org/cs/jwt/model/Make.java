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
@Table(name = "m_make")
public class Make extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_makeseq_gen")
    @SequenceGenerator(name = "m_makeseq_gen", sequenceName = "m_make_seq",allocationSize = 1)
    Integer makeid;
    
    @Column(unique = true)
    String makename;
    String companyname;
    String validflag = "Yes";
    String remarks = "-";
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
    public String getCompanyname() {
        return companyname;
    }
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
  
   
   
 
}
