package org.cs.jwt.model.compositekey;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class RoleMenuId implements Serializable {

    private static final long serialVersionUID = -1477337861755872661L;
    Integer roleid;

    Integer menuid;

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RoleMenuId))
            return false;

        final RoleMenuId that = (RoleMenuId) o;
        return Objects.equals(getRoleid(), that.getRoleid()) && Objects.equals(getMenuid(), that.getMenuid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleid(), getMenuid());
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

 

}