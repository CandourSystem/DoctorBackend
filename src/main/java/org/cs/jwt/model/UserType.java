package org.cs.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.cs.jwt.auditing.Auditable;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "m_usertype")
public class UserType extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "usertype_seq_gen")
    @SequenceGenerator(name = "usertype_seq_gen", sequenceName = "usertype_seq",allocationSize = 1)
    Integer usertypeid;
    
    @Column(unique = true)
    String usertypename;
    String validflag = "Yes";
    String remarks="-";
    public Integer getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(Integer usertypeid) {
        this.usertypeid = usertypeid;
    }

    public String getUsertypename() {
        return usertypename;
    }

    public void setUsertypename(String usertypename) {
        this.usertypename = usertypename;
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

}
