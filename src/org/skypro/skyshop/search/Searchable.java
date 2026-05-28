package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getStringRepresentation();

    String getName();
}