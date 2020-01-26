package org.itstep;

import java.util.Objects;

public class Cd {
    private String title;
    private int price;

    public Cd(String title) {
        this.title = title;
    }

    public Cd(String title, int price) {
        this(title);
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cd cd = (Cd) o;
        return Objects.equals(title, cd.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }

    @Override
    public String toString() {
        return "Cd{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
