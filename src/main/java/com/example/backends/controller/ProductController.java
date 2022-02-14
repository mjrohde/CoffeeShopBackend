package com.example.backends.controller;

import com.example.backends.model.Coffee;
import com.example.backends.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
  @Resource
  ProductRepository repository;


  @GetMapping(value = "/popularCoffees", headers = "Accept=application/json")
  @ResponseBody
  public List<Coffee> getPopCoffee() {
    return repository.getPopularCoffees();
  }


  @GetMapping(value = "/allProducts", headers = "Accept=application/json")
  @ResponseBody
  public List<Coffee> allProducts() {
    return repository.getAllCoffees();
  }

  @GetMapping(value = "/uniqueNames", headers = "Accept=application/json")
  @ResponseBody
  public List<Object> uniqueNames() {
    return repository.getUniqueNames();
  }

  @GetMapping(value = "/getPrices", headers = "Accept=application/json")
  @ResponseBody
  public List<Object> getPrice() {
    return repository.getPrices();
  }

  /**
  @GetMapping(value = "/getAllWeaponSkins", headers = "Accept=application/json")
  @ResponseBody
  public List<WeaponSkins> getRandom() {
    return repository.getWeaponSkins();
  }

  /**
   * Gets a specific product from the database
   *
   * @param id id of the specific product
   * @return The Product
   */
  /**
  @GetMapping(value = "/details/{id}", headers = "Accept=application/json")
  @ResponseBody
  public List<Product> getProduct(@PathVariable String id) {
    return repository.getProducts(id);
  }

  @GetMapping(value = "/brands/{brand}", headers = "Accept=application/json")
  @ResponseBody
  public List<Product> getBrand(@PathVariable String brand) {
    return repository.getBrandFromDatabase(brand);
  }

  @GetMapping(value = "/shafts", headers = "Accept=application/json")
  @ResponseBody
  public List<Shaft> getAllShafts() {
    return repository.getShaftsDriver();
  }
  **/

}
