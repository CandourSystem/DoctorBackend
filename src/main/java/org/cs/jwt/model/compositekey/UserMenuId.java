package org.cs.jwt.model.compositekey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class UserMenuId implements Serializable {
    private static final long serialVersionUID = -1477337861755872661L;
    Integer userid;

    Integer menuid;

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserMenuId))
            return false;

        final UserMenuId that = (UserMenuId) o;
        return Objects.equals(getUserid(), that.getUserid()) && Objects.equals(getMenuid(), that.getMenuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getMenuid());
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

}
