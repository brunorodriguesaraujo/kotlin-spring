package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.enums.BookStatus
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomerModel
import com.mercadolivro.mercadolivro.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun createBook(book: BookModel) {
        repository.save(book)
    }

    fun findAll(pageable: Pageable): Page<BookModel> {
        return repository.findAll(pageable)
    }

    fun findActives(pageable: Pageable): Page<BookModel> {
        return repository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun findById(id: Int): BookModel {
        return repository.findById(id).orElseThrow()
    }

    fun update(book: BookModel) {
        repository.save(book)
    }

    fun delete(id: Int) {
        val book = findById(id)
        book.status = BookStatus.DELETADO
        repository.save(book)
    }

    fun deleteByCustomer(customer: CustomerModel) {
        val books = repository.findByCustomer(customer)
        books.forEach {
            it.status = BookStatus.DELETADO
        }
        repository.saveAll(books)
    }


}
