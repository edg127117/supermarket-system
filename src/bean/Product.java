package bean;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
  private String id;
  private String name;
  private double price;
  private int count;
  public String typeId;

  public Product() {
  }

  public Product(String id, String name, double price, int count, String typeId) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.count = count;
    this.typeId = typeId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  public String toString() {
    return String.format("%s (ID: %s) - 价格: ¥%.2f - 库存: %d - 类别ID: %s",
            name, id, price, count, typeId);
  }
}
