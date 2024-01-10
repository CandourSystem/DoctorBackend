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
@Table(name = "m_datasourcetype")
public class DataSourceType extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_datasourcetypeseq_gen")
    @SequenceGenerator(name = "m_datasourcetypeseq_gen", sequenceName = "m_datasourcetype_seq",allocationSize = 1)
    Integer datasourcetypeid;
    
    @Column(unique = true)
    String datasourcetypename;
    String validflag = "Yes";
    String remarks = "-";
    public Integer getDatasourcetypeid() {
        return datasourcetypeid;
    }
    public void setDatasourcetypeid(Integer datasourcetypeid) {
        this.datasourcetypeid = datasourcetypeid;
    }
    public String getDatasourcetypename() {
        return datasourcetypename;
    }
    public void setDatasourcetypename(String datasourcetypename) {
        this.datasourcetypename = datasourcetypename;
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
