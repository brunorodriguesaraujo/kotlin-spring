package com.mercadolivro.mercadolivro.extension

import com.mercadolivro.mercadolivro.controller.request.PostBookRequest
import com.mercadolivro.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.mercadolivro.controller.request.PutBookRequest
import com.mercadolivro.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.mercadolivro.controller.response.BookResponse
import com.mercadolivro.mercadolivro.controller.response.CustomerResponse
import com.mercadolivro.mercadolivro.enums.BookStatus
import com.mercadolivro.mercadolivro.enums.CustomerStatus
import com.mercadolivro.mercadolivro.model.BookModel
import com.mercadolivro.mercadolivro.model.CustomerModel

fun PostCustomerRequest.toCustomModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ATIVO
    )
}

fun PutCustomerRequest.toCustomModel(customerLast: CustomerModel): CustomerModel {
    return CustomerModel(
        id = customerLast.id,
        name = this.name ?: customerLast.name,
        email = this.email ?: customerLast.email,
        status = customerLast.status
    )
}

fun PostBookRequest.toBookModel(customerModel: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customerModel
    )
}

fun PutBookRequest.toBookModel(bookModel: BookModel): BookModel {
    return BookModel(
        id = bookModel.id,
        name = this.name ?: bookModel.name,
        price = this.price ?: bookModel.price,
        status = bookModel.status,
        customer = bookModel.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        status = this.status,
        customer = this.customer
    )
}