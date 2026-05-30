package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printContents() {
        if (products.isEmpty()){
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (Product product : products) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        products.clear();

    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                iterator.remove(); // Удаляем из списка через итератор
                removedProducts.add(product); // Сохраняем удаленный продукт
            }
        }
        return removedProducts;
    }
}