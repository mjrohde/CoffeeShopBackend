package com.example.backends.repository;

import com.example.backends.model.Coffee;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Adds new product to the Database
   *
   * @param data Product
   * @return true or false
   */
 /** public Boolean addFemaleToDataBase(String data) {
    var successful = false;

    String[] parts = data.split(",");
    String[] productName = parts[0].split(":");
    String[] description = parts[1].split(":");
    String[] imageParts = parts[2].split(":");
    String image = imageParts[1] + ":" + imageParts[2];
    String[] productPrice = parts[3].split(":");

    var sql = "INSERT INTO female (name, club, hot, nation, image, age) Values (:name, :club, :hot, :nation: :image, :price)";
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", productName[1].replace("\"", "")).addValue("desc", description[1].replace("\"", "")).addValue("image", image.replace("\"", "")).addValue("price", productPrice[1].replace("\"", "").replace("}", ""));
    int status = jdbcTemplate.update(sql, namedParameters);
    if (status != 0) {
      successful = true;
    }

    return successful;
  }
  **/


  /**
   * Gets all the brands available from database
   * @return Arraylist
   */
  public List<Coffee> getPopularCoffees() {
    var sql = "select * from coffees limit 4";
    List<Coffee> arrayList;

    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> new Coffee(rs.getString("product"), rs.getString("brand"), rs.getDouble("price"), rs.getString("image"))
  );
    return arrayList;
  }

  public List<Coffee> getAllCoffees(){
    var sql = "select * from coffees";
    List<Coffee> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> new Coffee(rs.getString("product"), rs.getString("brand"), rs.getDouble("price"), rs.getString("image") )
    );
    return arrayList;
  }

  public List<Object> getUniqueNames() {
    var sql = "select distinct product from coffees";
    List<Object> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> rs.getString("product")
    );
    return arrayList;
  }

  public List<Object> getPrices() {
    var sql = "select distinct price from coffees";
    List<Object> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs,rowNum) -> rs.getDouble("price")
    );
    return arrayList;
  }
  /**

  public List<WeaponSkins> getWeaponSkins(){
    var sql = "select * from weaponskins";
    List<WeaponSkins> arrayList;
    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> new WeaponSkins(rs.getString("name"), rs.getString("weapon"), rs.getString("type"))
    );
    return arrayList;
  }
 */

  /**
   * Returns products that are made by a specific brand.
   * @param
   * @return Arraylist
   */
  /**
  public List<Product> getLegendSkins(String name) {
    var sql = "select * from products where brand = '" + name + "'";
    var newString = sql.replace("\"", "'");

    return jdbcTemplate.query(newString,
        (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("brand"), rs.getString("image"), rs.getString("clubType"), rs.getString("model"), rs.getString("altImage"), rs.getString("price"), rs.getString("description"))
    );
  }

  public List<Product> getBrandFromDatabase(String name) {
    var sql = "select * from products where brand = '" + name + "'";
    List<Product> arrayList;

    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("brand"), rs.getString("image"), rs.getString("clubType"), rs.getString("model"), rs.getString("altImage"), rs.getString("price"), rs.getString("description"))
    );
    return arrayList;
  }
  public List<Product> getProduct(String id) {
    var sql = "select * from products where id=" + id + "";
    List<Product> arrayList;

    arrayList = jdbcTemplate.query(sql,
        (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("brand"), rs.getString("image"), rs.getString("clubType"), rs.getString("model"), rs.getString("altImage"), rs.getString("price"), rs.getString("description"))
    );
    return arrayList;
  }
   **/
}
