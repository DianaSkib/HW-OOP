package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.search.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        System.out.println("=== ДЕМОНСТРАЦИЯ ПРОВЕРОК ДАННЫХ ===");
        try {
            Product invalidProduct1 = new Product("", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания продукта: " + e.getMessage());
        }

        try {
            Product invalidProduct2 = new SimpleProduct("Наушники", -500);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания простого продукта: " + e.getMessage());
        }

        try {
            Product invalidProduct3 = new DiscountedProduct("Мышь", 1000, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка создания товара со скидкой: " + e.getMessage());
        }

        System.out.println();

        Product product1 = new SimpleProduct("Смартфон", 25000);
        Product product2 = new DiscountedProduct("Ноутбук", 50000, 15);
        Product product3 = new SimpleProduct("Клавиатура", 3000);


        ProductBasket basket = new ProductBasket();

        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ КОРЗИНЫ С НОВЫМИ ТИПАМИ ТОВАРОВ ===");

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

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

        System.out.println("\n\n=== ТЕСТИРОВАНИЕ МЕТОДА FINDBESTMATCH ===");

        System.out.println("--- Сценарий 1: поиск существующего объекта ---");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Ноутбук");
            System.out.println("Лучший результат для запроса 'Ноутбук': " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        searchEngine.add(new Article("Ноутбук: обзор и сравнение моделей ноутбуков 2024",
                "Подробный обзор различных моделей ноутбуков, сравнение характеристик ноутбуков"));

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Ноутбук");
            System.out.println("Лучший результат для запроса 'Ноутбук' (после добавления статьи с множественными вхождениями): " +
                    bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n--- Сценарий 2: поиск несуществующего объекта ---");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Квантовый компьютер");
            System.out.println("Лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        //доп.тест
        System.out.println("\n--- Тест с пустым запросом ---");
        try {
            Searchable bestMatch = searchEngine.findBestMatch("");
            System.out.println("Лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}