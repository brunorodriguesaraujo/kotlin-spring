package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.enums.BookStatus
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomerModel
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>

}
