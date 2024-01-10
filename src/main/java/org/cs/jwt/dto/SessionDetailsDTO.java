package org.cs.jwt.dto;

public class SessionDetailsDTO {
    private String currentsessioncode;
    private String  previouslastsessioncode;
 
    public SessionDetailsDTO(String currentsessioncode, String previouslastsessioncode) {
        this.currentsessioncode = currentsessioncode;
        this.previouslastsessioncode = previouslastsessioncode;
    }

    public String getCurrentsessioncode() {
        return currentsessioncode;
    }

    public void setCurrentsessioncode(String currentsessioncode) {
        this.currentsessioncode = currentsessioncode;
    }

    public String getPreviouslastsessioncode() {
        return previouslastsessioncode;
    }

    public void setPreviouslastsessioncode(String previouslastsessioncode) {
        this.previouslastsessioncode = previouslastsessioncode;
    }
  
    
}