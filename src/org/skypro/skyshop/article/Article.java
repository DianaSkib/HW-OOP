package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;


public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getStringRepresentation() {
        return title + " " + text;
    }

    @Override
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return "Article: " + title + " - " + text;
    }
}