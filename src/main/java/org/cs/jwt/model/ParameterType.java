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
@Table(name = "m_parametertype")
public class ParameterType extends Auditable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "m_parametertypeseq_gen")
    @SequenceGenerator(name = "m_parametertypeseq_gen", sequenceName = "m_parametertype_seq",allocationSize = 1)
    Integer parametertypeid;
    
    @Column(unique = true)
    String parametertypename;
    String validflag = "Yes";
    String remarks = "-";
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
