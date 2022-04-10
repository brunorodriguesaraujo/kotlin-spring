package com.mercadolivro.mercadolivro.controller

import com.mercadolivro.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.mercadolivro.extension.toBookModel
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.service.BookService
import com.mercadolivro.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("book")
class BookController(
    val bookService: BookService,
    val customer: CustomerService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createBook(@RequestBody book: PostBookRequest) {
        bookService.createBook(book.toBookModel(customer.findById(book.customerId)))
    }

    @GetMapping
    fun getAll(): List<BookModel> {
        return bookService.findAll()
    }

    @GetMapping("/active")
    fun getActives(): List<BookModel> {
        return bookService.findActives()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): BookModel {
        return bookService.findById(id)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest){
        val bookModel = bookService.findById(id)
        bookService.update(book.toBookModel(bookModel))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }
}