package com.example.backends.model;

public class User {
  public String username;
  public String password;
  public Integer admin;

  public User(String username, String password, Integer admin) {
    this.username = username;
    this.password = password;
    this.admin = admin;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getAdmin() {
    return admin;
  }

  public void setAdmin(Integer admin) {
    this.admin = admin;
  }
}
