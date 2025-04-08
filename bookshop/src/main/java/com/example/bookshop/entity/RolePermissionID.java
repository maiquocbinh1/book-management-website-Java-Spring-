package com.example.bookshop.entity;

import java.io.Serializable;
import java.util.Objects;

public class RolePermissionID implements Serializable {
    private Integer roleID;
    private Integer permissionID;

    public RolePermissionID() {}

    public RolePermissionID(Integer roleID, Integer permissionID) {
        this.roleID = roleID;
        this.permissionID = permissionID;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePermissionID)) return false;
        RolePermissionID that = (RolePermissionID) o;
        return Objects.equals(roleID, that.roleID) && Objects.equals(permissionID, that.permissionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID, permissionID);
    }

}
