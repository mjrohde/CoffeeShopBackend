package com.example.backends.controller;

import com.example.backends.model.Coffee;
import com.example.backends.model.CoffeeType;
import com.example.backends.model.User;
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

  @GetMapping(value = "/getCoffee/{name}", headers = "Accept=application/json")
  @ResponseBody
  public List<Coffee> indCoffee(@PathVariable String name) {
    return repository.getCoffee(name);
  }

  @GetMapping(value = "/getPrices", headers = "Accept=application/json")
  @ResponseBody
  public List<Object> getPrice() {
    return repository.getPrices();
  }

  @GetMapping(value = "/uniqueNames", headers = "Accept=application/json")
  @ResponseBody
  public List<Object> getUniqueNames() {
    return repository.getUniqueNames();
  }

  @PostMapping(value= "/login")
  @ResponseBody
  public List<User> checkUser(@RequestBody String line) {
    return repository.loginUser(line);
  }

  @GetMapping(value="/allCoffeeTypes", headers = "Accept=application/json")
  @ResponseBody
  public List<CoffeeType> getAllTypes() {
    return repository.getCoffeeTypes();
  }

  @PostMapping(value="/deleteUser")
  @ResponseBody
  public boolean deleteUser(@RequestBody String username){
    return repository.deleteUser(username);
  }

  @PostMapping(value ="/addUser")
  @ResponseBody
  public String addUserToDatabase(@RequestBody String requestBody) {
    var success = repository.createUser(requestBody);
    return "" + success;
  }
}


