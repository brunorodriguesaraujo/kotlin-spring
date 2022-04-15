package com.mercadolivro.mercadolivro.service

import com.mercadolivro.mercadolivro.events.PurchaseEvent
import com.mercadolivro.mercadolivro.model.PurchaseModel
import com.mercadolivro.mercadolivro.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PurchaseService(
    private val repository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) {

    @Transactional
    fun create(purchaseModel: PurchaseModel) {
        repository.save(purchaseModel)
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
    }

    fun update(purchaseModel: PurchaseModel) {
        repository.save(purchaseModel)
    }

}
