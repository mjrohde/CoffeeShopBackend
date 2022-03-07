package com.example.backends.model;

public class User {
  public String username;
  public String password;
  public String name;
  public String email;
  public String tlf;
  public Integer admin;



  public User(String username, String password, String name, String email, String tlf, Integer admin) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.email = email;
    this.tlf = tlf;
    this.admin = admin;
  }

  public String getTlf() {
    return tlf;
  }

  public void setTlf(String tlf) {
    this.tlf = tlf;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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
