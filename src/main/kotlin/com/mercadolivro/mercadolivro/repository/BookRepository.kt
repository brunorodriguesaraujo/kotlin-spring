package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.model.BookModel
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<BookModel, Int> {

}
