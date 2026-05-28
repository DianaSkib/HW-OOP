package org.skypro.skyshop.search;

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
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isBlank()) {
            throw new BestResultNotFound("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxOccurrences = -1;

        for (int i = 0; i < count; i++) {
            Searchable item = items[i];
            String searchTerm = item.getSearchTerm();
            int occurrences = countOccurrences(searchTerm, search);

            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: '" + search + "'");
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        while (index <= str.length() - substringLength) {
            int foundIndex = str.indexOf(substring, index);
            if (foundIndex == -1) {
                break;
            }
            count++;
            index = foundIndex + substringLength;
        }
        return count;
    }
}
