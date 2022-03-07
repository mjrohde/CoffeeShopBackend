package com.example.backends.repository;

import com.example.backends.model.Coffee;
import com.example.backends.model.CoffeeType;
import com.example.backends.model.User;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
        (rs, rowNum) -> new User(rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("tlf"), rs.getInt("admin")));
    return arrayList;
  }

  public boolean createUser(String data) {
    var successful = false;

    String[] parts = data.split(",");
    String[] username = parts[0].split(":");
    String[] password = parts[1].split(":");
    String[] name = parts[2].split(":");
    String[] email = parts[3].split(":");
    String[] tlf = parts[4].split(":");
    String query = "select * from login where username=" + username[1].toLowerCase() + "";
    var newString = query.replace("\"", "'");

    List<User> arrayList = jdbcTemplate.query(newString,
        (rs, rowNum) -> new User(rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("email"), rs.getString("tlf"), rs.getInt("admin"))
    );

    if (arrayList.isEmpty()) {
      var admin = 0;
      var sql = "INSERT INTO login (username, password, name, email, tlf, admin) Values (:username, :password, :name, :email, :tlf, :admin)";
      SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("username", username[1].toLowerCase().replace("\"", "")).addValue("password", password[1].replace("\"", "")).addValue("name", name[1].replace("\"", "")).addValue("email", email[1].replace("\"", "")).addValue("tlf", tlf[1].replace("\"", "")).addValue("admin", admin);
      int status = jdbcTemplate.update(sql, namedParameters);
      if (status != 0) {
        successful = true;
      }
    }
    return successful;
  }

  public List<CoffeeType> getCoffeeTypes() {
    var sql = "select * from coffeetypes";
    List<CoffeeType> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs,rowNum) -> new CoffeeType(rs.getInt("id"), rs.getString("name"), rs.getString("brand")));
    return arrayList;

  }

  public boolean deleteUser(String line) {
    String[] parts = line.split(":");
    String temp = parts[1];
    String username = temp.replace("}", "").replace("\"", "");
    System.out.println(username);
    var successful = false;
    var sql = "delete from login where username=:username";
    System.out.println(sql);

    SqlParameterSource sps = new MapSqlParameterSource().addValue("username", username);
    int status = jdbcTemplate.update(sql,sps);

    if (status != 0) {
      successful = true;
    }
    return successful;
  }
}
