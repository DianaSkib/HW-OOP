package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] items;
    private int count;

    public SearchEngine(int size) {
        this.items = new Searchable[size];
        this.count = 0;
    }

    public void add(Searchable item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("Массив переполнен, невозможно добавить элемент");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            Searchable item = items[i];
            if (item.getSearchTerm().contains(query)) {
                results[resultCount++] = item;
                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }
}