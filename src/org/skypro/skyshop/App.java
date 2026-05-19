package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.*;

import java.util.Arrays;

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

        System.out.println("\n\n=== ТЕСТИРОВАНИЕ ПОИСКА ===");


        Product product6 = new Product("Смартфон", 25000);
        Product product7 = new Product("Ноутбук", 50000);
        Product product8 = new Product("Наушники", 5000);


        Article article1 = new Article("Обзор смартфона", "Отличный смартфон с хорошей камерой");
        Article article2 = new Article("Как выбрать ноутбук", "Советы по выбору ноутбука для работы");


        SearchEngine searchEngine = new SearchEngine(10);


        searchEngine.add(new Product("Смартфон Samsung", 25000));
        searchEngine.add(new Product("Ноутбук Dell", 60000));
        searchEngine.add(new Product("Наушники Sony", 5000));
        searchEngine.add(new Product("Планшет Apple", 45000));


        searchEngine.add(new Article("Обзор смартфонов", "В этом обзоре рассмотрим лучшие смартфоны 2024 года"));
        searchEngine.add(new Article("Технологии будущего", "Искусственный интеллект и машинное обучение становятся всё популярнее"));
        searchEngine.add(new Article("Ноутбуки для работы", "Как выбрать ноутбук для офисной работы и учёбы"));


        System.out.println("Поиск по запросу 'Смартфон':");
        System.out.println(Arrays.toString(searchEngine.search("Смартфон")));

        System.out.println("\nПоиск по запросу 'Ноутбук':");
        System.out.println(Arrays.toString(searchEngine.search("Ноутбук")));

        System.out.println("\nПоиск по запросу 'ИИ':");
        System.out.println(Arrays.toString(searchEngine.search("ИИ")));

        System.out.println("\nПоиск по запросу 'Apple':");
        System.out.println(Arrays.toString(searchEngine.search("Apple")));
    }
}