package bean;

import java.util.Objects;

public class Cashier {
    private int id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String phoneNumber;

    public Cashier() {
    }

    public Cashier(int id, String username, String password, String name, String sex, Integer age, String address, String phoneNumber) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return id == cashier.id && Objects.equals(username, cashier.username) && Objects.equals(password, cashier.password) && Objects.equals(name, cashier.name) && Objects.equals(sex, cashier.sex) && Objects.equals(age, cashier.age) && Objects.equals(address, cashier.address) && Objects.equals(phoneNumber, cashier.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, sex, age, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
