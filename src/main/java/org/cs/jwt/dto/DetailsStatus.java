package org.cs.jwt.dto;

import java.math.BigInteger;

public class DetailsStatus {
    String elementname;
    String elementid;
    BigInteger elementcount;
    Double percentage;
    Double average;
    public String getElementname() {
        return elementname;
    }
    public void setElementname(String elementname) {
        this.elementname = elementname;
    }
    public String getElementid() {
        return elementid;
    }
    public void setElementid(String elementid) {
        this.elementid = elementid;
    }
    public Double getAverage() {
        return average;
    }
    public void setAverage(Double average) {
        this.average = average;
    }
    public BigInteger getElementcount() {
        return elementcount;
    }
    public void setElementcount(BigInteger elementcount) {
        this.elementcount = elementcount;
    }
    public Double getPercentage() {
        return percentage;
    }
    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    
}
