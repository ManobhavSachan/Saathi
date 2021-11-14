package com.example.saathi.Models;

public class UsersInfo {

    String userId, userDp, userName, email, password, phoneNo, lastMessage, status;

    public UsersInfo(String userName, String email, String password, String phoneNo) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.lastMessage = lastMessage;
        this.status = status;
    }

    public UsersInfo(){}

//  SignUp Constructor;
    public UsersInfo(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserId(String key) {
        return userId;
    }
}
