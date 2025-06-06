/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author an0other
 */
public class UserDTO {
    private String userID;
    private String password;
    private String fullname;
    private String roleID;
    private boolean status;

    public UserDTO() {
    }

    public UserDTO(String userID, String password, String fullname, String roleID, boolean status) {
        this.userID = userID;
        this.password = password;
        this.fullname = fullname;
        this.roleID = roleID;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public String getRoleID() {
        return roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "fullname=" + fullname + ", roleID=" + roleID + '}';
    }
    
    
}
