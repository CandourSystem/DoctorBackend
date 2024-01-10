package org.cs.jwt.model.compositekey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class UserOrganizationId implements Serializable {

    private static final long serialVersionUID = -1477337861755872661L;
    Integer userid;

    Integer organizationid;

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserOrganizationId))
            return false;

        final UserOrganizationId that = (UserOrganizationId) o;
        return Objects.equals(getUserid(), that.getUserid()) && Objects.equals(getOrganizationid(), that.getOrganizationid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getOrganizationid());
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Integer organizationid) {
        this.organizationid = organizationid;
    }

    

    

 

}