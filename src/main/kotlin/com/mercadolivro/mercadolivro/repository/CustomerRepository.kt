package com.mercadolivro.mercadolivro.repository

import com.mercadolivro.mercadolivro.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<CustomerModel, Int> {
    fun findByNameContaining(name: String, pageable: Pageable): Page<CustomerModel>
}