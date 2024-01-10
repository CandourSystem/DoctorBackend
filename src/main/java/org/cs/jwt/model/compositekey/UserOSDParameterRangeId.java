package org.cs.jwt.model.compositekey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class UserOSDParameterRangeId implements Serializable {

    private static final long serialVersionUID = -1477337861755872661L;
    Integer userid;

    String osdpId;

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserOSDParameterRangeId))
            return false;

        final UserOSDParameterRangeId that = (UserOSDParameterRangeId) o;
        return Objects.equals(getUserid(), that.getUserid()) && Objects.equals(getOsdpId(), that.getOsdpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getOsdpId());
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getOsdpId() {
        return osdpId;
    }

    public void setOsdpId(String osdpId) {
        this.osdpId = osdpId;
    }

   

    

    

 

}