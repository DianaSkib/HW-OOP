package org.skypro.skyshop.search;
import org.skypro.skyshop.search.Searchable;
import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();


    public void add(Searchable item) {
        items.add(item);
    }

public List<Searchable> search(String query) {
    List<Searchable> results = new ArrayList<>();

    for (Searchable item : items) {
        if (item.getSearchTerm().contains(query)) {
            results.add(item); // Добавляем все подходящие, без ограничения в 5
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

        for (int i = 0; i < items.size(); i++) {
            Searchable item = items.get(i);
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