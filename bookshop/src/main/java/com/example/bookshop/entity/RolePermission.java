package com.example.bookshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "RolePermissions")
public class RolePermission {

    @EmbeddedId
    private RolePermissionID id;

    @ManyToOne
    @MapsId("roleID")
    @JoinColumn(name = "RoleID")
    private Role role;

    @ManyToOne
    @MapsId("permissionID")
    @JoinColumn(name = "PermissionID")
    private Permission permission;

    public RolePermission() {}

    public RolePermission(Role role, Permission permission) {
        this.role = role;
        this.permission = permission;
        this.id = new RolePermissionID(role.getRoleID(), permission.getPermissionID());
    }

    public RolePermissionID getId() {
        return id;
    }

    public void setId(RolePermissionID id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
