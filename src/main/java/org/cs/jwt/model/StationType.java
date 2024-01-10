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
@Table(name = "m_stationtype")
public class StationType extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_stationtypeseq_gen")
    @SequenceGenerator(name = "m_stationtypeseq_gen", sequenceName = "m_stationtype_seq",allocationSize = 1)
    Integer stationtypeid;
    
    @Column(unique = true)
    String stationtypename;
    String validflag = "Yes";
    String remarks = "-";
    public Integer getStationtypeid() {
        return stationtypeid;
    }
    public void setStationtypeid(Integer stationtypeid) {
        this.stationtypeid = stationtypeid;
    }
    public String getStationtypename() {
        return stationtypename;
    }
    public void setStationtypename(String stationtypename) {
        this.stationtypename = stationtypename;
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
