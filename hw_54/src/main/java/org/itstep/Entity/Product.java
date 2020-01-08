package org.itstep.Entity;

import java.util.Objects;

public class Product {
    private int id;
    private String type;
    private String title;
    private int quantity;
    private double price;
    private int sellerId;

    public Product(int id, String type, String title, double price, int sellerId){
        this.id = id;
        this.type = type;
        this.title = title;
        this.price = price;
        this.sellerId = sellerId;
    }

    public Product(String type, String title, int quantity, double price, int sellerId) {
        this.type = type;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.sellerId = sellerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int selerId) {
        this.sellerId = selerId;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", sellerId=" + sellerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                sellerId == product.sellerId &&
                Objects.equals(type, product.type) &&
                Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, title, quantity, price, sellerId);
    }
}
