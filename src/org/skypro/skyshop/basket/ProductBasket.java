package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount >= products.length) {
            System.out.println("Корзина заполнена. Максимальный размер: " + products.length + " товаров");
            return;
        }
        products[productCount] = product;
        productCount++;
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printContents() {
        if (productCount == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (int i = 0; i < productCount; i++) {
            Product product = products[i];
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        productCount = 0;
    }
}