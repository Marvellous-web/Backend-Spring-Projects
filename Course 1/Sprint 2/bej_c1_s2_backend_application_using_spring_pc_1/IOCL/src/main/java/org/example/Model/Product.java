package org.example.Model;

public class Product {
    String prod_name,prod_cat;
    int prod_price;

    public Product() {
    }

    public Product(String prod_name, String prod_cat, int prod_price) {
        this.prod_name = prod_name;
        this.prod_cat = prod_cat;
        this.prod_price = prod_price;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_cat() {
        return prod_cat;
    }

    public void setProd_cat(String prod_cat) {
        this.prod_cat = prod_cat;
    }

    public int getProd_price() {
        return prod_price;
    }

    public void setProd_price(int prod_price) {
        this.prod_price = prod_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prod_name='" + prod_name + '\'' +
                ", prod_cat='" + prod_cat + '\'' +
                ", prod_price=" + prod_price +
                '}';
    }
}
