package com.gaja.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaja.app.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}