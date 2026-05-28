package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public class Product implements Searchable {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
        this.name = name;
        this.price = price;
    }


    public Product(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return getName();
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }

    public boolean isSpecial() {
        return false;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}