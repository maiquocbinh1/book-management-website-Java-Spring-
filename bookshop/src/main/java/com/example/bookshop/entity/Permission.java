package com.example.bookshop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Roles")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PermessionID")
    private Integer permissionID;

    @Column(name = "PermissionName", unique = true, nullable = false, length = 100)
    private String permissionName;

    public Permission(){
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
