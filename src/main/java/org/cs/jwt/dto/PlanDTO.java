package org.cs.jwt.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.cs.jwt.utility.validationannotaions.FromDateToDateCompare;



@FromDateToDateCompare.List({ 
    @FromDateToDateCompare(
      fromdate = "planeffectivestartdate", 
      todate = "planeffectiveenddate", 
      message = "Plan effective Start date to end date!"
    )
})
public class PlanDTO {
    Integer planid;
    
    @NotBlank(message = "Plan Name is mandatory")
    @Size(min=1, max=50)
    String planname="";
    String validflag = "Yes";
    String remarks = "-";
    Integer plancost;
    Date planeffectivestartdate;
    Date planeffectiveenddate;

    public Integer getPlanid() {
        return planid;
    }
    public void setPlanid(Integer planid) {
        this.planid = planid;
    }
    public String getPlanname() {
        return planname;
    }
    public void setPlanname(String planname) {
        this.planname = planname;
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
    public Integer getPlancost() {
        return plancost;
    }
    public void setPlancost(Integer plancost) {
        this.plancost = plancost;
    }
    public Date getPlaneffectivestartdate() {
        return planeffectivestartdate;
    }
    public void setPlaneffectivestartdate(Date planeffectivestartdate) {
        this.planeffectivestartdate = planeffectivestartdate;
    }
    public Date getPlaneffectiveenddate() {
        return planeffectiveenddate;
    }
    public void setPlaneffectiveenddate(Date planeffectiveenddate) {
        this.planeffectiveenddate = planeffectiveenddate;
    }
   
    
}
