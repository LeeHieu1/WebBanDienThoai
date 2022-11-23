package com.nhom13.repository.custom;

import java.util.List;

import com.nhom13.model.Book;
import com.nhom13.utility.Page;

public interface SearchRepositoryCustom {

    public List<Book> getSearchBook(String name, String authorName, Long category, Long minPrice, Long maxPrice,
            Page page);

    public Long getCountSearchBook(String name, String authorName, Long category, Long minPrice, Long maxPrice);
}
