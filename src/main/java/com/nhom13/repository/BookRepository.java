package com.nhom13.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nhom13.model.Book;
import com.nhom13.repository.custom.SearchRepositoryCustom;

@Repository

public interface BookRepository extends JpaRepository<Book, Long>, SearchRepositoryCustom {

}
