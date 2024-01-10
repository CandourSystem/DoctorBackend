package org.cs.jwt.dto;

import java.util.UUID;

public class OptionDTO {
    private String value;
    private String label;
 
    public OptionDTO(String value, String label) {
        this.value = value;
        this.label = label;
    }
    public OptionDTO(Integer value, String label) {
        this.value = ""+value;
        this.label = label;
    }

    public OptionDTO(UUID value, String label) {
        this.value = value.toString();
        this.label = label;
    }
    public OptionDTO(Long value, String label) {
        this.value = ""+value;
        this.label = label;
    }

    public OptionDTO(String value, String label, String label2) {
        this.value = value;
        this.label = label+"-"+label2;
    }

    public OptionDTO(int value1,String value2,String label, String label2) {
        this.value = value1+"*"+value2;
        this.label = label;
    }

    public OptionDTO() {
        //empty constructor
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
    
}