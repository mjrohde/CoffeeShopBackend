package com.example.backends.repository;

import com.example.backends.model.Coffee;
import com.example.backends.model.User;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  public List<Coffee> getPopularCoffees() {
    var sql = "select * from coffees limit 4";
    List<Coffee> arrayList;

    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> new Coffee(rs.getString("product"), rs.getString("brand"), rs.getDouble("price"), rs.getString("image"), rs.getString("type"))
    );
    return arrayList;
  }

  public List<Coffee> getAllCoffees() {
    var sql = "select * from coffees";
    List<Coffee> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> new Coffee(rs.getString("product"), rs.getString("brand"), rs.getDouble("price"), rs.getString("image"), rs.getString("type"))
    );
    return arrayList;
  }

  public List<Coffee> getCoffee(String name) {
    var sql = "select * from coffees where product = '" + name + "'";
    var newString = sql.replace("\"", "'");

    return jdbcTemplate.query(newString,
        (rs, rowNum) -> new Coffee(rs.getString("product"), rs.getString("brand"), rs.getDouble("price"), rs.getString("image"), rs.getString("type")));
  }

  public List<Object> getUniqueNames() {
    var sql = "select distinct type from coffees";
    List<Object> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> rs.getString("type")
    );
    return arrayList;
  }

  public List<Object> getPrices() {
    var sql = "select distinct price from coffees";
    List<Object> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> rs.getDouble("price")
    );
    return arrayList;
  }

  public List<User> loginUser(String line) {
    String[] parts = line.split(",");
    String[] username = parts[0].split(":");
    String[] password = parts[1].split(":");
    String sql = "select * from login where username=" + username[1] + " and password=" + password[1].replace("}", "") + "";
    var newString = sql.replace("\"", "'");
    List<User> arrayList;
    arrayList = jdbcTemplate.query(newString,
        (rs, rowNum) -> new User(rs.getString("username"), rs.getString("password"), rs.getInt("admin")));
    return arrayList;
  }
}
