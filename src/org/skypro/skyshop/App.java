package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Смартфон", 25000);
        Product product2 = new Product("Ноутбук", 50000);
        Product product3 = new Product("Наушники", 5000);
        Product product4 = new Product("Мышь", 1500);
        Product product5 = new Product("Клавиатура", 3000);
        Product product6 = new Product("Монитор", 15000); // Для теста переполнения

        ProductBasket basket = new ProductBasket();

        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КОРЗИНЫ ===");

        System.out.println("\n1. Добавляем товары в корзину:");
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        System.out.println("\n2. Добавляем ещё товары (включая тест переполнения):");
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        System.out.println("\n3. Содержимое корзины:");
        basket.printContents();

        System.out.println("\n4. Общая стоимость корзины: " + basket.getTotalCost() + " руб.");

        System.out.println("\n5. Поиск 'Ноутбук': " + (basket.containsProduct("Ноутбук") ? "найден" : "не найден"));

        System.out.println("6. Поиск 'Планшет': " + (basket.containsProduct("Планшет") ? "найден" : "не найден"));

        System.out.println("\n7. Очищаем корзину...");
        basket.clear();

        System.out.println("8. Содержимое пустой корзины:");
        basket.printContents();

        System.out.println("9. Стоимость пустой корзины: " + basket.getTotalCost() + " руб.");

        System.out.println("10. Поиск 'Смартфон' в пустой корзине: " +
                (basket.containsProduct("Смартфон") ? "найден" : "не найден"));
    }
}
