package com.nanotate.model;

public class Permissions extends PermissionsKey {
    private String read_permission;

    private String admin_permission;

    private String update_permission;

    private String delete_permission;

    public String getRead_permission() {
        return read_permission;
    }

    public void setRead_permission(String read_permission) {
        this.read_permission = read_permission;
    }

    public String getAdmin_permission() {
        return admin_permission;
    }

    public void setAdmin_permission(String admin_permission) {
        this.admin_permission = admin_permission;
    }

    public String getUpdate_permission() {
        return update_permission;
    }

    public void setUpdate_permission(String update_permission) {
        this.update_permission = update_permission;
    }

    public String getDelete_permission() {
        return delete_permission;
    }

    public void setDelete_permission(String delete_permission) {
        this.delete_permission = delete_permission;
    }
}