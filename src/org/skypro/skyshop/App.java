package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Смартфон", 25000);
        Product product2 = new DiscountedProduct("Ноутбук", 50000, 15);
        Product product3 = new FixPriceProduct("Наушники");
        Product product4 = new DiscountedProduct("Мышь", 1500, 20);
        Product product5 = new SimpleProduct("Клавиатура", 3000);

        ProductBasket basket = new ProductBasket();

        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КОРЗИНЫ С НОВЫМИ ТИПАМИ ТОВАРОВ ===");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        System.out.println("\nСодержимое корзины:");
        basket.printContents();

        System.out.println("\nОбщая стоимость корзины: " + basket.getTotalCost() + " руб.");

        System.out.println("\nПоиск 'Ноутбук': " + (basket.containsProduct("Ноутбук") ? "найден" : "не найден"));
        System.out.println("Поиск 'Планшет': " + (basket.containsProduct("Планшет") ? "найден" : "не найден"));

        System.out.println("\nОчищаем корзину...");
        basket.clear();

        System.out.println("Содержимое пустой корзины:");
        basket.printContents();
    }
}