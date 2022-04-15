package com.mercadolivro.mercadolivro.events

import com.mercadolivro.mercadolivro.model.PurchaseModel
import org.springframework.context.ApplicationEvent

class PurchaseEvent(
    source: Any,
    val model: PurchaseModel
) : ApplicationEvent(source) {
}