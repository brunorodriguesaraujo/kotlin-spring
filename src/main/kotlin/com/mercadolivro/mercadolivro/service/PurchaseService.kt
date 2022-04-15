package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.model.PurchaseModel
import com.mercadolivro.mercadolivro.repository.PurchaseRepository
import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val repository: PurchaseRepository
) {

    fun create(purchaseModel: PurchaseModel) {
        repository.save(purchaseModel)
    }

}
