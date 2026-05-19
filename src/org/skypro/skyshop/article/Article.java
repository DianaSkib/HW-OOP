package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;


public class Article implements Searchable {
    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return "Article{title='" + title + "', text='" + text + "'}";
    }
}