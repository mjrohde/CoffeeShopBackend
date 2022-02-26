package com.example.backends.model;

public class Coffee {
  String name;
  String brand;
  double price;
  String image;
  String type;

  public Coffee(String name, String brand, double price, String image, String type) {
    this.name = name;
    this.brand = brand;
    this.price = price;
    this.image = image;
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}
